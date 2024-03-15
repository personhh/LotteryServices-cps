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

    /**
     * 根据策略ID查询一系列策略明细
     *
     * @param strategyId 策略id
     * @return 策略明细列表
     */
    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

    /**
     * 查询无库存策略奖品ID
     * @param strategyId 策略ID
     * @return           返回结果
     */
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     * @param strategyDetailReq 策略ID、奖品ID
     * @return                  返回结果
     */
    int deductStock(StrategyDetail strategyDetailReq);

    /**
     * 插入策略配置组
     *
     * @param list 策略配置组
     */
    void insertList(List<StrategyDetail> list);
}
