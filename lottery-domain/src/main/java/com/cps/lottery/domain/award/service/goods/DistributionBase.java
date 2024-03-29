package com.cps.lottery.domain.award.service.goods;


import com.cps.lottery.domain.award.repository.IOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author cps
 * @description: 配送货物基础公共类
 * @date 2024/3/13 10:44
 * @OtherDescription: Other things
 */
public class DistributionBase {

    protected Logger logger = LoggerFactory.getLogger(DistributionBase.class);

    @Resource
    private IOrderRepository awardRepository;

    protected void updateUserAwardState(String uId, Long orderId, String awardId, Integer grandState){
        awardRepository.updateUserAwardState(uId, orderId, awardId, grandState);
    }
}
