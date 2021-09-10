package proxy.cglib;

import org.junit.Test;

/**
 * Cglib代理测试
 *
 * @author Jion
 */
public class ProxyTeacherFactoryTest {

    @Test
    public void test() {
        // 创建目标对象
        MathTeacher teacher = new MathTeacher();
        // 将代理对象传入,获得代理类
        MathTeacher proxyTeacher = (MathTeacher) new ProxyTeacherFactory(teacher).getInstance();
        // 执行代理对象的方法,触发拦截器
        proxyTeacher.tell();
    }
}