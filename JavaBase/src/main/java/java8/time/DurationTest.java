package java8.time;

import org.junit.Test;

import java.time.*;

/**
 *  @author Jion
 *      Duration 类,用于计算时间之间的间隔
 */
public class DurationTest {

    @Test
    public void test(){
        // 时间
        LocalTime now = LocalTime.now();
        // 12:13:14.500
        LocalTime date = LocalTime.of(12,13,14,500);
        // 两个时间之间的差
        Duration between = Duration.between(date, now);

        System.out.println("时间差: " + between);
        System.out.println("小时差:"  + between.toHours());
        System.out.println("分钟差:"  + between.toMinutes());
        System.out.println("秒钟差:"  + between.getSeconds());
        System.out.println("毫秒差:"  + between.toMillis());
    }

}
