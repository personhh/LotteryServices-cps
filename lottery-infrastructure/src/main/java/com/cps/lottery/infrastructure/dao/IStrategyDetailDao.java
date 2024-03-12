package com.cps.lottery.infrastructure.dao;

import com.cps.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cps
 * @description: 策略明细表的持久化接口
 * @date 2024/3/8 14:47
 * @OtherDescription: Other things
 */
@Mapper
public interface IStrategyDetailDao {

    //根据策略ID查询一系列策略明细
    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

    //查询无库存策略奖品ID
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    //扣减库存
    int deductStock(StrategyDetail strategyDetailReq);
}
