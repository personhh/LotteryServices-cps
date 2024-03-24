package com.cps.lottery.test.application;

import com.alibaba.fastjson.JSON;
import com.cps.lottery.application.process.IActivityProcess;
import com.cps.lottery.application.process.req.DrawProcessReq;
import com.cps.lottery.application.process.res.DrawProcessResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author cps
 * @description: 活动过程测试
 * @date 2024/3/23 21:28
 * @OtherDescription: Other things
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityProcessTest {

    private Logger logger = LoggerFactory.getLogger(ActivityProcessTest.class);

    @Resource
    private IActivityProcess activityProcess;

    @Test
    public void test_doDrawProcess(){
        DrawProcessReq req = new DrawProcessReq();
        req.setuId("Uhdgkw766120d");
        req.setActivityId(100001L);
        DrawProcessResult drawProcessResult = activityProcess.doDrawProcess(req);

        logger.info("请求入参数： {}", JSON.toJSONString(req));
        logger.info("测试结果：{}", JSON.toJSONString(drawProcessResult));
    }
}
