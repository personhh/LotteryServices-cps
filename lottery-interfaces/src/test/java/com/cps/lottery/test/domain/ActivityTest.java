package com.cps.lottery.test.domain;

import com.alibaba.fastjson.JSON;
import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import com.cps.lottery.domain.activity.model.req.ActivityConfigReq;
import com.cps.lottery.domain.activity.model.vo.ActivityVO;
import com.cps.lottery.domain.activity.model.vo.AwardVO;
import com.cps.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.cps.lottery.domain.activity.model.vo.StrategyVO;
import com.cps.lottery.domain.activity.service.deploy.IActivityDeploy;
import com.cps.lottery.domain.activity.service.stateflow.IStateHandler;
import com.cps.lottery.infrastructure.dao.IActivityDao;
import com.cps.lottery.infrastructure.po.Activity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author cps
 * @description: 活动模块测试
 * @date 2024/3/15 11:09
 * @OtherDescription: Other things
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityTest {

    Logger logger = LoggerFactory.getLogger(ActivityTest.class);
    @Resource
    private IActivityDao activityDao;

    @Resource
    private IActivityDeploy activityDeploy;

    private ActivityConfigRich activityConfigRich;

    private Long activityId = 12353567L;

    @Resource
    private IStateHandler stateHandler;

    @Before
    public void init(){

        /** 初始化活动 */
        ActivityVO activity = new ActivityVO();
        activity.setActivityId(activityId);
        activity.setActivityName("测试活动-双色球");
        activity.setActivityDesc("测试活动描述-抓两种颜色的球");
        activity.setBeginDateTime(new Date());
        activity.setEndDateTime(new Date());
        activity.setStockCount(1000);
        activity.setTakeCount(100);
        activity.setState(Constants.ActivityState.EDIT.getCode());
        activity.setCreator("cps");

        /** 初始化策略 */
        StrategyVO strategy = new StrategyVO();
        strategy.setStrategyId(10005L);
        strategy.setStrategyDesc("抽奖策略-测试");
        strategy.setStrategyMode(Constants.StrategyMode.SINGLE.getCode());
        strategy.setGrantType(1);
        strategy.setGrantDate(new Date());
        strategy.setExtInfo("");

        /** 初始化策略细节 */
        StrategyDetailVO strategyDetail_01 = new StrategyDetailVO();
        strategyDetail_01.setStrategyId(strategy.getStrategyId());
        strategyDetail_01.setAwardId("10100");
        strategyDetail_01.setAwardName("一等奖");
        strategyDetail_01.setAwardCount(10);
        strategyDetail_01.setAwardSurplusCount(10);
        strategyDetail_01.setAwardRate(new BigDecimal("0.05"));

        StrategyDetailVO strategyDetail_02 = new StrategyDetailVO();
        strategyDetail_02.setStrategyId(strategy.getStrategyId());
        strategyDetail_02.setAwardId("10200");
        strategyDetail_02.setAwardName("二等奖");
        strategyDetail_02.setAwardCount(20);
        strategyDetail_02.setAwardSurplusCount(20);
        strategyDetail_02.setAwardRate(new BigDecimal("0.15"));

        StrategyDetailVO strategyDetail_03 = new StrategyDetailVO();
        strategyDetail_03.setStrategyId(strategy.getStrategyId());
        strategyDetail_03.setAwardId("10300");
        strategyDetail_03.setAwardName("三等奖");
        strategyDetail_03.setAwardCount(50);
        strategyDetail_03.setAwardSurplusCount(50);
        strategyDetail_03.setAwardRate(new BigDecimal("0.20"));

        /** 初始化策略明细列表 */
        List<StrategyDetailVO> strategyDetailList = new ArrayList<>();
        strategyDetailList.add(strategyDetail_01);
        strategyDetailList.add(strategyDetail_02);
        strategyDetailList.add(strategyDetail_03);

        strategy.setStrategyDetailList(strategyDetailList);

        /** 初始化奖品 */
        AwardVO award_01 = new AwardVO();
        award_01.setAwardId("10100");
        award_01.setAwardType(Constants.AwardType.DESC.getCode());
        award_01.setAwardName("电脑");
        award_01.setAwardContent("请联系活动组织者 cps");

        AwardVO award_02 = new AwardVO();
        award_02.setAwardId("10200");
        award_02.setAwardType(Constants.AwardType.DESC.getCode());
        award_02.setAwardName("手机");
        award_02.setAwardContent("请联系活动组织者 cps");

        AwardVO award_03 = new AwardVO();
        award_03.setAwardId("10300");
        award_03.setAwardType(Constants.AwardType.DESC.getCode());
        award_03.setAwardName("平板");
        award_03.setAwardContent("请联系活动组织者 cps");

        List<AwardVO> awardVOList = new ArrayList<>();
        awardVOList.add(award_01);
        awardVOList.add(award_02);
        awardVOList.add(award_03);

        activityConfigRich = new ActivityConfigRich(activity, strategy, awardVOList);
    }

    @Test
    public void test_ActivityDeployImpl_create(){
        activityDeploy.createActivity(new ActivityConfigReq(activityId,activityConfigRich));
    }

    @Test
    public void test_alterState() {
        logger.info("提交审核，测试：{}", JSON.toJSONString(stateHandler.arraignment(101L, Constants.ActivityState.EDIT)));
        logger.info("审核通过，测试：{}", JSON.toJSONString(stateHandler.checkPass(101L, Constants.ActivityState.ARRAIGNMENT)));
        logger.info("运行活动，测试：{}", JSON.toJSONString(stateHandler.doing(101L, Constants.ActivityState.PASS)));
        logger.info("二次提审，测试：{}", JSON.toJSONString(stateHandler.checkPass(101L, Constants.ActivityState.EDIT)));
    }
}
