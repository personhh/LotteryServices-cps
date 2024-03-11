package com.cps.lottery.infrastructure.dao;

import com.cps.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cps
 * @description: 策略表的持久化接口
 * @date 2024/3/8 14:41
 * @OtherDescription: Other things
 */

@Mapper
public interface IStrategyDao {

    //用策略ID查询策略
    Strategy queryStrategy(Long strategyId);
}
