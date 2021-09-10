package com.model.singleton;
/**	单例模式,饿汉方法
 * 	随类加载时而加载,比较慢,线程安全*/
public class SingletonByHungryMan {

	//1.私有构造方法,拒绝外部直接创建对象
	private SingletonByHungryMan(){}
	
	//2.创建类实例,唯一			private static
	private static SingletonByHungryMan instance = new SingletonByHungryMan();
	
	//3.提供一个静态类的外部方法	public static
	public static synchronized SingletonByHungryMan getInstance() {
		return instance;
	}
}
