package com.model.proxy.dynamical;

import java.util.Random;

/**	CGLIB实现动态代理
 * 	定义一个类,不是通过接口实现方法,而是直接定义.*/
public class Train {

	public void move() {
		try {
			System.out.println("火车行驶中......");
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.err.println("睡眠中出现异常");
		}
	}
	
}
