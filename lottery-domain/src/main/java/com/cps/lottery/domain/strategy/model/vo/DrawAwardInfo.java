package com.cps.lottery.domain.strategy.model.vo;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/12 15:21
 * @OtherDescription: Other things
 */
public class DrawAwardInfo {

    /**
     * 奖品ID
     */
    private String awardId;

    /** 奖品类型 */
    private Integer awardType;

    /**
     * 奖品名称
     */
    private String awardName;

    /** 奖品内容「描述、奖状码、sku」*/
    private String awardContent;

    public DrawAwardInfo() {
    }

    public DrawAwardInfo(String awardId, Integer awardType, String awardName, String awardContent) {
        this.awardId = awardId;
        this.awardType  = awardType;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;}

    public String getAwardContent() {
        return awardContent;
    }

    public void setAwardContent(String awardContent) {
        this.awardContent = awardContent;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }
}

