package com.model.proxy.statical;

import java.util.Random;

/**接口实现汽车类*/
public class Car implements Movable {

	@Override
	public void move() {
		try {
			System.out.println("汽车行驶中......");
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.err.println("睡眠中出现异常");
		}
	}
}
