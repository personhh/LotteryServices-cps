package com.cps.lottery.test.domain;

import com.cps.lottery.domain.strategy.model.req.DrawReq;
import com.cps.lottery.domain.strategy.service.draw.IDrawExec;
import com.cps.lottery.infrastructure.dao.IStrategyDao;
import com.cps.lottery.infrastructure.po.Strategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/15 11:10
 * @OtherDescription: Other things
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyTest {

    @Resource
    private IDrawExec drawExec;

    @Resource
    private IStrategyDao strategyDao;

    @Test
    public void test_drawExec(){
        drawExec.doDrawExec(new DrawReq("cps",10002L));
        drawExec.doDrawExec(new DrawReq("jack",10002L));
        drawExec.doDrawExec(new DrawReq("Tom",10002L));
        drawExec.doDrawExec(new DrawReq("smith",10002L));
        drawExec.doDrawExec(new DrawReq("kite",10002L));
    }

    @Test
    public void test_Strategy(){
        Strategy strategy = strategyDao.queryStrategy(10002L);
        System.out.println(strategy);
    }

    @Test
    public void test_Strategy_insert(){
        Strategy strategy = new Strategy();
        strategy.setId(6L);
        strategy.setStrategyId(10003L);
        strategy.setStrategyDesc("抽奖策略-大转盘");
        strategy.setStrategyMode(1);
        strategy.setGrantType(1);
        strategy.setGrantDate(new Date());
        strategy.setExtInfo("无，待补充");
        strategyDao.insert(strategy);
    }

}
