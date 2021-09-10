package com.model.strategy;

import com.model.strategy.impl.FlyWithWin;

/**	绿脖鸭子*/
public class MallardDuck extends Duck {

	public MallardDuck(){
		super();
		super.setFly(new FlyWithWin());		//在构造方法中,调用父类的方法,实现注入组成
	}
	
	@Override
	public void quack() {
		super.quack();
	}

	@Override
	public void display() {
		System.out.println("我是一只绿脖子的鸭子");
	}
	
	public void name() {
		
	}

}
