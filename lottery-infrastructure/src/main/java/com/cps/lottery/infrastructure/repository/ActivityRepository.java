package com.cps.lottery.infrastructure.repository;

import com.cps.lottery.common.Constants;
import com.cps.lottery.domain.activity.model.vo.*;
import com.cps.lottery.domain.activity.repository.IActivityRepository;
import com.cps.lottery.infrastructure.dao.IActivityDao;
import com.cps.lottery.infrastructure.dao.IAwardDao;
import com.cps.lottery.infrastructure.dao.IStrategyDao;
import com.cps.lottery.infrastructure.dao.IStrategyDetailDao;
import com.cps.lottery.infrastructure.po.Activity;
import com.cps.lottery.infrastructure.po.Award;
import com.cps.lottery.infrastructure.po.Strategy;
import com.cps.lottery.infrastructure.po.StrategyDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/14 13:12
 * @OtherDescription: Other things
 */

@Component
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IActivityDao activityDao;
    @Resource
    private IAwardDao awardDao;
    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Override
    public void addActivity(ActivityVO activityVO) {
        Activity req = new Activity();
        BeanUtils.copyProperties(activityVO, req);
        activityDao.insert(req);
    }

    @Override
    public void addAward(List<AwardVO> awardList) {
        ArrayList<Award> req = new ArrayList<>();
        for(AwardVO awardVO : awardList){
            Award award = new Award();
            BeanUtils.copyProperties(awardVO, award);
            req.add(award);
        }
        awardDao.insertList(req);

    }

    @Override
    public void addStrategy(StrategyVO strategyVO) {
        Strategy req = new Strategy();
        BeanUtils.copyProperties(strategyVO, req);
        strategyDao.insert(req);
    }

    @Override
    public void addStrategyDetailLast(List<StrategyDetailVO> strategyDetailList) {
        List<StrategyDetail> req = new ArrayList<>();
        for(StrategyDetailVO strategyDetailVO : strategyDetailList){
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtils.copyProperties(strategyDetailVO, strategyDetail);
            req.add(strategyDetail);
        }
        strategyDetailDao.insertList(req);
    }

    @Override
    public boolean alterState(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId,((Constants.ActivityState) beforeState).getCode(),((Constants.ActivityState) afterState).getCode());
        int count = activityDao.alterState(alterStateVO);
        return 1 == count;
    }
}
