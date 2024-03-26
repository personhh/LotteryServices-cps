package com.cps.lottery.application.process.res;

import com.cps.lottery.common.Result;
import com.cps.lottery.domain.strategy.model.vo.DrawAwardInfo;
import com.cps.lottery.domain.strategy.model.vo.DrawAwardVO;

/**
 * @author cps
 * @description: 活动抽奖结果
 * @date 2024/3/22 14:50
 * @OtherDescription: Other things
 */
public class DrawProcessResult extends Result {

    private DrawAwardVO drawAwardVO;
    public DrawProcessResult(String code, String info) {
        super(code, info);
    }

    public DrawProcessResult(String code, String info, DrawAwardVO drawAwardVO) {
        super(code, info);
        this.drawAwardVO = drawAwardVO;
    }

    public DrawAwardVO getDrawAwardVO() {
        return drawAwardVO;
    }

    public void setDrawAwardVO(DrawAwardVO drawAwardVO) {
        this.drawAwardVO = drawAwardVO;
    }
}
