package com.cps.lottery.infrastructure.dao;


import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import com.cps.lottery.infrastructure.po.UserStrategyExport;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/18 11:44
 * @OtherDescription: Other things
 */
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserStrategyExportDao {

    /**
     * 新增数据
     *
     * @param userStrategyExport 用户策略
     */

    @DBRouter(key = "uId")
    void insert(UserStrategyExport userStrategyExport);


    /**
     * 查询数据
     * @param uId 用户ID
     * @return 用户策略
     */
    @DBRouter
    UserStrategyExport queryUserStrategyExportByuId(String uId);
}
