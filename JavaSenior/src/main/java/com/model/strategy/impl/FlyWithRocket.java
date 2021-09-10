package com.model.strategy.impl;

import com.model.strategy.FlyStrategy;
/**新产品,太空鸭子*/
public class FlyWithRocket implements FlyStrategy{

	@Override
	public void performFly() {
		System.out.println("我用火箭进行飞行....");
	}
	
}
