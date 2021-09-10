package com.model.proxy.dynamical;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**通过JDK实现动态代理*/
public class TimeHadler implements InvocationHandler{

	/**被代理对象*/
	private Object target;
	
	/**通过构造器实现被代理对象的注入*/
	public TimeHadler(Object target) {
		super();
		this.target = target;
	}

	@Override
	/**	动态代理方法
	 * 	最终被代理对象,被代理对象的方法,方法参数
	 * 	返回值为方法的方法值*/
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		//传入被代理对象,无参方法
		method.invoke(target);
		long endTime = System.currentTimeMillis();
		System.out.println("汽车行驶时间"+(endTime-startTime)+"毫秒");
		//本方法没有返回值
		return null;
	}

	
}
