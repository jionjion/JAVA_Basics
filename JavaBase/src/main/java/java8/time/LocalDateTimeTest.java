package java8.time;

import org.junit.Test;

import java.time.*;
import java.time.temporal.TemporalUnit;

/**
 * @author Jion
 */
public class LocalDateTimeTest {

//    LocalDate 日期
//    LocalTime 时间

//    LocalDateTime 日期时间

    /** 获取当前 */
    @Test
    public void testNow(){
        // 获得当前时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }

    /** 指定日期时间 */
    @Test
    public void testOf(){
        // 获得指定时间 2019-10-01 12:30:10.100
        LocalDateTime time = LocalDateTime.of(2019, 10, 1, 12, 30, 10, 100);
        System.out.println(time);
    }

    /** 日期加 plusXXX方法 */
    @Test
    public void testPlus(){
        LocalDateTime now = LocalDateTime.now();
        // 增加一小时
        LocalDateTime time1 = now.plusHours(1);
        System.out.println(time1);
    }

    /** 日期减  minusXXX方法 */
    @Test
    public void testMinus(){
        LocalDateTime now = LocalDateTime.now();
        // 减一天
        LocalDateTime time2 = now.minusDays(1);
        System.out.println(time2);
    }

    /** 获得日期信息 */
    @Test
    public void testGet(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前年: " + now.getYear());
        System.out.println("当前月: " + now.getMonth());
        System.out.println("当前日: " + now.getDayOfMonth());
        System.out.println("当前小时: " + now.getHour());
    }
}
