package com.cps.lottery.rpc.req;

import java.io.Serializable;

/**
 * @author cps
 * @description: 抽奖请求
 * @date 2024/3/26 11:16
 * @OtherDescription: Other things
 */
public class DrawReq implements Serializable {

    /** 用户 */
    private String uId;

    /** 活动ID */
    private Long activityId;

    public DrawReq() {
    }

    public DrawReq(String uId, Long activityId) {
        this.uId = uId;
        this.activityId = activityId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}
