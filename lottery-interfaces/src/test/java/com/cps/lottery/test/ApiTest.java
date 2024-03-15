package com.cps.lottery.test;

import com.cps.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import com.cps.lottery.domain.activity.model.req.ActivityConfigReq;
import com.cps.lottery.domain.activity.service.deploy.IActivityDeploy;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author cps
 * @description: 临时测试一下
 * @date 2024/3/7 16:11
 * @OtherDescription: Other things
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);


    @Resource
    private IActivityDeploy activityDeploy;

    private ActivityConfigRich activityConfigRich;

    private Long activityId = 12353567L;

    @Test
    public void test_other(){
        System.out.println(Long.parseLong(RandomStringUtils.randomNumeric(11)));
    }

}
