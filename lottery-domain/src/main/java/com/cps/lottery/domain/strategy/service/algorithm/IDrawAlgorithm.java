package com.cps.lottery.domain.strategy.service.algorithm;

import com.cps.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.util.List;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/10 20:02
 * @OtherDescription: Other things
 */
public interface IDrawAlgorithm {

    /**
     * 程序启动时初始化概率元祖，在初始化完成后使用过程中不允许修改元祖数据
     */
    void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList);

    /**
     * 判断是否已经，做了数据初始化
     */
    boolean isExistRateTuple(Long strategyId);

    /**
     * 生产随机数，索引到对应的奖品信息返回结果
     */
    String randomDraw(Long strategyId, List<String> excludeAwardIds);
}
