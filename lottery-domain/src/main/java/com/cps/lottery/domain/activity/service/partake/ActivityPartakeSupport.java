package com.cps.lottery.domain.activity.service.partake;

import com.cps.lottery.domain.activity.model.req.PartakeReq;
import com.cps.lottery.domain.activity.model.vo.ActivityBillVO;
import com.cps.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @author cps
 * @description: 活动领取模操作，一些通用
 * @date 2024/3/21 17:04
 * @OtherDescription: Other things
 */
public class ActivityPartakeSupport {

    @Resource
    protected IActivityRepository activityRepository;

    protected ActivityBillVO queryActivityBill(PartakeReq req){
        return activityRepository.queryActivityBill(req);
    }
}
