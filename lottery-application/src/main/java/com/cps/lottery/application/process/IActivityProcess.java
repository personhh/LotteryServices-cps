package com.cps.lottery.application.process;

import com.cps.lottery.application.process.req.DrawProcessReq;
import com.cps.lottery.application.process.res.DrawProcessResult;

/**
 * @author cps
 * @description: 活动抽奖流程编排接口
 * @date 2024/3/22 14:49
 * @OtherDescription: Other things
 */
public interface IActivityProcess {

    DrawProcessResult doDrawProcess(DrawProcessReq req);
}
