package com.cps.lottery.domain.strategy.service.draw;

import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cps
 * @description: 抽奖算法配置
 * @date 2024/3/11 10:50
 * @OtherDescription: Other things
 */
public class DrawConfig {

    //必中奖策略
    @Resource
    private IDrawAlgorithm entiretyRateRandomDrawAlgorithm;

    //单项概率策略
    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();

    @PostConstruct
    // 这个注解作用于bean初始化之前
    public void init() {
        drawAlgorithmMap.put(Constants.StrategyMode.ENTIRETY.getCode(), entiretyRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(Constants.StrategyMode.SINGLE.getCode(), singleRateRandomDrawAlgorithm);
    }
}
