package com.cps.lottery.infrastructure.dao;

import com.cps.lottery.infrastructure.po.RuleTreeNodeLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cps
 * @description: 规则树节点连线Dao
 * @date 2024/3/24 16:32
 * @OtherDescription: Other things
 */

@Mapper
public interface IRuleTreeNodeLineDao {

    /**
     * 查询规则树节点连线集合
     * @param req 入参
     * @return    规则树节点连线集合
     */
    List<RuleTreeNodeLine> queryRuleTreeNodeLineList(RuleTreeNodeLine req);

    /**
     * 查询规则树连线数量
     * @param treeId 规则树Id
     * @return       规则树连线数量
     */
    int queryTreeNodeLineCount(Long treeId);
}
