package com.cps.lottery.application.process;

import com.cps.lottery.application.process.req.DrawProcessReq;
import com.cps.lottery.application.process.res.DrawProcessResult;
import com.cps.lottery.application.process.res.RuleQuantificationCrowdResult;
import com.cps.lottery.domain.rule.model.req.DecisionMatterReq;

/**
 * @author cps
 * @description: 活动抽奖流程编排接口
 * @date 2024/3/22 14:49
 * @OtherDescription: Other things
 */
public interface IActivityProcess {

    /**
     * 执行抽奖流程
     * @param req 抽奖请求
     * @return    抽奖结果
     */
    DrawProcessResult doDrawProcess(DrawProcessReq req);

    /**
     * 规则量化人群，返回可参与的活动ID
     * @param req   规则请求
     * @return      量化结果，用户可以参与的活动ID
     */
    RuleQuantificationCrowdResult doRuleQuantificationCrowd(DecisionMatterReq req);


}
