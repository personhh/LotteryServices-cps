package com.cps.lottery.domain.rule.service.engine;

import com.cps.lottery.domain.rule.service.logic.LogicFilter;
import com.cps.lottery.domain.rule.service.logic.impl.UserAgeFilter;
import com.cps.lottery.domain.rule.service.logic.impl.UserGenderFilter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cps
 * @description: 规则配置
 * @date 2024/3/25 14:04
 * @OtherDescription: Other things
 */
public class EngineConfig {

    protected static Map<String, LogicFilter> logicFilterMap = new ConcurrentHashMap<>();

    @Resource
    private UserAgeFilter userAgeFilter;

    @Resource
    private UserGenderFilter userGenderFilter;

    @PostConstruct
    public void init(){
        logicFilterMap.put("userAge", userAgeFilter);
        logicFilterMap.put("userGender", userGenderFilter);
    }
}
