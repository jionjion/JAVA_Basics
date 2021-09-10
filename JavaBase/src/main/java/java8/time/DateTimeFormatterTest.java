package java8.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Jion
 *      DateTimeFormatter   日期格式化
 */
public class DateTimeFormatterTest {

    /** 日期格式化 */
    @Test
    public void testFormat(){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        LocalDateTime now = LocalDateTime.now();
        String result = now.format(formatter);
        System.out.println("日期格式化: " + result);
    }

    /** 自定义日期格式化 */
    @Test
    public void testFormat2(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 格式化
        String result = now.format(formatter);
        System.out.println("日期格式化: " + result);

        // 反格式化
        LocalDateTime date = LocalDateTime.parse("2019-07-28 16:21:05", formatter);
        System.out.println(date);
    }
}
