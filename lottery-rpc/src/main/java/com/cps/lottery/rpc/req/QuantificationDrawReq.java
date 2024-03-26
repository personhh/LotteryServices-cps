package com.cps.lottery.rpc.req;

import java.util.Map;

/**
 * @author cps
 * @description: 量化人群抽奖请求参数
 * @date 2024/3/26 11:17
 * @OtherDescription: Other things
 */
public class QuantificationDrawReq {
    /** 用户ID */
    private String uId;
    /** 规则树ID */
    private Long treeId;
    /** 决策值 */
    private Map<String, Object> valMap;

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Map<String, Object> getValMap() {
        return valMap;
    }

    public void setValMap(Map<String, Object> valMap) {
        this.valMap = valMap;
    }
}
