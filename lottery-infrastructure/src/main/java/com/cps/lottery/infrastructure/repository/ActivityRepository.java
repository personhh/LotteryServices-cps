package com.cps.lottery.infrastructure.repository;

import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.activity.model.req.PartakeReq;
import com.cps.lottery.domain.activity.model.res.StockResult;
import com.cps.lottery.domain.activity.model.vo.*;
import com.cps.lottery.domain.activity.repository.IActivityRepository;
import com.cps.lottery.infrastructure.dao.*;
import com.cps.lottery.infrastructure.po.*;
import com.cps.lottery.infrastructure.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/14 13:12
 * @OtherDescription: Other things
 */

@Component
public class ActivityRepository implements IActivityRepository {

    private Logger logger = LoggerFactory.getLogger(ActivityRepository.class);
    @Resource
    private IActivityDao activityDao;
    @Resource
    private IAwardDao awardDao;
    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IStrategyDetailDao strategyDetailDao;
    @Resource
    private IUserTakeActivityCountDao userTakeActivityCountDao;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public void addActivity(ActivityVO activityVO) {
        Activity req = new Activity();
        BeanUtils.copyProperties(activityVO, req);
        activityDao.insert(req);
    }

    @Override
    public void addAward(List<AwardVO> awardList) {
        ArrayList<Award> req = new ArrayList<>();
        for(AwardVO awardVO : awardList){
            Award award = new Award();
            BeanUtils.copyProperties(awardVO, award);
            req.add(award);
        }
        awardDao.insertList(req);

    }

    @Override
    public void addStrategy(StrategyVO strategyVO) {
        Strategy req = new Strategy();
        BeanUtils.copyProperties(strategyVO, req);
        strategyDao.insert(req);
    }

    @Override
    public void addStrategyDetailLast(List<StrategyDetailVO> strategyDetailList) {
        List<StrategyDetail> req = new ArrayList<>();
        for(StrategyDetailVO strategyDetailVO : strategyDetailList){
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtils.copyProperties(strategyDetailVO, strategyDetail);
            req.add(strategyDetail);
        }
        strategyDetailDao.insertList(req);
    }

    @Override
    public boolean alterState(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId,((Constants.ActivityState) beforeState).getCode(),((Constants.ActivityState) afterState).getCode());
        int count = activityDao.alterState(alterStateVO);
        return 1 == count;
    }

    @Override
    public ActivityBillVO queryActivityBill(PartakeReq req) {

        //查询活动信息
        Activity activity = activityDao.queryActivityById(req.getActivityId());

        //查询领取次数
        UserTakeActivityCount userTakeActivityCountReq = new UserTakeActivityCount();
        userTakeActivityCountReq.setuId(req.getuId());
        userTakeActivityCountReq.setActivityId(req.getActivityId());
        UserTakeActivityCount userTakeActivityCount = userTakeActivityCountDao.queryUserTakeActivityCount(userTakeActivityCountReq);

        //封装查询结果
        ActivityBillVO activityBillVO = new ActivityBillVO();
        activityBillVO.setuId(req.getuId());
        activityBillVO.setActivityId(req.getActivityId());
        activityBillVO.setActivityName(activity.getActivityName());
        activityBillVO.setBeginDateTime(activity.getBeginDateTime());
        activityBillVO.setEndDateTime(activity.getEndDataTime());
        activityBillVO.setTakeCount(activity.getTakeCount());
        activityBillVO.setStockSurplusCount(activity.getStockSurplusCount());
        activityBillVO.setStrategyId(activity.getStrategyId());
        activityBillVO.setState(activity.getState());
        activityBillVO.setUserTakeLeftCount(null == userTakeActivityCount ? null : userTakeActivityCount.getLeftCount());
        return activityBillVO;
    }

    @Override
    public int subtractionActivityStock(Long activityId) {
        return activityDao.subtractionActivityStock(activityId);
    }

    @Override
    public List<ActivityVO> scanToDoActivityList(Long id) {
        List<Activity> activityList = activityDao.scanToDoActivityList(id);
        List<ActivityVO> activityVOList = new ArrayList<>(activityList.size());
        for (Activity activity : activityList) {
            ActivityVO activityVO = new ActivityVO();
            activityVO.setId(activity.getId());
            activityVO.setActivityId(activity.getActivityId());
            activityVO.setActivityName(activity.getActivityName());
            activityVO.setBeginDateTime(activity.getBeginDateTime());
            activityVO.setEndDateTime(activity.getEndDataTime());
            activityVO.setState(activity.getState());
            activityVOList.add(activityVO);
        }
        return activityVOList;
    }

    @Override
    public StockResult subtractionActivityStockByRedis(String uId, Long activityId, Integer stockCount) {
        //1.获取抽奖活动库存 Key
        String stockKey = Constants.RedisKey.KEY_LOTTERY_ACTIVITY_STOCK_COUNT(activityId);

        //2.扣减库存，目前占用库存
        Integer stockUsedCount  = (int) redisUtil.incr(stockKey, 1);

        //3.超出库存判断，进行恢复原始库存
        if(stockUsedCount > stockCount){
            redisUtil.decr(stockKey, 1);
            return new StockResult(Constants.ResponseCode.OUT_OF_STOCK.getCode(), Constants.ResponseCode.OUT_OF_STOCK.getInfo());
        }

        //4.以活动库存占用编号，生成对应加锁Key，细化锁的颗粒度
        String stockTokenKey = Constants.RedisKey.KEY_LOTTERY_ACTIVITY_STOCK_COUNT_TOKEN(activityId, stockUsedCount);

        //5.使用Redis.setNx 加一个分布式锁
        boolean lockToken = redisUtil.setNx(stockTokenKey, 350L);
        if(!lockToken){
            logger.info("抽奖活动{} 用户秒杀{} 扣减库存，分布式锁失败：{}", activityId, uId, stockTokenKey);
            return new StockResult(Constants.ResponseCode.ERR_TOKEN.getCode(), Constants.ResponseCode.ERR_TOKEN.getInfo());
        }

        return new StockResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo(), stockTokenKey, stockCount - stockUsedCount);
    }

    @Override
    public void recoverActivityCacheStockByRedis(Long activityId, String tokenKey, String code) {
        redisUtil.del(tokenKey);
    }
}
