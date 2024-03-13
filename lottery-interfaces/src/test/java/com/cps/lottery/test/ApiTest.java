package com.cps.lottery.test;

import com.alibaba.fastjson.JSON;
import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.award.model.req.GoodsReq;
import com.cps.lottery.domain.award.model.res.DistributionRes;
import com.cps.lottery.domain.award.service.factory.DistributionGoodsFactory;
import com.cps.lottery.domain.award.service.goods.IDistributionGoods;
import com.cps.lottery.domain.strategy.model.req.DrawReq;
import com.cps.lottery.domain.strategy.model.res.DrawResult;
import com.cps.lottery.domain.strategy.model.vo.DrawAwardInfo;
import com.cps.lottery.domain.strategy.service.draw.IDrawExec;
import com.cps.lottery.infrastructure.dao.IActivityDao;

import com.cps.lottery.infrastructure.dao.IStrategyDao;
import com.cps.lottery.infrastructure.dao.IStrategyDetailDao;
import com.cps.lottery.infrastructure.po.Activity;
import com.cps.lottery.infrastructure.po.Strategy;
import com.cps.lottery.infrastructure.po.StrategyDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/7 16:11
 * @OtherDescription: Other things
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    IActivityDao activityDao;

    @Resource
    IStrategyDao strategyDao;

    @Resource
    IStrategyDetailDao strategyDetail;

    @Resource
    private IDrawExec drawExec;

    @Resource
    private DistributionGoodsFactory distributionGoodsFactory;

    @Test
    public void test_award() {
        //执行抽奖

        DrawResult drawResult = drawExec.doDrawExec(new DrawReq("cps", 10002L));

        //判断抽奖结果
        Integer drawState = drawResult.getDrawState();
        if(drawState.equals(Constants.DrawState.FAIL.getCode())){
            //如果没中奖
            logger.info("很遗憾！用户: {}  没有中奖", drawResult.getuId());
            return;
        }

        //发奖参数，orderId属于模拟ID，在用户领奖的时候时生成
        DrawAwardInfo drawAwardInfo = drawResult.getDrawAwardInfo();
        GoodsReq goodsReq = new GoodsReq(drawResult.getuId(), "21024920081392", drawAwardInfo.getAwardId(), drawAwardInfo.getAwardName(), drawAwardInfo.getAwardContent());

        //根据awardType从抽奖工程中获取对应的发奖服务
        IDistributionGoods distributionGoodsService = distributionGoodsFactory.getDistributionGoodsService(drawAwardInfo.getAwardType());
        DistributionRes distributionRes = distributionGoodsService.doDistribution(goodsReq);
        logger.info("测试结果：{}", JSON.toJSONString(distributionRes));
    }
    @Test
    public void test_drawExec(){
        drawExec.doDrawExec(new DrawReq("cps",10002L));
        drawExec.doDrawExec(new DrawReq("jack",10002L));
        drawExec.doDrawExec(new DrawReq("Tom",10002L));
        drawExec.doDrawExec(new DrawReq("smith",10002L));
        drawExec.doDrawExec(new DrawReq("kite",10002L));
    }
    @Test
    public void test_insert(){
        Activity activity = new Activity();
        activity.setActivityId(100002L);
        activity.setActivityName("测试活动");
        activity.setActivityDesc("仅用于插入数据测试");
        activity.setBeginDateTime(new Date());
        activity.setEndDataTime(new Date());
        activity.setStockCount(100);
        activity.setTakeCount(10);
        activity.setState(0);
        activity.setCreator("cps");
        activityDao.insert(activity);
    }

    @Test
    public void test_select(){
        Activity activity = activityDao.queryActivityById(120981322L);
        logger.info("查询结果：{}" , JSON.toJSONString(activity));
    }

    @Test
    public void test_Strategy(){
        Strategy strategy = strategyDao.queryStrategy(10002L);
        System.out.println(strategy);
    }

    @Test
    public void test_StrategyDetail(){
        List<StrategyDetail> strategyDetails = strategyDetail.queryStrategyDetailList(10002L);
        for(StrategyDetail strategyDetail: strategyDetails){
            System.out.println(strategyDetail);
        }
    }
}
