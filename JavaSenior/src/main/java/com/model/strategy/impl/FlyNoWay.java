package com.model.strategy.impl;

import com.model.strategy.FlyStrategy;

/**不会飞行的能力*/
public class FlyNoWay implements FlyStrategy {

	@Override
	public void performFly() {
		System.out.println("不会飞行...");
	}

}
