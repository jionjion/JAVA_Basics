package com.model.strategy.impl;

import com.model.strategy.FlyStrategy;

/**	该包为策略模式的各种实现类..
 * 	飞行的一个扩展类*/
public class FlyWithWin implements FlyStrategy {

	@Override
	/**使用翅膀进行飞行*/
	public void performFly() {
		System.out.println("使用翅膀进行飞行");
	}

}
