package com.cps.lottery.domain.award.service.factory;

import com.cps.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/13 11:35
 * @OtherDescription: Other things
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig{

    public IDistributionGoods getDistributionGoodsService(Integer awardType){
        return goodsMap.get(awardType);
    }
}
