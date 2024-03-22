package com.cps.lottery.infrastructure.po;


import java.util.Date;

/**
 * @author cps
 * @description: 活动表对应的实体
 * @date 2024/3/7 15:40
 * @OtherDescription: Other things
 */
public class Activity {

    //自增ID
    private Long id;

    //活动ID
    private Long activityId;

    //活动名称
    private String activityName;

    //活动描述
    private String activityDesc;

    //开始时间
    private Date beginDateTime;

    //结束时间
    private Date endDateTime;

    //库存
    private Integer stockCount;

    //仓库剩余
    private Integer stockSurplusCount;

    //每人可参与次数
    private Integer takeCount;

    //策略ID
    private Long strategyId;

    //状态
    private Integer state;

    //创造者
    private String creator;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public Date getBeginDateTime() {
        return beginDateTime;
    }

    public void setBeginDateTime(Date beginDataTime) {
        this.beginDateTime = beginDataTime;
    }

    public Date getEndDataTime() {
        return endDateTime;
    }

    public void setEndDataTime(Date endDataTime) {
        this.endDateTime = endDataTime;
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

    public Integer getTakeCount() {
        return takeCount;
    }

    public void setTakeCount(Integer takeCount) {
        this.takeCount = takeCount;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", activityDesc='" + activityDesc + '\'' +
                ", beginDateTime=" + beginDateTime +
                ", endDateTime=" + endDateTime +
                ", stockCount=" + stockCount +
                ", stockSurplusCount=" + stockSurplusCount +
                ", takeCount=" + takeCount +
                ", strategyId=" + strategyId +
                ", state=" + state +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
