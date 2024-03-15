package com.cps.lottery.test.domain;

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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author cps
 * @description: 奖品模块测试
 * @date 2024/3/15 11:10
 * @OtherDescription: Other things
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AwardTest {
    Logger logger = LoggerFactory.getLogger(AwardTest.class);

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
    public void test_Award_insertList(){
        /* 要是测试这段代码，记得去Award类中去临时写一个构造方法
        Award award1 = new Award("106", 1, "手机壳", 60, "联系cps");
        Award award2 = new Award("107", 1, "手机壳", 60, "联系cps");
        List<Award> awardList = new ArrayList<>();
        awardList.add(award1);
        awardList.add(award2);
        awardDao.insertList(awardList);*/
    }
}
