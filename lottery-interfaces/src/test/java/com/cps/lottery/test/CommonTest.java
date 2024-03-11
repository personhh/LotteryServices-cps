package com.cps.lottery.test;

import org.junit.Test;

import java.security.SecureRandom;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/10 22:31
 * @OtherDescription: Other things
 */
public class CommonTest {

    @Test
    public void test_Random(){
        SecureRandom secureRandom = new SecureRandom();
        int idx = secureRandom.nextInt(100);
        System.out.println(idx);
    }
}
