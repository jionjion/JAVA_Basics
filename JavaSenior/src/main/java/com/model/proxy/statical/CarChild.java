package com.model.proxy.statical;
/**	静态代理:
 * 	通过继承实现父类的方法,在覆盖的同时,增加新功能*/
public class CarChild extends Car{

	
	@Override
	/**通过继承,实现方法*/
	public void move() {
		long startTime = System.currentTimeMillis();
		super.move();
		long endTime = System.currentTimeMillis();
		System.out.println("汽车行驶时间"+(endTime-startTime)+"毫秒");
	}
}
