package com.cps.lottery.domain.activity.repository;

import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.activity.model.req.PartakeReq;
import com.cps.lottery.domain.activity.model.vo.*;

import java.util.List;

/**
 * @author cps
 * @description: 活动仓库配置（活动表、奖品表、策略表、策略明细表）
 * @date 2024/3/14 10:57
 * @OtherDescription: Other things
 */
public interface IActivityRepository {

    /**
     *添加活动配置
     * */
    void addActivity(ActivityVO activityVO);

    /**
     * 添加奖品配置集合
     * */
    void addAward(List<AwardVO> awardList);

    /**
     * 添加策略明细配置
     * */
    void addStrategy(StrategyVO strategyVO);
    /**
     * 添加策略明细配置
     * */
    void addStrategyDetailLast(List<StrategyDetailVO> strategyDetailList);

    /**
     * 变更活动状态
     */
    boolean alterState(Long activeId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState);

    /**
     * 查询活动账单信息【库存、状态、日期、个人参与次数】
     * @param req 参与活动请求
     * @return    活动账单
     */
    ActivityBillVO queryActivityBill(PartakeReq req);

    /**
     * 扣减活动库存
     * @param activityId   活动ID
     * @return      扣减结果
     */
    int subtractionActivityStock(Long activityId);
}
