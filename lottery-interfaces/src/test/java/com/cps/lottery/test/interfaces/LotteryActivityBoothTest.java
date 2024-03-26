package com.cps.lottery.test.interfaces;

import com.alibaba.fastjson.JSON;
import com.cps.lottery.rpc.ILotteryActivityBooth;
import com.cps.lottery.rpc.req.DrawReq;
import com.cps.lottery.rpc.req.QuantificationDrawReq;
import com.cps.lottery.rpc.res.DrawRes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author cps
 * @description: Rpc接口测试
 * @date 2024/3/26 16:29
 * @OtherDescription: Other things
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LotteryActivityBoothTest {

    private Logger logger = LoggerFactory.getLogger(LotteryActivityBoothTest.class);

    @Resource
    private ILotteryActivityBooth lotteryActivityBooth;

    @Test
    public void test_doDraw(){
        DrawReq drawReq = new DrawReq();
        drawReq.setuId("Uhdgkw766120d");
        drawReq.setActivityId(100001L);
        DrawRes drawRes = lotteryActivityBooth.doDraw(drawReq);
        logger.info("请求参数： {}", JSON.toJSONString(drawReq));
        logger.info("测试结果：{}", JSON.toJSONString(drawRes));
    }

    @Test
    public void test_doQuantificationDraw(){
        QuantificationDrawReq quantificationDrawReq = new QuantificationDrawReq();
        quantificationDrawReq.setuId("Uhdgkw766120d");
        quantificationDrawReq.setTreeId(2110081902L);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("gender", "man");
        hashMap.put("age", "18");
        quantificationDrawReq.setValMap(hashMap);

        DrawRes drawRes = lotteryActivityBooth.doQuantificationDraw(quantificationDrawReq);
        logger.info("请求参数：{}", JSON.toJSONString(quantificationDrawReq));
        logger.info("测试结果：{}", JSON.toJSONString(drawRes));
    }
}
