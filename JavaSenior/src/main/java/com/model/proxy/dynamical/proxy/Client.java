package com.model.proxy.dynamical.proxy;

/**模拟自定义cglib*/
public class Client {

	public static void main(String[] args) throws Exception {
		Car car = new Car();
		InvocationHandler handler = new TimeHandler(car);
		Movable movable = (Movable) Proxy.newProxyInstance(Movable.class,handler);
		movable.move();
	}
}
