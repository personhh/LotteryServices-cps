package com.cps.lottery.domain.activity.service.deploy;

import com.cps.lottery.domain.activity.model.req.ActivityConfigReq;

/**
 * @author cps
 * @description: 部署活动配置接口
 * @date 2024/3/15 10:20
 * @OtherDescription: Other things
 */
public interface IActivityDeploy {

    /**
     * 创建活动信息
     * @param req 活动配置信息
     */
    void createActivity(ActivityConfigReq req);

    /**
     * 修改活动信息
     *
     * @param req 活动配置信息
     */
    void updateActivity(ActivityConfigReq req);
}

