package com.cps.lottery.infrastructure.dao;

import com.cps.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cps
 * @description: 奖品表对应的持久化接口
 * @date 2024/3/8 14:38
 * @OtherDescription: Other things
 */
@Mapper
public interface IAwardDao {

    /**
     * 用奖品id查询奖品
     *
     * @param awardId 奖品id
     * @return 奖品对象
     */
    Award queryAwardInfo(String awardId);

    /**
     * 插入奖品配置
     */
    void insertList(List<Award> list);
}
