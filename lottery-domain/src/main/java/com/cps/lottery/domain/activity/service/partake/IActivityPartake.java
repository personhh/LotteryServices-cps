package com.cps.lottery.domain.activity.service.partake;

import com.cps.lottery.domain.activity.model.req.PartakeReq;
import com.cps.lottery.domain.activity.model.res.PartakeResult;

/**
 * @author cps
 * @description: 抽奖活动参与接口
 * @date 2024/3/15 11:59
 * @OtherDescription: Other things
 */
public interface IActivityPartake {

    /**
     * 参与活动
     * @param req 参与活动请求
     * @Return  领取结果
     */

    PartakeResult doPartake(PartakeReq req);
}
