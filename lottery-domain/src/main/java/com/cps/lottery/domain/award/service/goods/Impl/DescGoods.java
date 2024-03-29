package com.cps.lottery.domain.award.service.goods.Impl;

import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.award.model.req.GoodsReq;
import com.cps.lottery.domain.award.model.res.DistributionRes;
import com.cps.lottery.domain.award.service.goods.DistributionBase;
import com.cps.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @author cps
 * @description: 描述类商品，以文字形势展示给用户
 * @date 2024/3/13 11:03
 * @OtherDescription: Other things
 */
@Component
public class DescGoods extends DistributionBase implements IDistributionGoods {
    @Override
    public DistributionRes doDistribution(GoodsReq req) {
        logger.info("模拟描述类商品发放接口 uId: {} awardContent: {}", req.getuId(),req.getAwardContent());

        super.updateUserAwardState(req.getuId(), req.getOrderId(), req.getAwardId(), Constants.GrantState.COMPLETE.getCode());

        return new DistributionRes(req.getuId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.DESC.getCode();
    }
}
