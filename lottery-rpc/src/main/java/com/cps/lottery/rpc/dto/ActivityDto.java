package com.cps.lottery.rpc.dto;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/7 13:19
 * @OtherDescription: Other things
 */
public class ActivityDto implements Serializable {

    //活动ID
    private Long activityId;

    //活动名称
    private String activityName;

    //活动描述
    private String activityDesc;

    //开始时间
    private Date beginDataTime;

    //结束时间
    private Date endDataTime;

    //库存
    private Integer stockCount;

    //仓库剩余
    private Integer stock_surplus_count;

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

    public Date getBeginDataTime() {
        return beginDataTime;
    }

    public void setBeginDataTime(Date beginDataTime) {
        this.beginDataTime = beginDataTime;
    }

    public Date getEndDataTime() {
        return endDataTime;
    }

    public void setEndDataTime(Date endDataTime) {
        this.endDataTime = endDataTime;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getStock_surplus_count() {
        return stock_surplus_count;
    }

    public void setStock_surplus_count(Integer stock_surplus_count) {
        this.stock_surplus_count = stock_surplus_count;
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
}
