package proxy.jdk;

import org.junit.Test;

/**
 * @author Jion
 */
public class ProxyTeacherFactoryTest {

    @Test
    public void test(){
        // 代理目标对象
        Teacher teacher = new MathTeacher();
        // 代理工厂
        ProxyTeacherFactory proxyTeacherFactory = new ProxyTeacherFactory();
        // 代理对象
        Teacher proxyInstance = (Teacher) proxyTeacherFactory.getProxyInstance(teacher);
        // 调用代理类方法
        proxyInstance.tell();
        // 内存中代理类, 以 $开头
        System.out.println("代理对象: " + proxyInstance.getClass());
    }
}