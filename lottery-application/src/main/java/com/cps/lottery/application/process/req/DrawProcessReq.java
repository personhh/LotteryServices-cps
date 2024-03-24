package com.cps.lottery.application.process.req;

/**
 * @author cps
 * @description: 抽奖请求
 * @date 2024/3/22 14:52
 * @OtherDescription: Other things
 */
public class DrawProcessReq {

    /**
     * 用户Id
     */
    private String uId;

    /**
     * 活动Id
     */
    private Long activityId;

    public DrawProcessReq() {
    }

    public DrawProcessReq(String uId, Long activityId) {
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
