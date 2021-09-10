package com.model.singleton;
/**	单例模式,饱汉方法
 * 	在用户调用时创建实例,线程不安全*/
public class SingletonByPlumpMan {

	//1.私有构造方法,拒绝外部直接创建对象
	private SingletonByPlumpMan(){}
	
	//2.创建类实例,唯一			private static
	private static SingletonByPlumpMan instance ;
	
	//3.提供一个静态类的外部方法,锁住对象方法,仅在第一次调用创建时锁定	public static
	public static synchronized SingletonByPlumpMan getInstance() {
		if (instance == null) {
			instance = new SingletonByPlumpMan();
		}
		return instance;
	}
}
