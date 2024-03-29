package com.cps.lottery.domain.activity.service.partake;

import com.cps.lottery.common.Result;
import com.cps.lottery.domain.activity.model.req.PartakeReq;
import com.cps.lottery.domain.activity.model.res.PartakeResult;
import com.cps.lottery.domain.activity.model.vo.DrawOrderVO;

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

    /**
     * 保存奖品单
     * @param drawOrder 奖品单
     * @return          保存结果
     */
    Result recordDrawOrder(DrawOrderVO drawOrder);

    /**
     * 更新发货单MQ状态
     *
     * @param uId 用户ID
     * @param orderId 订单ID
     * @param mqState MQ 发送状态
     */
    void updateInvoiceMqState(String uId, Long orderId, Integer mqState);
}
