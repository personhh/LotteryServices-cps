package com.cps.lottery.rpc.req;

import java.io.Serializable;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/7 13:19
 * @OtherDescription: Other things
 */
public class ActivityReq implements Serializable {

    private Long activityById;

    public Long getActivityById() {
        return activityById;
    }

    public void setActivityById(Long activityById) {
        this.activityById = activityById;
    }
}
