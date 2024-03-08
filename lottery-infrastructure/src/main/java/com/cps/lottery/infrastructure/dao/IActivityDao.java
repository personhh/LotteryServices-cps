package com.cps.lottery.infrastructure.dao;

import com.cps.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/7 15:40
 * @OtherDescription: Other things
 */
@Mapper
public interface IActivityDao {

    void insert(Activity req);

    Activity queryActivityById(Long activityId);
}
