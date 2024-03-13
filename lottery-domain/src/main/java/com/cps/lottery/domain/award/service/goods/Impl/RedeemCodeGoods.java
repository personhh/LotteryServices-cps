package com.cps.lottery.domain.award.service.goods.Impl;

import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.award.model.req.GoodsReq;
import com.cps.lottery.domain.award.model.res.DistributionRes;
import com.cps.lottery.domain.award.service.goods.DistributionBase;
import com.cps.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @description: 兑换码
 * @author cps
 * @date 2024/3/13 11:04
 * @OtherDescription: Other things
 */
@Component
public class RedeemCodeGoods extends DistributionBase implements IDistributionGoods {
    @Override
    public DistributionRes doDistribution(GoodsReq req) {
        logger.info("模拟兑换码商品发放接口 uId: {} awardContent: {}", req.getuId(),req.getAwardContent());

        super.updateUserAwardState(req.getuId(), req.getOrderId(), req.getAwardId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(req.getuId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.RedeemCodeGoods.getCode();
    }
}
