package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 创建代理类
 *
 * @author Jion
 */
public class ProxyTeacherFactory implements MethodInterceptor {

    /** 维护一个目标对象 */
    private final Object target;

    public ProxyTeacherFactory(Object target){
        this.target = target;
    }

    /** 返回代理对象 */
    public Object getInstance(){
        // 1. 创建工具类
        Enhancer enhancer = new Enhancer();

        // 2. 设置父类
        enhancer.setSuperclass(target.getClass());

        // 3. 设置回调函数
        enhancer.setCallback(this);

        // 4. 创建子类及代理
        return enhancer.create();
    }

    /**
     *  使用Cglib进行代理, 改方法中调用目标方法
     * @param obj 被代理对象
     * @param method 代理方法
     * @param args  代理方法参数
     * @param methodProxy 调用方法返回结果
     * @return 调用方法返回结果
     * @throws Throwable 各种异常
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理开始...");
        // 代理方法反射调用,传入源目标类及方法参数
        Object result = method.invoke(target, args);
        System.out.println("代理结束...");
        return result;
    }
}
