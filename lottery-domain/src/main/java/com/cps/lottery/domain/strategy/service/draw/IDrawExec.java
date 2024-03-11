package com.cps.lottery.domain.strategy.service.draw;

import com.cps.lottery.domain.strategy.model.req.DrawReq;
import com.cps.lottery.domain.strategy.model.res.DrawResult;

/**
 * @author cps
 * @description: 抽奖执行接口（主要就是用来执行抽奖策略）
 * @date 2024/3/11 09:58
 * @OtherDescription: Other things
 */
public interface IDrawExec {

    /**
     * 执行抽奖策略，返回奖品结果
     */
    DrawResult doDrawExec(DrawReq req);

}
