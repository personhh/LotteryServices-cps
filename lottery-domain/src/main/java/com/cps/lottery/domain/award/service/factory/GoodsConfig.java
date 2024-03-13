package com.cps.lottery.domain.award.service.factory;

import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.award.service.goods.IDistributionGoods;
import com.cps.lottery.domain.award.service.goods.Impl.CouponGoods;
import com.cps.lottery.domain.award.service.goods.Impl.DescGoods;
import com.cps.lottery.domain.award.service.goods.Impl.PhysicalGoods;
import com.cps.lottery.domain.award.service.goods.Impl.RedeemCodeGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cps
 * @description: 发放奖品配置类
 * @date 2024/3/13 11:36
 * @OtherDescription: Other things
 */
public class GoodsConfig {

    /** 奖品发放策略组*/
    protected static Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @Resource
    private DescGoods descGoods;

    @Resource
    private CouponGoods couponGoods;

    @Resource
    private PhysicalGoods physicalGoods;

    @Resource
    private RedeemCodeGoods redeemCodeGoods;

    @PostConstruct
    //初始化
    public void init(){
        goodsMap.put(Constants.AwardType.CouponGoods.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.PhysicalGoods.getCode(), physicalGoods);
        goodsMap.put(Constants.AwardType.RedeemCodeGoods.getCode(), redeemCodeGoods);
    }


}
