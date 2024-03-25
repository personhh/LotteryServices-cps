package com.cps.lottery.domain.rule.service.logic;

import com.cps.lottery.domain.rule.model.req.DecisionMatterReq;
import com.cps.lottery.domain.rule.model.vo.TreeNodeLineVO;

import java.util.List;

/**
 * @author cps
 * @description: 规则过滤器接口
 * @date 2024/3/25 13:41
 * @OtherDescription: Other things
 */
public interface LogicFilter {

    /**
     * 逻辑决策器
     * @param matterValue 决策值
     * @param treeNodeLineInfoList 决策节点
     * @return     下一个节点Id
     */
    Long filter(String matterValue, List<TreeNodeLineVO> treeNodeLineInfoList);

    /**
     * 获取决策值
     *
     * @param decisionMatter 决策物料
     * @return               决策值
     */
    String matterValue(DecisionMatterReq decisionMatter);
}
