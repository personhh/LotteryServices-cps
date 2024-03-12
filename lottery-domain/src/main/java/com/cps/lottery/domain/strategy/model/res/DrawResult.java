package com.cps.lottery.domain.strategy.model.res;

import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.strategy.model.vo.DrawAwardInfo;

/**
 * @author cps
 * @description: 抽奖结果
 * @date 2024/3/9 21:15
 * @OtherDescription: Other things
 */
public class DrawResult {
    // 用户ID
    private String uId;

    // 策略ID
    private Long strategyId;

    private Integer drawState = Constants.DrawState.FAIL.getCode();

    private DrawAwardInfo drawAwardInfo;

    public DrawResult(String uId, Long strategyId, Integer drawState){
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
    }



    public DrawResult(String uId, Long strategyId, Integer drawState, DrawAwardInfo drawAwardInfo) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
        this.drawAwardInfo = drawAwardInfo;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getDrawState() {
        return drawState;
    }

    public void setDrawState(Integer drawState) {
        this.drawState = drawState;
    }

    public DrawAwardInfo getDrawAwardInfo() {
        return drawAwardInfo;
    }

    public void setDrawAwardInfo(DrawAwardInfo drawAwardInfo) {
        this.drawAwardInfo = drawAwardInfo;
    }
}
