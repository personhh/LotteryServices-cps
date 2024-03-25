package com.cps.lottery.infrastructure.repository;

import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.rule.model.aggregates.TreeRuleRich;
import com.cps.lottery.domain.rule.model.vo.TreeNodeLineVO;
import com.cps.lottery.domain.rule.model.vo.TreeNodeVO;
import com.cps.lottery.domain.rule.model.vo.TreeRootVO;
import com.cps.lottery.domain.rule.repository.IRuleRepository;
import com.cps.lottery.infrastructure.dao.IRuleTreeDao;
import com.cps.lottery.infrastructure.dao.IRuleTreeNodeDao;
import com.cps.lottery.infrastructure.dao.IRuleTreeNodeLineDao;
import com.cps.lottery.infrastructure.po.RuleTree;
import com.cps.lottery.infrastructure.po.RuleTreeNode;
import com.cps.lottery.infrastructure.po.RuleTreeNodeLine;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cps
 * @description: 规则信息仓储服务
 * @date 2024/3/24 16:51
 * @OtherDescription: Other things
 */
@Repository
public class RuleRepository implements IRuleRepository {

    @Resource
    private IRuleTreeDao ruleTreeDao;

    @Resource
    private IRuleTreeNodeDao ruleTreeNodeDao;

    @Resource
    private IRuleTreeNodeLineDao iRuleTreeNodeLineDao;

    @Override
    public TreeRuleRich queryTreeRuleRich(Long treeId) {
        //根据树id查询封装好TreeRootVO的对象
        RuleTree ruleTree = ruleTreeDao.queryRuleTreeByTreeId(treeId);
        TreeRootVO treeRoot = new TreeRootVO();
        treeRoot.setTreeId(ruleTree.getId());
        treeRoot.setTreeRootNodeId(ruleTree.getTreeRootNodeId());
        treeRoot.setTreeName(ruleTree.getTreeName());

        //树节点->树连接线
        Map<Long, TreeNodeVO> treeNodeMap = new HashMap<>();
        //根据树id查找规则树节点列表
        List<RuleTreeNode> ruleTreeNodeList = ruleTreeNodeDao.queryRuleTreeNodeList(treeId);

        //遍历每一个树节点对象
        for(RuleTreeNode treeNode : ruleTreeNodeList){
            List<TreeNodeLineVO> treeNodeLineInfoList = new ArrayList<>();
            //判断当前树节点是不是树颈，是的话就把树颈下所有的树颈信息封装到集合里
            if(Constants.NodeType.STEM.equals(treeNode.getNodeType())){

                //通过规则树id和开始节点来查找树颈
                RuleTreeNodeLine ruleTreeNodeLineReq = new RuleTreeNodeLine();
                ruleTreeNodeLineReq.setTreeId(treeId);
                ruleTreeNodeLineReq.setNodeIdFrom(treeNode.getId());
                List<RuleTreeNodeLine> ruleTreeNodeLineList = iRuleTreeNodeLineDao.queryRuleTreeNodeLineList(ruleTreeNodeLineReq);

                //把当前节点下的所有直连树颈全都放到树颈集合中
                for(RuleTreeNodeLine nodeLine : ruleTreeNodeLineList){
                    TreeNodeLineVO treeNodeLineInfo = new TreeNodeLineVO();
                    treeNodeLineInfo.setNodeIdFrom(nodeLine.getNodeIdFrom());
                    treeNodeLineInfo.setNodeIdTo(nodeLine.getNodeIdTo());
                    treeNodeLineInfo.setRuleLimitType(nodeLine.getRuleLimitType());
                    treeNodeLineInfo.setRuleLimitValue(nodeLine.getRuleLimitValue());
                    //加入到树颈集合中
                    treeNodeLineInfoList.add(treeNodeLineInfo);
                }
            }

            //创建一个规则树节点信息的对象
            TreeNodeVO treeNodeInfo = new TreeNodeVO();
            treeNodeInfo.setTreeId(treeNode.getTreeId());
            treeNodeInfo.setTreeNodeId(treeNode.getId());
            treeNodeInfo.setNodeType(treeNode.getNodeType());
            treeNodeInfo.setNodeValue(treeNode.getNodeValue());
            treeNodeInfo.setRuleKey(treeNode.getRuleKey());
            treeNodeInfo.setRuleDesc(treeNode.getRuleDesc());
            treeNodeInfo.setTreeNodeLineInfoList(treeNodeLineInfoList);

            treeNodeMap.put(treeNode.getId(), treeNodeInfo);
        }

        TreeRuleRich treeRuleRich = new TreeRuleRich();
        treeRuleRich.setTreeRoot(treeRoot);
        treeRuleRich.setTreeNodeMap(treeNodeMap);
        return treeRuleRich;
    }
}
