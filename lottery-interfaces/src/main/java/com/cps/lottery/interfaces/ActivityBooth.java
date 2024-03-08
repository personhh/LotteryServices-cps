package com.cps.lottery.interfaces;

import com.cps.lottery.common.Constants;
import com.cps.lottery.common.Result;
import com.cps.lottery.infrastructure.dao.IActivityDao;
import com.cps.lottery.infrastructure.po.Activity;
import com.cps.lottery.rpc.IActivityBooth;

import com.cps.lottery.rpc.dto.ActivityDto;
import com.cps.lottery.rpc.req.ActivityReq;
import com.cps.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/7 15:35
 * @OtherDescription: Other things
 */
@DubboService
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {
        Activity activity = activityDao.queryActivityById(req.getActivityById());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDataTime(activity.getBeginDateTime());
        activityDto.setEndDataTime(activity.getEndDataTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
    }
}
