package com.cps.lottery.domain.activity.service.deploy.impl;

import com.alibaba.fastjson.JSON;
import com.cps.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import com.cps.lottery.domain.activity.model.req.ActivityConfigReq;
import com.cps.lottery.domain.activity.model.vo.ActivityVO;
import com.cps.lottery.domain.activity.model.vo.AwardVO;
import com.cps.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.cps.lottery.domain.activity.model.vo.StrategyVO;
import com.cps.lottery.domain.activity.repository.IActivityRepository;
import com.cps.lottery.domain.activity.service.deploy.IActivityDeploy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cps
 * @description: 部署活动配置实现类
 * @date 2024/3/15 10:26
 * @OtherDescription: Other things
 */
@Service
public class ActivityDeployImpl implements IActivityDeploy {

    private Logger logger = LoggerFactory.getLogger(ActivityDeployImpl.class);

    @Resource
    private IActivityRepository activityRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createActivity(ActivityConfigReq req) {
        logger.info("创建活动配置开始，activityId：{}", req.getActivityId());
        ActivityConfigRich activityConfigRich = req.getActivityConfigRich();
        try{
            //添加活动配置
            ActivityVO activityVO = activityConfigRich.getActivityVO();
            activityRepository.addActivity(activityVO);

            //添加奖品配置
            List<AwardVO> awardVOList = activityConfigRich.getAwardVOList();
            activityRepository.addAward(awardVOList);

            //添加策略配置
            StrategyVO strategyVO = activityConfigRich.getStrategyVO();
            activityRepository.addStrategy(strategyVO);

            //添加策略明细配置
            List<StrategyDetailVO> strategyDetailList = activityConfigRich.getStrategyVO().getStrategyDetailList();
            activityRepository.addStrategyDetailLast(strategyDetailList);

            logger.info("创建活动配置成功, activity: {}", req.getActivityId());

        }catch (DuplicateKeyException e){
            logger.info("创建活动配置失败，唯一索引冲突 activityId: {} reqJson: {}", req.getActivityId(), JSON.toJSONString(req),e);
            throw e;
        }
    }

    @Override
    public void updateActivity(ActivityConfigReq req) {
        //TODO: 改方法后续补充
    }
}
