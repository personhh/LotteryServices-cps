package com.cps.lottery.test.util;

import com.cps.lottery.infrastructure.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author cps
 * @description: redis测试类
 * @date 2024/4/2 10:49
 * @OtherDescription: Other things
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisUtilTest {

    private Logger logger = LoggerFactory.getLogger(RedisUtilTest.class);

    @Resource
    private RedisUtil redisUtil;

    @Test
    public void redis_deleted_test(){
        redisUtil.del("nx1","k4");
        logger.info("redis删除成功");
    }

    @Test
    public void redis_hasKey_test(){
        boolean k1 = redisUtil.hasKey("k1");
        logger.info("redis查询结果：{}", k1 ? "成功" : "失败");
    }

    @Test
    public void redis_expire_test(){
        redisUtil.expire("k1", 3600);
        logger.info("redis缓存过期时间设置成功");
    }

    @Test
    public void redis_getExpire_test(){
        long k1_expireTime = redisUtil.getExpire("k1");
        logger.info("redis缓存过期时间获取: {}", k1_expireTime);
    }

    @Test
    public void redis_getString_test(){
        logger.info("普通缓存获取：{}", redisUtil.get("k1"));
    }

    @Test
    public void redis_setString_test(){
        logger.info("普通缓存放入：{}", redisUtil.set("stringK2","value2") ? "成功" : "失败");
    }

    @Test
    public void redis_setStringExpire_test(){
        logger.info("普通缓存放入并设置时间：{}", redisUtil.set("stringExpireK1", "valueExpireV2",60) ? "成功" : "失败");
    }

    @Test
    public void redis_incr_test(){
        logger.info("递增结果: {}", redisUtil.incr("incr1", 10));
    }

    @Test
    public void redis_decr_test(){
        logger.info("递增结果: {}", redisUtil.decr("incr1", 10));
    }

    @Test
    public void redis_setNX_test(){
        logger.info("加锁结果：{}", redisUtil.setNx("nx1",60000L) ? "成功" : "失败");
    }
}
