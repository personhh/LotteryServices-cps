package com.cps.lottery.domain.support.ids.policy;

import com.cps.lottery.domain.support.ids.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @author cps
 * @description: 随机算法
 * @date 2024/3/15 15:03
 * @OtherDescription: Other things
 */

@Component
public class RandomNumeric implements IIdGenerator {

    @Override
    public long nextId() {
        //随机生成11位数字
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }
}
