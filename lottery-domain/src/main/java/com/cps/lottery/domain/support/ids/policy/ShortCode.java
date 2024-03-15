package com.cps.lottery.domain.support.ids.policy;

import com.cps.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Random;

/**
 * @author cps
 * @description: 短码生成策略，仅支持很小的调用量，用于生成活动配置类编号，保证全局唯一
 * @date 2024/3/15 15:08
 * @OtherDescription: Other things
 */
@Component
public class ShortCode implements IIdGenerator {

    //返回拼接后的时间
    @Override
    public long nextId() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int days = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR);

        //打乱顺序继续重新排序：2023年为基准 + 小时 + 周期 + 日 + 三位随机数
        StringBuilder idStr = new StringBuilder();
        idStr.append(year - 2023);
        idStr.append(hour);
        idStr.append(week);
        idStr.append(days);
        idStr.append(String.format("%03d", new Random().nextInt(1000)));
        return Long.parseLong(idStr.toString());
    }
}
