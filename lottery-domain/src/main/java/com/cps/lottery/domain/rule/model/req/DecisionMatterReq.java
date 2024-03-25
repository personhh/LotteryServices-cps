package com.cps.lottery.domain.rule.model.req;

import java.util.Map;

/**
 * @author cps
 * @description: 决策物料
 * @date 2024/3/24 16:38
 * @OtherDescription: Other things
 */
public class DecisionMatterReq {

    /** 规则书ID */
    private Long treeId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 决策值
     */
    private Map<String, Object> valMap;

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Object> getValMap() {
        return valMap;
    }

    public void setValMap(Map<String, Object> valMap) {
        this.valMap = valMap;
    }
}
