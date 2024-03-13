package com.cps.lottery.domain.award.service.goods.Impl;

import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.award.model.req.GoodsReq;
import com.cps.lottery.domain.award.model.res.DistributionRes;
import com.cps.lottery.domain.award.service.goods.DistributionBase;
import com.cps.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @author cps
 * @description: 兑换券
 * @date 2024/3/13 11:03
 * @OtherDescription: Other things
 */
@Component
public class CouponGoods extends DistributionBase implements IDistributionGoods {

    @Override
    public DistributionRes doDistribution(GoodsReq req) {

        //模拟调用优惠券发放接口
        logger.info("模拟调用优惠券发放接口 uId: {} awardContent: {}", req.getuId(), req.getAwardContent());

        //更新用户领奖结果
        super.updateUserAwardState(req.getuId(),req.getOrderId(), req.getAwardId(), Constants.AwardType.CouponGoods.getCode(), Constants.AwardType.CouponGoods.getInfo());

        return new DistributionRes(req.getuId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.CouponGoods.getCode();
    }
}
