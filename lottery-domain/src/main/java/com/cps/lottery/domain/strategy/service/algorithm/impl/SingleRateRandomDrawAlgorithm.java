package com.cps.lottery.domain.strategy.service.algorithm.impl;

import com.cps.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

/**
 * @author cps
 * @description: 单项随机概率抽奖，抽到一个已经排掉的奖品则未中奖【推荐】
 * @date 2024/3/10 20:04
 * @OtherDescription: Other things
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        //获取策略对应的元祖
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        //判断元祖是否为空
        assert rateTuple != null;

        //随机索引（从100以内随机找一数再加1）
        int randomVal = new SecureRandom().nextInt(100) + 1;
        int idx = super.hashIdx(randomVal);

        //返回结果
        String awardId = rateTuple[idx];
        if(excludeAwardIds.contains(awardId)) return "未中奖";

        return awardId;
    }
}
