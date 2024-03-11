package com.cps.lottery.domain.strategy.model.aggregates;

import com.cps.lottery.infrastructure.po.Strategy;
import com.cps.lottery.infrastructure.po.StrategyDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cps
 * @description: 策略聚合对象
 * @date 2024/3/9 21:16
 * @OtherDescription: Other things
 */
public class StrategyRich {

    //策略Id
    private Long strategyId;

    //策略
    private Strategy strategy;

    //策略明细列表
    private List<StrategyDetail> strategyDetailList;

    public StrategyRich(Long strategyId, Strategy strategy, List<StrategyDetail> strategyDetailList) {
        this.strategyId = strategyId;
        this.strategy = strategy;
        this.strategyDetailList = strategyDetailList;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<StrategyDetail> getStrategyDetailList() {
        return strategyDetailList;
    }

    public void setStrategyDetailList(List<StrategyDetail> strategyDetailList) {
        this.strategyDetailList = strategyDetailList;
    }
}
