package com.cps.lottery.test;

import com.alibaba.fastjson.JSON;
import com.cps.lottery.infrastructure.dao.IActivityDao;

import com.cps.lottery.infrastructure.po.Activity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

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

}
