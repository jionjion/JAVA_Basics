package com.jionjion.concurrency.example.publish;


/**
 * 	实例
 * 		使用枚举实现单例模式
 */
public class PublishExample7 {

	//私有构造函数
	private PublishExample7() {
		super();
	}
	
	//返回方法
	public static PublishExample7 getInstance() {
		return Singleton.INSTANCE.getInstance();
	}
	
	
	//定义枚举类
	private enum Singleton {
		//枚举元素
		INSTANCE;
		
		//实例对象
		private PublishExample7 example7;
		
		//枚举构造方法,初始化对象 , JVM保证该方法只调用一次
		Singleton() {
			example7 = new PublishExample7();
		}
		
		//提供枚举对象获得方法,该方法并不区分调用的具体枚举元素
		public PublishExample7 getInstance() {
			return example7;
		}
	}
}
