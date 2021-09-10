package com.model.proxy.dynamical;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.model.proxy.statical.Car;
import com.model.proxy.statical.Movable;

/**客户端*/
public class Client {

	/*测试动态代理*/
	public static void main(String[] args) {
		Car car = new Car();
		//代理
		InvocationHandler handler = new TimeHadler(car);
		
		/**
		 * 	loader:类加载器
		 * 	interface:实现接口
		 * 	invocationHandler:自定义的代理器
		 * 	返回值:该接口的实现类*/
		Movable movable =(Movable)Proxy.newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(), handler);
		//测试方法
		movable.move();

		/*cglib的动态代理*/
		CglibProxy proxy = new CglibProxy();
		Train train =(Train) proxy.getProxy(Train.class);
		train.move();
		/**
		 * 	动态代理类的实现思路:
		 * 	1.生命一段源码,动态生成代理
		 * 	2.编译源码(JDK Compiler API),产生一个新的类(代理类)
		 * 	3.将这个类加载到内存中,产生一个新的对象(代理对象)
		 * 	4.返回代理对象
		 * 	*/
		
		
		
	}
}
