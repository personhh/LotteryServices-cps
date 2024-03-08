package com.cps.lottery.rpc;

import com.cps.lottery.rpc.req.ActivityReq;
import com.cps.lottery.rpc.res.ActivityRes;

/**
 * @author cps
 * @description: 活动展台的接口类，用于包装活动的创建、查询、修改、审核的接口
 * @date 2024/3/7 13:15
 * @OtherDescription: 活动展台：1.创建活动 2.更新活动、3.查询活动
 */
public interface IActivityBooth {
    ActivityRes queryActivityById(ActivityReq req);
}
