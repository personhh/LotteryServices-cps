package com.cps.lottery.domain.activity.service.partake;

import com.cps.lottery.common.Constants;
import com.cps.lottery.common.Result;
import com.cps.lottery.domain.activity.model.req.PartakeReq;
import com.cps.lottery.domain.activity.model.res.PartakeResult;
import com.cps.lottery.domain.activity.model.res.StockResult;
import com.cps.lottery.domain.activity.model.vo.ActivityBillVO;
import com.cps.lottery.domain.activity.model.vo.UserTakeActivityVO;
import com.cps.lottery.domain.support.ids.IIdGenerator;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/21 16:34
 * @OtherDescription: Other things
 */
public abstract class BaseActivityPartake extends ActivityPartakeSupport implements  IActivityPartake {

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;
    @Override
    public PartakeResult doPartake(PartakeReq req) {
        // 1. 查询是否存在未执行抽奖领取活动单【user_take_activity 存在 state = 0，领取了但抽奖过程失败的，可以直接返回领取结果继续抽奖】
        UserTakeActivityVO userTakeActivityVO = this.queryNoConsumedTakeActivityOrder(req.getActivityId(), req.getuId());
        if (null != userTakeActivityVO) {
            return buildPartakeResult (userTakeActivityVO.getStrategyId(), userTakeActivityVO.getTakeId());
        }
        //查询活动账单
        ActivityBillVO activityBillVO = super.queryActivityBill(req);

        //活动配置校验处理【活动库存、状态、日期、个人参与次数】
        Result checkResult = this.checkActivityBill(req, activityBillVO);
        if(!Constants.ResponseCode.SUCCESS.getCode().equals(checkResult.getCode())){
            return new PartakeResult(checkResult.getCode(), checkResult.getInfo());
        }

        //扣减活动库存 （目前之前扣减表中数据，后续转化redis扣减）
        StockResult subtractionActivityResult = this.subtractionActivityStockByRedis(req.getuId(), req.getActivityId(), activityBillVO.getTakeCount());
        if(!Constants.ResponseCode.SUCCESS.getCode().equals(subtractionActivityResult.getCode())){
            return new PartakeResult(subtractionActivityResult.getCode(),subtractionActivityResult.getInfo());
        }

        //领取活动信息（个人用户把活动信息写入到用户表）

        Long takeId = idGeneratorMap.get(Constants.Ids.SnowFlake).nextId();
        Result grabResult = this.grabActivity(req, activityBillVO);
        if(!Constants.ResponseCode.SUCCESS.getCode().equals(grabResult.getCode())){
            return new PartakeResult(subtractionActivityResult.getCode(),subtractionActivityResult.getInfo());
        }

        //扣减活动库存，通过Redis End
        this.recoverActivityCacheStockByRedis(req.getActivityId(), subtractionActivityResult.getStockKey(), Constants.ResponseCode.SUCCESS.getCode());

        return buildPartakeResult(activityBillVO.getStrategyId(), takeId, activityBillVO.getTakeCount(), subtractionActivityResult.getStockSurplusCount(), Constants.ResponseCode.SUCCESS);
    }

    /**
     * 封装结果【返回的策略ID，用于继续完成抽奖步骤】
     *
     * @param strategyId 策略ID
     * @param takeId     领取ID
     * @return 封装结果
     */
    private PartakeResult buildPartakeResult(Long strategyId, Long takeId) {
        PartakeResult partakeResult = new PartakeResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
        partakeResult.setStrategyId(strategyId);
        partakeResult.setTakeId(takeId);
        return partakeResult;
    }

    /**
     * 封装结果【返回的策略ID，用于继续完成抽奖步骤】
     *
     * @param strategyId        策略ID
     * @param takeId            领取ID
     * @param stockCount        库存
     * @param stockSurplusCount 剩余库存
     * @param code              状态码
     * @return 封装结果
     */
    private PartakeResult buildPartakeResult(Long strategyId, Long takeId, Integer stockCount, Integer stockSurplusCount, Constants.ResponseCode code) {
        PartakeResult partakeResult = new PartakeResult(code.getCode(), code.getInfo());
        partakeResult.setStrategyId(strategyId);
        partakeResult.setTakeId(takeId);
        partakeResult.setStockCount(stockCount);
        partakeResult.setStockSurplusCount(stockSurplusCount);
        return partakeResult;
    }
    /**
     * 活动信息校验处理，把活动库存、状态、日期、个人参与次数
     *
     * @param partake 参与活动请求
     * @param bill    活动账单
     * @return 校验结果
     */
    protected abstract Result checkActivityBill(PartakeReq partake, ActivityBillVO bill);

    /**
     * 扣减活动库存
     *
     * @param req 参与活动请求
     * @return 扣减结果
     */
    protected abstract Result subtractionActivityStock(PartakeReq req);

    /**
     * 扣减活动库存，通过redis
     * @param uId 用户ID
     * @param activityId  活动号
     * @param stockCount  总库存
     * @return  扣减结果
     */
    protected abstract StockResult subtractionActivityStockByRedis(String uId, Long activityId, Integer stockCount);



    /**
     * 查询是否存在未执行抽奖领取活动单【user_take_activity 存在 state = 0，领取了但抽奖过程失败的，可以直接返回领取结果继续抽奖】
     *
     * @param activityId 活动ID
     * @param uId        用户ID
     * @return 领取单
     */
    protected abstract UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String uId);

    /**
     * 领取活动
     *
     * @param partake 参与活动请求
     * @param bill    活动账单
     * @return 领取结果
     */
    protected abstract Result grabActivity(PartakeReq partake, ActivityBillVO bill);

    /**
     * 恢复活动库存，通过Redis 【如果非常异常，则需要进行缓存库存恢复，只保证不超卖的特性，所以不保证一定能恢复占用库存，另外最终可以由任务进行补偿库存】
     * @param activity 活动ID
     * @param tokenKey 分布式 KEY 用于清理
     * @param code 状态
     *
     */
    protected abstract void recoverActivityCacheStockByRedis(Long activity, String tokenKey, String code);
}
