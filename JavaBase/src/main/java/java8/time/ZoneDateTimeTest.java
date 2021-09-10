package java8.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * @author Jion
 *      ZoneDateTime    带时区的日期时间格式
 */
public class ZoneDateTimeTest {

    /** 支持的所有时区列表 */
    @Test
    public void AllIds(){
        Set<String> ids = ZoneId.getAvailableZoneIds();
        ids.forEach(System.out::println);
    }

    /** 获得指定时区的是时间 */
    @Test
    public void testOfWithZone(){
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("上海时间: " + localDateTime);
    }

    /** 获得指定时区的时间 */
    @Test
    public void testAtZone(){
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println("上海时间: " + zonedDateTime);
    }
}

