package com.cps.lottery.domain.strategy.model.req;

/**
 * @author cps
 * @description: 抽奖请求
 * @date 2024/3/9 21:12
 * @OtherDescription: Other things
 */
public class DrawReq {

    /**用户id*/
    private String uId;

    /**策略id*/
    private Long strategyId;

    public DrawReq() {
    }

    public DrawReq(String uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
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
}
