package com.cps.lottery.domain.award.repository;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/13 10:40
 * @OtherDescription: Other things
 */
public interface IOrderRepository {
    /**
     * 更新奖品发放状态
     *
     * @param uId               用户ID
     * @param orderId           订单ID
     * @param awardId           奖品ID
     * @param grantState        奖品状态
     */
    void updateUserAwardState(String uId, Long orderId, String awardId, Integer grantState);

}
