package com.cps.lottery.domain.strategy.service.algorithm.impl;

import com.cps.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.cps.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cps
 * @description: 必中奖策略抽奖，排掉已经中奖的概率，重新计算中奖范围
 * @date 2024/3/10 20:03
 * @OtherDescription: Other things
 */

@Component("entiretyRateRandomDrawAlgorithm")
public class EntiretyRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        BigDecimal differenceDenominator = BigDecimal.ZERO;

        //排除掉不在抽奖范围内的奖品ID的集合
        List<AwardRateInfo> differenceAwardRateList = new ArrayList<>();

        //获取所有奖品ID
        List<AwardRateInfo> awardRateInfoList = awardRateInfoMap.get(strategyId);
        //遍历所有奖品ID集合
        for(AwardRateInfo awardRateInfo : awardRateInfoList){
            //获取奖品ID的值
            String awardId = awardRateInfo.getAwardId();
            //判断是否排除奖品ID
            if(excludeAwardIds.contains(awardId)){
                //在的话就跳过这次循环。不加入到新集合中
                continue;
            }
            differenceAwardRateList.add(awardRateInfo);
            //当前新的集合中全部奖品的总概率
            differenceDenominator = differenceDenominator.add(awardRateInfo.getAwardRate());
        }


        //前置判断
        if(differenceAwardRateList.size() == 0) {
            return null;
        }
        if(differenceAwardRateList.size() == 1) {
            return differenceAwardRateList.get(0).getAwardId();
        }

        //获取随机概率值
        int randomVal = this.generateSecureRandomIntCode(100);

        //循环获取奖品
        String awardId = null;
        int cursorVal = 0;
        for(AwardRateInfo awardRateInfo : differenceAwardRateList){
            //此时在新集合中的奖品概率
            /**
             * divide方法：第一个参数是除数，第二个参数是保留几位小数，第三个代表的是使用的模式
             *
             * BigDecimal.ROUND_DOWN:直接省略多余的小数，比如1.28如果保留1位小数，得到的就是1.2
             *
             * BigDecimal.ROUND_UP:直接进位，比如1.21如果保留1位小数，得到的就是1.3
             *
             * BigDecimal.ROUND_HALF_UP:四舍五入，2.35保留1位，变成2.4
             *
             * BigDecimal.ROUND_HALF_DOWN:四舍五入，2.35保留1位，变成2.3
             *
             * 后边两种的区别就是如果保留的位数的后一位如果正好是5的时候，一个舍弃掉，一个进位。
             */
            int rateVal = awardRateInfo.getAwardRate().divide(differenceDenominator, 2, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).intValue();
            if(randomVal <= cursorVal + rateVal){
                awardId = awardRateInfo.getAwardId();
                break;
            }

            cursorVal += rateVal;
        }

        //返回中奖结果
        return awardId;
    }
}
