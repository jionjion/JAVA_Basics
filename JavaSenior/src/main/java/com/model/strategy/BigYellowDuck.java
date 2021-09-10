package com.model.strategy;

import com.model.strategy.impl.FlyNoWay;

/**	大黄鸭.
 * 	因为贸然的接收继承Dcuk而忘记重写其中的某些方法,因而子类在调用时某些方法时,直接调用了父类的方法,出现了设计不缜密的问题*/
public class BigYellowDuck extends Duck{

	public BigYellowDuck() {
		super();								//调用父类的构造方法
		super.setFly(new FlyNoWay());			//组合方法
	}
	
	@Override
	public void display() {
		System.out.println("我是一只橡胶鸭子....");
	}
}
