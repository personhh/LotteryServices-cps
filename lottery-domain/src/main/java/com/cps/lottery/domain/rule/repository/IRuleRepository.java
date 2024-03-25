package com.cps.lottery.domain.rule.repository;

import com.cps.lottery.domain.rule.model.aggregates.TreeRuleRich;

/**
 * @author cps
 * @description: 规则信息仓储服务接口
 * @date 2024/3/24 16:46
 * @OtherDescription: Other things
 */
public interface IRuleRepository {

    /**
     * 查询规则决策树配置
     * @param treeId 决策树Id
     * @return       决策树配置
     */
    TreeRuleRich queryTreeRuleRich(Long treeId);
}
