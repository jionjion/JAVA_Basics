package com.model.proxy.dynamical.proxy;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

	private Object targer;	//被代理类对象
	//通过构造器完成传入
	public TimeHandler(Object targer) {
		super();
		this.targer = targer;
	}

	@Override
	public void invoke(Object object, Method method) {
		//调用方法的执行,传入类进行反射
		try {
			long startTime = System.currentTimeMillis();
			method.invoke(targer);
			long endTime = System.currentTimeMillis();					
			System.out.println("汽车行驶时间"+(endTime-startTime)+"毫秒");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("反射调用业务层抽取时发生异常..");
		}
	}

}
