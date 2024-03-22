package com.cps.lottery.test.dao;

import com.alibaba.fastjson.JSON;
import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.support.ids.IIdGenerator;
import com.cps.lottery.infrastructure.dao.IUserStrategyExportDao;
import com.cps.lottery.infrastructure.po.UserStrategyExport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/18 13:10
 * @OtherDescription: Other things
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserStrategyExportDaoTest {

    private Logger logger = LoggerFactory.getLogger(UserStrategyExportDaoTest.class);

    @Resource
    private IUserStrategyExportDao userStrategyExportDao;

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Test
    public void test_insert() {
        UserStrategyExport userStrategyExport = new UserStrategyExport();
        userStrategyExport.setuId("Uhdoojkdd");
        userStrategyExport.setActivityId(idGeneratorMap.get(Constants.Ids.ShortCode).nextId());
        userStrategyExport.setOrderId(idGeneratorMap.get(Constants.Ids.SnowFlake).nextId());
        userStrategyExport.setStrategyId(idGeneratorMap.get(Constants.Ids.RandomNumeric).nextId());
        userStrategyExport.setStrategyMode(Constants.StrategyMode.SINGLE.getCode());
        userStrategyExport.setGrantType(1);
        userStrategyExport.setGrantDate(new Date());
        userStrategyExport.setGrantState(1);
        userStrategyExport.setAwardId("1");
        userStrategyExport.setAwardType(Constants.AwardType.DESC.getCode());
        userStrategyExport.setAwardName("IMac");
        userStrategyExport.setAwardContent("奖品描述");
        userStrategyExport.setUuid(String.valueOf(userStrategyExport.getOrderId()));

        userStrategyExportDao.insert(userStrategyExport);
    }

    @Test
    public void test_select() {
        UserStrategyExport userStrategyExport = userStrategyExportDao.queryUserStrategyExportByuId("Uhdgkw7661");
        logger.info("测试结果：{}", JSON.toJSONString(userStrategyExport));
    }
}
