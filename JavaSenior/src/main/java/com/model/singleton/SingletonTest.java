package com.model.singleton;

import org.junit.Test;

/**单例模式测试*/
public class SingletonTest {

	/**单例模式-饿汉方法测试*/
	@Test
	public void One() {
		SingletonByHungryMan instance1 = SingletonByHungryMan.getInstance();
		SingletonByHungryMan instance2 = SingletonByHungryMan.getInstance();
		if (instance1 == instance2) {
			System.out.println("两者相同");
		}else{
			System.out.println("两者不同");
		}
	}
	
	/**单例模式-饱汉方法测试*/
	@Test
	public void Two() {
		SingletonByPlumpMan instance1 = SingletonByPlumpMan.getInstance();
		SingletonByPlumpMan instance2 = SingletonByPlumpMan.getInstance();
		if (instance1 == instance2) {
			System.out.println("两者相同");
		}else{
			System.out.println("两者不同");
		}
	}
}
