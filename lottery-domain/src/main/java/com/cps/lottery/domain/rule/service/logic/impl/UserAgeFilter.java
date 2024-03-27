package com.cps.lottery.domain.rule.service.logic.impl;

import com.cps.lottery.domain.rule.model.req.DecisionMatterReq;
import com.cps.lottery.domain.rule.service.logic.BaseLogic;
import org.springframework.stereotype.Component;

/**
 * @author cps
 * @description: 年龄规则
 * @date 2024/3/25 13:52
 * @OtherDescription: Other things
 */
@Component
public class UserAgeFilter extends BaseLogic {

    @Override
    public String matterValue(DecisionMatterReq decisionMatter) {
        return decisionMatter.getValMap().get("age").toString();
    }
}