package com.cps.lottery.domain.strategy.repository;

import com.cps.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.cps.lottery.domain.strategy.model.vo.AwardBriefVO;

import java.util.List;

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
    AwardBriefVO queryAwardInfo(String awardId);

    /**查询空库存的策略奖品列表*/
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**扣减库存*/
    boolean deductStock(Long strategyId, String awardId);
}
