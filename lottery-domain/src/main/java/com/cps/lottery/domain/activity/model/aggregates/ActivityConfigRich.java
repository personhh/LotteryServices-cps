package com.cps.lottery.domain.activity.model.aggregates;

import com.cps.lottery.domain.activity.model.vo.ActivityVO;
import com.cps.lottery.domain.activity.model.vo.AwardVO;
import com.cps.lottery.domain.activity.model.vo.StrategyVO;

import java.util.List;

/**
 * @author cps
 * @description: 活动配置聚合
 * @date 2024/3/14 10:53
 * @OtherDescription: Other things
 */
public class ActivityConfigRich {

    /** 活动配置*/
    private ActivityVO activityVO;

    /** 策略配置（含策略明细）*/
    private StrategyVO strategyVO;

    /** 奖品配置 */
    private List<AwardVO> awardVOList;

    public ActivityConfigRich() {
    }

    public ActivityConfigRich(ActivityVO activityVO, StrategyVO strategyVO, List<AwardVO> awardVOList) {
        this.activityVO = activityVO;
        this.strategyVO = strategyVO;
        this.awardVOList = awardVOList;
    }

    public ActivityVO getActivityVO() {
        return activityVO;
    }

    public void setActivityVO(ActivityVO activityVO) {
        this.activityVO = activityVO;
    }

    public StrategyVO getStrategyVO() {
        return strategyVO;
    }

    public void setStrategyVO(StrategyVO strategyVO) {
        this.strategyVO = strategyVO;
    }

    public List<AwardVO> getAwardVOList() {
        return awardVOList;
    }

    public void setAwardVOList(List<AwardVO> awardVOList) {
        this.awardVOList = awardVOList;
    }
}
