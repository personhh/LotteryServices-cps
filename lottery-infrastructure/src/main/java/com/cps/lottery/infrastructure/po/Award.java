package com.cps.lottery.infrastructure.po;

import java.util.Date;

/**
 * @author cps
 * @description: 奖品表对应实体
 * @date 2024/3/8 14:25
 * @OtherDescription: Other things
 */
public class Award {

    /**自增ID*/
    private Long id;
    /**奖品ID*/
    private String awardId;
    /**奖品类型 ：1.文字描述 2.兑换码 3.优惠券 4.实物奖品*/
    private Integer awardType;
    /**奖品名称*/
    private String awardName;
    /**奖品数量*/
    private Integer awardCount;
    /**奖品内容*/
    private String awardContent;
    /**创建时间*/
    private Date createTime;
    /**更新时间*/
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public Integer getAwardCount() {
        return awardCount;
    }

    public void setAwardCount(Integer awardCount) {
        this.awardCount = awardCount;
    }

    public String getAwardContent() {
        return awardContent;
    }

    public void setAwardContent(String awardContent) {
        this.awardContent = awardContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
