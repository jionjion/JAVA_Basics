package java8.time;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 *  @author Jion
 *      Instant 时间戳
 */
public class InstantTest {

    /** 当前时间,默认是UTC时区的 */
    @Test
    public void testNow(){
        Instant instant = Instant.now();
        System.out.println(instant);

        // 修正时区
        OffsetDateTime time = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(time);
    }

    @Test
    public void testToEpochMilli(){
        Instant instant = Instant.now();
        long milli = instant.toEpochMilli();
        System.out.println("当前时间戳: " + milli);
    }
}
