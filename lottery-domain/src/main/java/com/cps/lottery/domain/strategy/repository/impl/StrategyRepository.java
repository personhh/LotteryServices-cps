package com.cps.lottery.domain.strategy.repository.impl;

import com.cps.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.cps.lottery.domain.strategy.repository.IStrategyRepository;
import com.cps.lottery.infrastructure.dao.IAwardDao;
import com.cps.lottery.infrastructure.dao.IStrategyDao;
import com.cps.lottery.infrastructure.dao.IStrategyDetailDao;
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
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao iStrategyDao;
    @Resource
    private IStrategyDetailDao iStrategyDetailDao;
    @Resource
    private IAwardDao iAwardDao;
    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = iStrategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetails = iStrategyDetailDao.queryStrategyDetailList(strategyId);
        StrategyRich strategyRich = new StrategyRich(strategyId, strategy, strategyDetails);
        return strategyRich;
    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return iAwardDao.queryAwardInfo(awardId);
    }

    @Override
    public List<String> queryNoStockStrategyAwardList(Long strategyId) {
        return iStrategyDetailDao.queryNoStockStrategyAwardList(strategyId);
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        StrategyDetail strategyDetail = new StrategyDetail();
        strategyDetail.setStrategyId(strategyId);
        strategyDetail.setAwardId(awardId);
        int idx = iStrategyDetailDao.deductStock(strategyDetail);
        return idx == 1;
    }
}
