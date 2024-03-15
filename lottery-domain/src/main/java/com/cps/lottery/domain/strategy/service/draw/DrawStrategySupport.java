package com.cps.lottery.domain.strategy.service.draw;

import com.cps.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.cps.lottery.domain.strategy.model.vo.AwardBriefVO;
import com.cps.lottery.domain.strategy.repository.IStrategyRepository;

import javax.annotation.Resource;

/**
 * @author cps
 * @description: 抽奖策略数据支撑，一些通用的数据服务
 * @date 2024/3/12 11:55
 * @OtherDescription: Other things
 */
public class DrawStrategySupport extends DrawConfig{

    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * 查询策略配置信息
     */
    protected StrategyRich queryStrategyRich(Long strategyId){
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * 查询奖品详情信息
     */

    protected AwardBriefVO queryAwardInfoByAwardId(String awardId){
        return strategyRepository.queryAwardInfo(awardId);
    }
}
