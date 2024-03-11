package com.cps.lottery.domain.strategy.service.draw;

import com.cps.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cps
 * @description: 抽奖配置
 * @date 2024/3/11 10:50
 * @OtherDescription: Other things
 */
public class DrawConfig {

    //必中奖策略
    @Resource
    private IDrawAlgorithm defaultRateRandomDrawAlgorithm;

    //单项概率策略
    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();

    @PostConstruct
    // 这个注解作用于bean初始化之前
    public void init() {
        drawAlgorithmMap.put(1,defaultRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(2,singleRateRandomDrawAlgorithm);
    }
}
