package lomback;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Jion
 *  \@Flogger 组件
 *  org.slf4j.Logger
 */
@Slf4j
public class Slf4jAnnotateExample {

    @Test
    public void testLog(){
        /* trace < debug < info < warn < error */
        log.trace("trace 级别");
        log.debug("debug 级别");
        log.info("info   级别");
        log.warn("warn   级别");
        log.error("error 级别");
    }
}
