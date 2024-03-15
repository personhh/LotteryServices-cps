package com.cps.lottery.domain.support.ids;

import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.support.ids.policy.RandomNumeric;
import com.cps.lottery.domain.support.ids.policy.ShortCode;
import com.cps.lottery.domain.support.ids.policy.SnowFlake;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/15 15:28
 * @OtherDescription: Other things
 */
@Configuration
public class IdContext {

    /**
     * 创建 ID 生成策略对象，属于策略设计模式的使用方式
     *
     * @param snowFlake 雪花算法，长码，大量
     * @param shortCode 日期算法，短码，少量，全局唯一需要自己保证
     * @param randomNumeric 随机算法，短码，大量，全局唯一需要自己保证
     * @return IIdGenerator 实现类
     */

    @Bean
    public Map<Constants.Ids, IIdGenerator> idGenerator(SnowFlake snowFlake, ShortCode shortCode, RandomNumeric randomNumeric){
        HashMap<Constants.Ids, IIdGenerator> idGeneratorHashMap  = new HashMap<>(8);
        idGeneratorHashMap.put(Constants.Ids.SnowFlake, snowFlake);
        idGeneratorHashMap.put(Constants.Ids.ShortCode, shortCode);
        idGeneratorHashMap.put(Constants.Ids.RandomNumeric, randomNumeric);
        return idGeneratorHashMap;
    }
}
