package com.cps.lottery.domain.strategy.model.vo;

import java.math.BigDecimal;

/**
 * @author cps
 * @description: 奖品概率信息
 * @date 2024/3/9 21:10
 * @OtherDescription: Other things
 */
public class AwardRateInfo {

    /**奖品id*/
    private String awardId;

    /**中奖概率*/
    private BigDecimal awardRate;

    public AwardRateInfo(String awardId, BigDecimal awardRate) {
        this.awardId = awardId;
        this.awardRate = awardRate;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public BigDecimal getAwardRate() {
        return awardRate;
    }

    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }
}
