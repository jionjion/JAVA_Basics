package com.model.proxy.statical;
/**客户端*/
public class Client {

	/*测试*/
	public static void main(String[] args) {
		/*通过继承的方式实现静态代理*/
		CarChild carChild = new CarChild();
		carChild.move();
		
		/*通过聚合的方式,实现静态代理*/
		Car car = new Car();
		CarBrother carBrother = new CarBrother(car);
		carBrother.move();
	}
}
