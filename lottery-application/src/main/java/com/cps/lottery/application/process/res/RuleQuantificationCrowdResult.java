package com.cps.lottery.application.process.res;

import com.cps.lottery.common.Result;

/**
 * @author cps
 * @description: 量化活动抽奖结果
 * @date 2024/3/26 16:46
 * @OtherDescription: Other things
 */
public class RuleQuantificationCrowdResult extends Result {

    /** 活动ID */
    private Long activityId;

    public RuleQuantificationCrowdResult(String code, String info) {
        super(code, info);
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}
