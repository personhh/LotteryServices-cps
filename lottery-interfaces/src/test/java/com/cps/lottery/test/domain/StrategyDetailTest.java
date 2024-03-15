package com.cps.lottery.test.domain;

import com.cps.lottery.infrastructure.dao.IStrategyDetailDao;
import com.cps.lottery.infrastructure.po.StrategyDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cps
 * @description: 策略明细板块测试
 * @date 2024/3/15 11:16
 * @OtherDescription: Other things
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyDetailTest {

    @Resource
    private IStrategyDetailDao strategyDetail;

    @Test
    public void test_StrategyDetail(){
        List<StrategyDetail> strategyDetails = strategyDetail.queryStrategyDetailList(10002L);
        for(StrategyDetail strategyDetail: strategyDetails){
            System.out.println(strategyDetail);
        }
    }


    @Test
    public void test_StrategyDetail_insertList(){
        /*用于测试，测试前去StrategyDetail实体中创建构造方法
        StrategyDetail strategyDetail1 = new StrategyDetail(10002L, "106", "六等奖", "20", 10, new BigDecimal("0.2"));
        StrategyDetail strategyDetail2 = new StrategyDetail(10002L, "107", "七等奖", "20", 10, new BigDecimal("0.1"));
        List<StrategyDetail> strategyDetailLists = new ArrayList<>();
        strategyDetailLists.add(strategyDetail1);
        strategyDetailLists.add(strategyDetail2);
        strategyDetailDao.insertList(strategyDetailLists);*/
    }
}
