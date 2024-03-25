package com.cps.lottery.infrastructure.dao;

import com.cps.lottery.infrastructure.po.RuleTreeNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cps
 * @description: 规则树节点Dao
 * @date 2024/3/24 16:26
 * @OtherDescription: Other things
 */

@Mapper
public interface IRuleTreeNodeDao {

    /**
     * 查询规则树节点
     * @param treeId 规则树Id
     * @return       规则树节点集合
     */
    List<RuleTreeNode> queryRuleTreeNodeList(Long treeId);

    /**
     * 查询规则树节点数量
     *
     * @param treeId 规则树Id
     * @return       节点数量
     */
    int queryTreeNodeCount(Long treeId);


    /**
     * 查询规则树节点
     *
     * @param treeId 规则树Id
     * @return       节点集合
     */
    List<RuleTreeNode> queryTreeRulePoint(Long treeId);
}
