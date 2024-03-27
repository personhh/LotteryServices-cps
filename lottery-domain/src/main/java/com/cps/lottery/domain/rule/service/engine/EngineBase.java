package com.cps.lottery.domain.rule.service.engine;

import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.rule.model.aggregates.TreeRuleRich;
import com.cps.lottery.domain.rule.model.req.DecisionMatterReq;
import com.cps.lottery.domain.rule.model.res.EngineResult;
import com.cps.lottery.domain.rule.model.vo.TreeNodeVO;
import com.cps.lottery.domain.rule.model.vo.TreeRootVO;
import com.cps.lottery.domain.rule.service.logic.LogicFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/25 14:01
 * @OtherDescription: Other things
 */
public class EngineBase extends EngineConfig implements EngineFilter{


    private Logger logger = LoggerFactory.getLogger(EngineBase.class);

    @Override
    public EngineResult process(DecisionMatterReq matter) {
        throw new RuntimeException("未实现规则引擎服务");
    }

    protected TreeNodeVO engineDecisionMaker(TreeRuleRich treeRuleRich, DecisionMatterReq matter){
        TreeRootVO treeRoot = treeRuleRich.getTreeRoot();
        Map<Long, TreeNodeVO> treeNodeMap = treeRuleRich.getTreeNodeMap();

        //规则树根节点Id 去找整个树
        Long rootNodeId = treeRoot.getTreeRootNodeId();
        TreeNodeVO treeNodeInfo = treeNodeMap.get(rootNodeId);

        //节点类型：1子叶 2果实
        while(Constants.NodeType.STEM.equals(treeNodeInfo.getNodeType())){
            String ruleKey = treeNodeInfo.getRuleKey();
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            String matterValue = logicFilter.matterValue(matter);
            Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLineInfoList());
            treeNodeInfo = treeNodeMap.get(nextNode);
            logger.info("决策树引擎=>{} userId: {} treeId: {} treeNode: {} ruleKey: {} matterValue: {}", treeRoot.getTreeName(), matter.getUserId(), matter.getTreeId(), treeNodeInfo.getTreeNodeId(), ruleKey, matterValue);
        }

        return treeNodeInfo;
    }
}