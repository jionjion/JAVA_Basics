package com.model.strategy;

import com.model.strategy.impl.FlyWithRocket;

public class SpaceDuck extends Duck{

	public SpaceDuck () {
		super();
		super.setFly(new FlyWithRocket());			//调用组合对象
	}

	@Override
	public void display() {
		System.out.println("我是一只在太空的鸭子");
	}
	
	@Override
	public void quack() {
		System.out.println("通过无线电...嘎嘎嘎");
	}
}
