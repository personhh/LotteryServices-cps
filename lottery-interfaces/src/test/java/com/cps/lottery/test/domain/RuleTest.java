package com.cps.lottery.test.domain;

import com.alibaba.fastjson.JSON;
import com.cps.lottery.domain.rule.model.req.DecisionMatterReq;
import com.cps.lottery.domain.rule.model.res.EngineResult;
import com.cps.lottery.domain.rule.service.engine.EngineFilter;
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
 * @description: 规则引擎测试
 * @date 2024/3/25 14:29
 * @OtherDescription: Other things
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RuleTest {
    private Logger logger = LoggerFactory.getLogger(ActivityTest.class);

    @Resource
    private EngineFilter engineFilter;

    @Test
    public void test_process(){
        DecisionMatterReq decisionMatterReq = new DecisionMatterReq();
        decisionMatterReq.setTreeId(2110081902L);
        decisionMatterReq.setUserId("cps");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("gender","man");
        hashMap.put("age", "25");
        decisionMatterReq.setValMap(hashMap);
        EngineResult res = engineFilter.process(decisionMatterReq);

        logger.info("请求参数：{}", JSON.toJSONString(decisionMatterReq));
        logger.info("测试结果：{}", JSON.toJSONString(res));

    }

}
