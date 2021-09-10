package com.model.proxy.statical;
/**	静态代理
 * 	通过聚合的方式实现相同的接口,完成继承.*/
public class CarBrother implements Movable{

	/**传入接口的实现类,进行调用*/
	private Car car;
	public CarBrother(Car car) {
		super();
		this.car = car;
	}
	
	@Override
	/**将传入的父类对象进行调用相同的方法,并增加相关功能*/
	public void move() {
		long startTime = System.currentTimeMillis();
		car.move();
		long endTime = System.currentTimeMillis();
		System.out.println("汽车行驶时间"+(endTime-startTime)+"毫秒");
	}

	
}
