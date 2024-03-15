package com.cps.lottery.infrastructure.po;

import java.math.BigDecimal;

/**
 * @author cps
 * @description: 策略明细表对应实体
 * @date 2024/3/8 14:44
 * @OtherDescription: Other things
 */
public class StrategyDetail {

    // 自增ID
    private String id;

    // 策略ID
    private Long strategyId;

    // 奖品ID
    private String awardId;

    //奖品名字
    private String awardName;

    // 奖品库存
    private String awardCount;

    //奖品剩余库存
    private Integer awardSurplusCount;

    // 中奖概率
    private BigDecimal awardRate;

    // 创建时间
    private String createTime;

    // 修改时间
    private String updateTime;

    public StrategyDetail() {
    }

    /*便于测试用，和业务关联不大
    public StrategyDetail(Long strategyId, String awardId, String awardName, String awardCount, Integer awardSurplusCount, BigDecimal awardRate) {
        this.strategyId = strategyId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardCount = awardCount;
        this.awardSurplusCount = awardSurplusCount;
        this.awardRate = awardRate;

    }*/

    public String getId() {
        return id;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getAwardCount() {
        return awardCount;
    }

    public void setAwardCount(String awardCount) {
        this.awardCount = awardCount;
    }

    public Integer getAwardSurplusCount() {
        return awardSurplusCount;
    }

    public void setAwardSurplusCount(Integer awardSurplusCount) {
        this.awardSurplusCount = awardSurplusCount;
    }

    public BigDecimal getAwardRate() {
        return awardRate;
    }

    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "StrategyDetail{" +
                "id='" + id + '\'' +
                ", strategyId=" + strategyId +
                ", awardId='" + awardId + '\'' +
                ", awardName='" + awardName + '\'' +
                ", awardCount='" + awardCount + '\'' +
                ", awardSurplusCount=" + awardSurplusCount +
                ", awardRate=" + awardRate +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
