package com.cps.lottery.application.process.res;

import com.cps.lottery.common.Result;
import com.cps.lottery.domain.strategy.model.vo.DrawAwardInfo;

/**
 * @author cps
 * @description: 活动抽奖结果
 * @date 2024/3/22 14:50
 * @OtherDescription: Other things
 */
public class DrawProcessResult extends Result {

    private DrawAwardInfo drawAwardInfo;
    public DrawProcessResult(String code, String info) {
        super(code, info);
    }

    public DrawProcessResult(String code, String info, DrawAwardInfo drawAwardInfo) {
        super(code, info);
        this.drawAwardInfo = drawAwardInfo;
    }

    public DrawAwardInfo getDrawAwardInfo() {
        return drawAwardInfo;
    }

    public void setDrawAwardInfo(DrawAwardInfo drawAwardInfo) {
        this.drawAwardInfo = drawAwardInfo;
    }
}
