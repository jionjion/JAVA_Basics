package com.model.proxy.dynamical;


import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	
	private Enhancer enhancer = new Enhancer();
	public Object getProxy(Class<?> cls) {
		//设置准备创建子类的类
		enhancer.setSuperclass(cls);
		//创建子类
		enhancer.setCallback(this);
		//返回子类实例
		return enhancer.create();
	}
	
	@Override
	/**	拦截所有的方法
	 * 	object:目标类的实例
	 * 	method:目标方法的反射对象
	 * 	objects:方法的参数
	 * 	methodProxy:代理类的实例
	 */
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
	
		long startTime = System.currentTimeMillis();
		
		//代理类调用父类的方法,传入代理类和方法参数列表
		methodProxy.invokeSuper(object, args);
		
		//在调用方法外进行代理增加方法
		long endTime = System.currentTimeMillis();
		System.out.println("火车行驶时间"+(endTime-startTime)+"毫秒");
		return null;
	}

}
