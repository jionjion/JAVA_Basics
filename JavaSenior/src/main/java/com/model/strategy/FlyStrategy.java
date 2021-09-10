package com.model.strategy;
/** 策略接口,让鸭子飞起来*/
public interface FlyStrategy {

	/**接口,定义飞行方式的接口,交由扩展类实现不同的方法*/
	void performFly();

}
