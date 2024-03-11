package com.cps.lottery.domain.strategy.repository;

import com.cps.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.cps.lottery.infrastructure.dao.IAwardDao;
import com.cps.lottery.infrastructure.dao.IStrategyDao;
import com.cps.lottery.infrastructure.dao.IStrategyDetail;
import com.cps.lottery.infrastructure.po.Award;
import com.cps.lottery.infrastructure.po.Strategy;
import com.cps.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/9 21:31
 * @OtherDescription: Other things
 */
@Component
public class StrategyRepository implements IStrategyRepository{

    @Resource
    private IStrategyDao iStrategyDao;
    @Resource
    private IStrategyDetail iStrategyDetail;
    @Resource
    private IAwardDao iAwardDao;
    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = iStrategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetails = iStrategyDetail.queryStrategyDetailList(strategyId);
        StrategyRich strategyRich = new StrategyRich(strategyId, strategy, strategyDetails);
        return strategyRich;
    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return iAwardDao.queryAwardInfo(awardId);
    }
}
