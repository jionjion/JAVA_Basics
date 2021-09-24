package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 通过JDK动态生成代理对象
 *
 * @author Jion
 */
public class ProxyTeacherFactory {

    /**
     * 获得代理对象
     */
    public Object getProxyInstance(final Object target) {

        // 类加载器 ; 目标类的所有实现接口 ; 事件处理器
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理开始...");
                        Object result = method.invoke(target, args);
                        System.out.println("代理结束...");
                        return result;
                    }
                });
    }
}
