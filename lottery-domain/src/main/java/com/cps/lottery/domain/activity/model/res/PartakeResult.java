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

    /**
     * 活动领取ID
     */
    private Long takeId;

    /** 库存 */
    private Integer stockCount;

    /** activity 库存剩余 */
    private Integer stockSurplusCount;

    public PartakeResult(String code, String info){
        super(code, info);
    }

    public Long getStrategyId() {
        return StrategyId;
    }

    public void setStrategyId(Long strategyId) {
        StrategyId = strategyId;
    }

    public Long getTakeId() {
        return takeId;
    }

    public void setTakeId(Long takeId) {
        this.takeId = takeId;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getStockSurplusCount() {
        return stockSurplusCount;
    }

    public void setStockSurplusCount(Integer stockSurplusCount) {
        this.stockSurplusCount = stockSurplusCount;
    }

}
