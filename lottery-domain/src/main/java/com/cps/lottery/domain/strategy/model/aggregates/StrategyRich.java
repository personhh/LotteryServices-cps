package com.cps.lottery.domain.strategy.model.aggregates;

import com.cps.lottery.domain.strategy.model.vo.StrategyBriefVO;
import com.cps.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;

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
    private StrategyBriefVO strategy;

    //策略明细列表
    private List<StrategyDetailBriefVO> strategyDetailList;

    public StrategyRich(Long strategyId, StrategyBriefVO strategy, List<StrategyDetailBriefVO> strategyDetailList) {
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

    public StrategyBriefVO getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyBriefVO strategy) {
        this.strategy = strategy;
    }

    public List<StrategyDetailBriefVO> getStrategyDetailList() {
        return strategyDetailList;
    }

    public void setStrategyDetailList(List<StrategyDetailBriefVO> strategyDetailList) {
        this.strategyDetailList = strategyDetailList;
    }
}
