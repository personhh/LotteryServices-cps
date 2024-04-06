package com.cps.lottery.domain.activity.service.partake;

import com.cps.lottery.common.Result;
import com.cps.lottery.domain.activity.model.req.PartakeReq;
import com.cps.lottery.domain.activity.model.res.PartakeResult;
import com.cps.lottery.domain.activity.model.vo.ActivityPartakeRecordVO;
import com.cps.lottery.domain.activity.model.vo.DrawOrderVO;
import com.cps.lottery.domain.activity.model.vo.InvoiceVO;

import java.util.List;

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

    /**
     * 扫描发货单 MQ 状态，把未发送 MQ 的单子扫描出来，做补偿
     *
     * @param dbCount 指定分库
     * @param tbCount 指定分表
     * @return 发货单
     */
    List<InvoiceVO> scanInvoiceMqState(int dbCount, int tbCount);

    /**
     * 更新活动库存
     * @param activityPartakeRecordVO 活动领取记录
     */
    void updateActivityStock(ActivityPartakeRecordVO activityPartakeRecordVO);

}
