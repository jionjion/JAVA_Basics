package proxy.statics;

import org.junit.Test;

/**
 * 代理类测试
 *
 * @author Jion
 */
public class ProxyTeacherTest {

    @Test
    public void test() {
        ProxyTeacher proxy = new ProxyTeacher();
        proxy.tell();
    }
}