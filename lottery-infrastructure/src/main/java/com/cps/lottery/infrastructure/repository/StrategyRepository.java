package com.cps.lottery.infrastructure.repository;

import com.cps.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.cps.lottery.domain.strategy.model.vo.AwardBriefVO;
import com.cps.lottery.domain.strategy.model.vo.StrategyBriefVO;
import com.cps.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import com.cps.lottery.domain.strategy.repository.IStrategyRepository;
import com.cps.lottery.infrastructure.dao.IAwardDao;
import com.cps.lottery.infrastructure.dao.IStrategyDao;
import com.cps.lottery.infrastructure.dao.IStrategyDetailDao;
import com.cps.lottery.infrastructure.po.Award;
import com.cps.lottery.infrastructure.po.Strategy;
import com.cps.lottery.infrastructure.po.StrategyDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cps
 * @description: 策略表仓储服务
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

        StrategyBriefVO strategyBriefVO = new StrategyBriefVO();
        BeanUtils.copyProperties(strategy, strategyBriefVO);

        List<StrategyDetailBriefVO> strategyBriefVOList = new ArrayList<>();
        for(StrategyDetail strategyDetail : strategyDetails){
            StrategyDetailBriefVO strategyDetailBriefVO = new StrategyDetailBriefVO();
            BeanUtils.copyProperties(strategyDetail, strategyDetailBriefVO);
            strategyBriefVOList.add(strategyDetailBriefVO);
        }
        StrategyRich strategyRich = new StrategyRich(strategyId, strategyBriefVO, strategyBriefVOList);
        return strategyRich;
    }

    @Override
    public AwardBriefVO queryAwardInfo(String awardId) {
        Award award = iAwardDao.queryAwardInfo(awardId);
        AwardBriefVO awardBriefVO = new AwardBriefVO();
        awardBriefVO.setAwardId(award.getAwardId());
        awardBriefVO.setAwardType(award.getAwardType());
        awardBriefVO.setAwardName(award.getAwardName());
        awardBriefVO.setAwardContent(award.getAwardContent());
        return awardBriefVO;
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
