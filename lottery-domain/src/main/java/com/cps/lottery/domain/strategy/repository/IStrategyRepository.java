package com.cps.lottery.domain.strategy.repository;

import com.cps.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.cps.lottery.infrastructure.po.Award;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/9 21:31
 * @OtherDescription: Other things
 */
public interface IStrategyRepository {

    /**查询策略聚合对象*/
    StrategyRich queryStrategyRich(Long strategyId);

    /**查询奖品*/
    Award queryAwardInfo(String awardId);
}
