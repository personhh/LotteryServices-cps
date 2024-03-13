package com.cps.lottery.domain.award.service.goods;

import com.cps.lottery.domain.award.model.req.GoodsReq;
import com.cps.lottery.domain.award.model.res.DistributionRes;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/13 10:43
 * @OtherDescription: Other things
 */
public interface IDistributionGoods {
    /**
     * 奖品配送，四种奖品类型不同实现
     */

    DistributionRes doDistribution(GoodsReq req);

    /**
     * 获得配送奖品名字
     */
    Integer getDistributionGoodsName();
}
