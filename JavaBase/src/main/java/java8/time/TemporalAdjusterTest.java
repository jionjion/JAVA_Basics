package java8.time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 *  @author Jion
 *      日期矫正器
 *          TemporalAdjuster接口,定义实现规则
 *          TemporalAdjusters提供了大量矫正模板
 */
public class TemporalAdjusterTest {

    @Test
    public void test(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间: " + now);

        // 日期矫正,调整到月末
        LocalDateTime dateTime1 = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("月末: " + dateTime1);

        // 下个周日
        LocalDateTime dateTime2 = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(dateTime2);

        // 自定义日期规则
        LocalDateTime dateTime3 = now.with(temporal -> {
            LocalDateTime localDateTime = (LocalDateTime) temporal;
            // ....
            // 将日期返回
            return  localDateTime;
        });
        System.out.println(dateTime3);
    }
}
