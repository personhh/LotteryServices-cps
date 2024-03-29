package com.cps.lottery.infrastructure.repository;

import com.cps.lottery.domain.award.repository.IOrderRepository;
import com.cps.lottery.infrastructure.dao.IUserStrategyExportDao;
import com.cps.lottery.infrastructure.po.UserStrategyExport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author cps
 * @description: 奖品表仓储服务
 * @date 2024/3/13 10:41
 * @OtherDescription: Other things
 */

@Component
public class OrderRepository implements IOrderRepository {

    @Resource
    private IUserStrategyExportDao userStrategyExportDao;
    @Override
    public void updateUserAwardState(String uId, Long orderId, String awardId, Integer grantState) {
        UserStrategyExport userStrategyExport = new UserStrategyExport();
        userStrategyExport.setuId(uId);
        userStrategyExport.setOrderId(orderId);
        userStrategyExport.setAwardId(awardId);
        userStrategyExport.setGrantState(grantState);
        userStrategyExportDao.updateUserAwardState(userStrategyExport);
    }
}
