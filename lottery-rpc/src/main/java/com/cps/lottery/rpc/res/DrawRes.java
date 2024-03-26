package com.cps.lottery.rpc.res;

import com.cps.lottery.common.Result;
import com.cps.lottery.rpc.dto.AwardDTO;

import java.io.Serializable;

/**
 * @author cps
 * @description: 抽奖结果
 * @date 2024/3/26 11:17
 * @OtherDescription: Other things
 */
public class DrawRes extends Result implements Serializable {

    private AwardDTO awardDTO;

    public DrawRes(String code, String info) {
        super(code, info);
    }

    public AwardDTO getAwardDTO() {
        return awardDTO;
    }

    public void setAwardDTO(AwardDTO awardDTO) {
        this.awardDTO = awardDTO;
    }
}
