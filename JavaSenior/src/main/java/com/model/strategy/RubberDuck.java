package com.model.strategy;

import com.model.strategy.impl.FlyNoWay;

/**	新产品,橡胶鸭,不会飞行*/
public class RubberDuck extends Duck {

	
	public RubberDuck() {
		super();								//调用父类的构造方法
		super.setFly(new FlyNoWay());			//组合方法
	}
	
	@Override
	public void display() {
		System.out.println("我是一只橡胶鸭子....");
	}

	@Override
	public void quack() {
		System.out.println("嘎叽...嘎叽...嘎叽...");
	}
}
