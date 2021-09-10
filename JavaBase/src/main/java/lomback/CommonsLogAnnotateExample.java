package lomback;

import lombok.extern.apachecommons.CommonsLog;
import org.junit.Test;

import java.util.logging.Level;

/**
 * @author Jion
 *  \@CommonsLog 组件
 *  org.apache.commons.logging.Log
 */
@CommonsLog
public class CommonsLogAnnotateExample {

    @Test
    public void testLog(){
    /*
        trace > debug > info > warn > error > fatal
    */
        log.trace("trace 级别");
        log.debug("debug 级别");
        log.info("info   级别");
        log.warn("warn   级别");
        log.error("error 级别");
        log.fatal("fatal 级别");
    }
}
