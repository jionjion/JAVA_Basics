package lomback;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.logging.Level;

/**
 * @author Jion
 *  \@Log 组件
 *  java.util.logging.Logger
 */
@Log
public class LogAnnotateExample {

    @Test
    public void testLog(){
    /*
        SEVERE > WARNING > INFO > CONFIG > FINE > FINER > FINEST
        OFF 关闭所有日志
        ALL 启用所有日志
    */
        log.setLevel(Level.FINEST);
        log.info("你好");
    }
}
