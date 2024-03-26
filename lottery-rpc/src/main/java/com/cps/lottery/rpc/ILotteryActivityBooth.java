package com.cps.lottery.rpc;

import com.cps.lottery.rpc.req.DrawReq;
import com.cps.lottery.rpc.req.QuantificationDrawReq;
import com.cps.lottery.rpc.res.DrawRes;

/**
 * @author cps
 * @description: 抽奖活动展台接口
 * @date 2024/3/26 11:16
 * @OtherDescription: Other things
 */
public interface ILotteryActivityBooth {

    /**
     * 指定活动抽奖
     * @param drawReq 请求参数
     * @return        抽奖结果
     */
    DrawRes doDraw(DrawReq drawReq);

    /**
     * 量化人群抽奖
     * @param quantificationDrawReq 请求参数
     * @return                      抽奖结果
     */
    DrawRes doQuantificationDraw(QuantificationDrawReq quantificationDrawReq);
}
