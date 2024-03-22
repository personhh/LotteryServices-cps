package com.cps.lottery.domain.activity.model.res;

import com.cps.lottery.common.Result;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/21 17:25
 * @OtherDescription: Other things
 */
public class PartakeResult extends Result {

    /**
     * 策略ID
     */
    private Long StrategyId;

    public PartakeResult(String code, String info){
        super(code, info);
    }

    public Long getStrategyId() {
        return StrategyId;
    }

    public void setStrategyId(Long strategyId) {
        StrategyId = strategyId;
    }
}
