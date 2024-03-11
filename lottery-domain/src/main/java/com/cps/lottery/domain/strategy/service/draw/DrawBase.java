package com.cps.lottery.domain.strategy.service.draw;

import com.cps.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.cps.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.cps.lottery.infrastructure.po.StrategyDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cps
 * @description: 抽奖执行的基类
 * @date 2024/3/11 10:00
 * @OtherDescription: Other things
 */
public abstract class DrawBase extends DrawConfig{

    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList){
        //判断是不是必中奖策略
        if(1 != strategyMode) return;
        //如果是必中奖策略，就进行初始化
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        //判断是否初始化
        if(drawAlgorithm.isExistRateTuple(strategyId)) return;

        //没有就开始初始化
        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());

        //遍历所有策略明细
        for(StrategyDetail strategyDetail : strategyDetailList){
            //通过所有策略明细获得对应的奖品概率信息
            AwardRateInfo awardRateInfo = new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate());
            //放入到奖品概率信息列表
            awardRateInfoList.add(awardRateInfo);
        }

        //对这个策略中元祖进行初始化，通过列表中的奖品概率信息来初始化元祖中概率区间
        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }
}
