package com.cps.lottery.domain.rule.service.engine;

import com.cps.lottery.domain.rule.model.req.DecisionMatterReq;
import com.cps.lottery.domain.rule.model.res.EngineResult;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/25 13:41
 * @OtherDescription: Other things
 */
public interface EngineFilter {

    /**
     * 规则过滤器接口
     * @param matter 规则决策物料
     * @return       规则决策结果
     */
    EngineResult process(final DecisionMatterReq matter);
}
