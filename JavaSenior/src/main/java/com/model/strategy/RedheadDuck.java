package com.model.strategy;

import com.model.strategy.impl.FlyWithWin;

/**	红头鸭*/
public class RedheadDuck extends Duck {

	
	
	@Override
	public void quack() {
		super.quack();
		super.setFly(new FlyWithWin());		//在构造方法中,调用父类的方法,实现注入组成
	}

	@Override
	public void display() {
		System.out.println("我是红头的鸭子");
	}

}
