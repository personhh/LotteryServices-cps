package com.cps.lottery.domain.strategy.service.draw;

import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.activity.model.vo.StrategyVO;
import com.cps.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.cps.lottery.domain.strategy.model.req.DrawReq;
import com.cps.lottery.domain.strategy.model.res.DrawResult;
import com.cps.lottery.domain.strategy.model.vo.*;
import com.cps.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author cps
 * @description: 抽奖执行的基类
 * @date 2024/3/11 10:00
 * @OtherDescription: Other things
 */
public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec{


    private Logger logger = LoggerFactory.getLogger(AbstractDrawBase.class);


    @Override
    public DrawResult doDrawExec(DrawReq req) {
        logger.info("执行策略抽奖开始，策略Id-strategyId: {}", req.getStrategyId());
        //1.获取抽奖策略
        StrategyRich strategyRich = this.queryStrategyRich(req.getStrategyId());
        StrategyBriefVO strategy = strategyRich.getStrategy();

        //2.校验抽奖策略是否已经初始化到内存
        this.checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), strategyRich.getStrategyDetailList());

        //3.获取不在抽奖范围内的列表，包括：奖品库存为空，风控策略、临时调整等
        List<String> excludeAwardIds = this.queryExcludeAwardIds(req.getStrategyId());

        //4.执行抽奖方法
        logger.info("执行抽奖方法 策略id：{}, 策略方式：{}", req.getStrategyId(), drawAlgorithmMap.get(strategy.getStrategyMode()));
        String awardId = this.drawAlgorithm(req.getStrategyId(), drawAlgorithmMap.get(strategy.getStrategyMode()), excludeAwardIds);

        //5.包装中奖结果
        return buidDrawResult(req.getuId(), req.getStrategyId(), awardId, strategy);
    }

    /**
     * 校验抽奖策略是否已经初始化到内存
     * */
    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetailBriefVO> strategyDetailList){
        //判断是不是必中奖策略
        if(!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)){
            return;
        }
        //如果是必中奖策略，就进行初始化
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        //判断是否初始化
        if(drawAlgorithm.isExistRateTuple(strategyId)) {
            return;
        }

        //没有就开始初始化
        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());

        //遍历所有策略明细
        for(StrategyDetailBriefVO strategyDetail : strategyDetailList){
            //通过所有策略明细获得对应的奖品概率信息
            AwardRateInfo awardRateInfo = new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate());
            //放入到奖品概率信息列表
            awardRateInfoList.add(awardRateInfo);
        }

        //对这个策略中元祖进行初始化，通过列表中的奖品概率信息来初始化元祖中概率区间
        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }

    /**
     * 获取不在抽奖范围内的列表
     */
    protected abstract List<String> queryExcludeAwardIds(Long strategyId);

    /**
     * 执行抽奖策略算法
     */
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds);

    /**
     * 包装抽奖结果
     */
    private DrawResult buidDrawResult(String uId, Long strategyId, String awardId, StrategyBriefVO strategy){
        if(null == awardId) {
            logger.info("执行策略抽奖完成【未中奖】， 用户：{} 策略ID：{}", uId, strategyId);
            return new DrawResult(uId, strategyId, Constants.DrawState.FAIL.getCode());
        }

        AwardBriefVO award = super.queryAwardInfoByAwardId(awardId);
        DrawAwardInfo drawAwardInfo = new DrawAwardInfo(award.getAwardId(), award.getAwardType(), award.getAwardName(), award.getAwardContent());
        drawAwardInfo.setStrategyMode(strategy.getStrategyMode());
        drawAwardInfo.setGrantType(strategy.getGrantType());
        drawAwardInfo.setGrantDate(strategy.getGrantDate());
        logger.info("执行策略抽奖完成[已中奖】，用户：{} 策略ID：{} 奖品ID：{} 奖品名称：{}", uId, strategyId, awardId, award.getAwardName());
        return new DrawResult(uId, strategyId, Constants.DrawState.SUCCESS.getCode(), drawAwardInfo);
    }
}
