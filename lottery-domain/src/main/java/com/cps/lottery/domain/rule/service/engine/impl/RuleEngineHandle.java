package com.cps.lottery.domain.rule.service.engine.impl;

import com.cps.lottery.domain.rule.model.aggregates.TreeRuleRich;
import com.cps.lottery.domain.rule.model.req.DecisionMatterReq;
import com.cps.lottery.domain.rule.model.res.EngineResult;
import com.cps.lottery.domain.rule.model.vo.TreeNodeVO;
import com.cps.lottery.domain.rule.repository.IRuleRepository;
import com.cps.lottery.domain.rule.service.engine.EngineBase;
import com.cps.lottery.domain.rule.service.engine.EngineFilter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/25 14:24
 * @OtherDescription: Other things
 */
@Service("ruleEngineHandle")
public class RuleEngineHandle extends EngineBase {

    @Resource
    private IRuleRepository ruleRepository;

    @Override
    public EngineResult process(DecisionMatterReq matter) {
        //决策规则树
        TreeRuleRich treeRuleRich = ruleRepository.queryTreeRuleRich(matter.getTreeId());
        if(null == treeRuleRich){
            throw new RuntimeException("Tree Rule is null");
        }

        //决策节点
        TreeNodeVO treeNodeInfo = engineDecisionMaker(treeRuleRich, matter);
        return new EngineResult(matter.getUserId(), treeNodeInfo.getTreeId(), treeNodeInfo.getTreeNodeId(), treeNodeInfo.getNodeValue());
    }
}
