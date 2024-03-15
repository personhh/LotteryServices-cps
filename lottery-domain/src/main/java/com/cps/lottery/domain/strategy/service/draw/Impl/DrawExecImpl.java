package com.cps.lottery.domain.strategy.service.draw.Impl;

import com.cps.lottery.domain.strategy.repository.IStrategyRepository;
import com.cps.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.cps.lottery.domain.strategy.service.draw.AbstractDrawBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cps
 * @description: 抽奖执行接口的实现类
 * @date 2024/3/11 10:02
 * @OtherDescription: Other things
 */
@Service("drawExec")
public class DrawExecImpl extends AbstractDrawBase  {

    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    @Resource
    private IStrategyRepository strategyRepository;


    @Override
    protected List<String> queryExcludeAwardIds(Long strategyId) {
        List<String> queryNoStockStrategyAwardList = strategyRepository.queryNoStockStrategyAwardList(strategyId);
        logger.info("执行抽奖策略 strategyId：{}，无库存排除奖品列表ID集合 awardList：{}", strategyId, queryNoStockStrategyAwardList);
        return queryNoStockStrategyAwardList;
    }

    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds) {
         //执行抽奖
        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIds);

        //判断抽奖结果
        if(null == awardId){
            return null;
        }

        //扣减库存
        boolean isSuccess = strategyRepository.deductStock(strategyId, awardId);

        //返回结果，库存扣减成功返回奖品ID，否则返回NULL，在实际的业务场景中，如果中奖奖品库存为空，则会发送兜底奖品，比如各类券
        return isSuccess ? awardId : null;

    }
}
