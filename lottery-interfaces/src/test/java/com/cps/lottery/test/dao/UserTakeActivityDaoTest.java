package com.cps.lottery.test.dao;

import com.cps.lottery.infrastructure.dao.IUserTakeActivityDao;
import com.cps.lottery.infrastructure.po.UserTakeActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @author cps
 * @description: TODO
 * @date 2024/3/18 13:13
 * @OtherDescription: Other things
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTakeActivityDaoTest {

    @Resource
    private IUserTakeActivityDao userTakeActivityDao;

    @Test
    public void test_insert(){
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setuId("0dl"); // 1库：Ukdli109op89oi 2库：Ukdli109op811d
        userTakeActivity.setTakeId(121019889410L);
        userTakeActivity.setActivityId(100001L);
        userTakeActivity.setActivityName("测试活动");
        userTakeActivity.setTakeDate(new Date());
        userTakeActivity.setTakeCount(10);
        userTakeActivity.setUuid("0dl");

        userTakeActivityDao.insert(userTakeActivity);
    }
}
