package com.cps.lottery.rpc.res;

import com.cps.lottery.common.Result;
import com.cps.lottery.rpc.dto.ActivityDto;

import java.io.Serializable;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/7 13:19
 * @OtherDescription: Other things
 */
public class ActivityRes implements Serializable {

    private Result result;

    private ActivityDto activity;

    public ActivityRes(){

    }

    public ActivityRes(Result result, ActivityDto activity) {
        this.result = result;
        this.activity = activity;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ActivityDto getActivity() {
        return activity;
    }

    public void setActivity(ActivityDto activity) {
        this.activity = activity;
    }
}
