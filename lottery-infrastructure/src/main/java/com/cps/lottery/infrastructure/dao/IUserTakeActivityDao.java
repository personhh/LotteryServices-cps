package com.cps.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import com.cps.lottery.infrastructure.po.UserTakeActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cps
 * @description: 用户领取活动表DAO
 * @date 2024/3/18 11:34
 * @OtherDescription: Other things
 */
@Mapper
public interface IUserTakeActivityDao {

    /**
     * 插入用户领取活动信息
     *
     * @param userTakeActivity 入参
     */
    @DBRouter(key = "uId")
    void insert(UserTakeActivity userTakeActivity);
}
