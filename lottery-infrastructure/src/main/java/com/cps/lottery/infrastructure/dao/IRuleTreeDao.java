package com.cps.lottery.infrastructure.dao;

import com.cps.lottery.infrastructure.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cps
 * @description: 规则树配置DAO
 * @date 2024/3/24 16:14
 * @OtherDescription: Other things
 */
@Mapper
public interface IRuleTreeDao {

    /**
     * 规则树查询
     * @param id ID
     * @return   规则树
     */
    RuleTree queryRuleTreeByTreeId(Long id);

    /**
     * 规则树简要信息查询
     * @param treeId 规则树Id
     * @return       规则树
     */
    RuleTree queryTreeSummaryInfo(Long treeId);
}
