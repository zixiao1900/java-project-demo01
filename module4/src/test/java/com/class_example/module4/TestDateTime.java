package com.class_example.module4;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * LocalDateTime - 年月日时分秒
 * LocalTime - 时分秒
 * LocalDate - 年月日
 */
public class TestDateTime {
    public static void main(String[] args) {
        LocalDateTime dt1 = LocalDateTime.of(2022, 7, 4, 10, 30, 22);

        LocalTime t1 = LocalTime.of(10, 30, 22);

        // 1. 计算
        System.out.println(dt1.plusDays(27)); // 7.4 + 27天 = 7月31日
        System.out.println(dt1.plusDays(28)); // 7.4 + 28天 = 8月1日
        System.out.println(dt1.minusDays(4)); // 7.4 - 4天 = 6月30日

        // 2. 获取当前时间
        System.out.println(LocalDateTime.now()); // 2023-01-05T00:12:22.733
        System.out.println(LocalTime.now()); // 00:12:22.733

        // 3. 字符串 => LocalDateTime 就可以轻松拿到月份 日期 小时等等
        String dateTime = "2022-04-25T12:30:05";

        LocalDateTime dt2 = LocalDateTime.parse(dateTime);
        System.out.println(dt2.getYear()); // 2022
        System.out.println(dt2.getMonth()); // APRIL
        System.out.println(dt2.getMonthValue()); // 4
        System.out.println(dt2.getDayOfMonth()); // 25
        System.out.println(dt2.getHour()); // 12
        System.out.println(dt2.getMinute()); // 30
        System.out.println(dt2.getSecond()); // 5


        String time = "00:06:28";

        LocalTime t2 = LocalTime.parse(time);
        System.out.println(t2.getHour());
        System.out.println(t2.getMinute());
        System.out.println(t2.getSecond());
    }
}
