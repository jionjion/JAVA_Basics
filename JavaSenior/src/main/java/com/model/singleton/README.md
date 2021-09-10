# JAVA设计模式-单例模式

Tags : JDK8 Eclipse

---

[TOC]

---

## 简介
单例模式可以实现对象的唯一,重复利用一些耗费资源较大的对象.这里介绍单例的两种实现方式,*饿汉模式*和*懒汉模式*.

## 文件列表
- `SingletonByHungryMan`饿汉模式
- `SingletonByPlumpMan`懒汉模式
- `SingletonTest`测试类

## 实现方式
### 饿汉模式

- 私有构造方法
- 创建唯一实例
- 提供静态方法`get()`,并添加同步锁

``` java
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
```

### 懒汉模式

- 私有构造函数
- 创建实例引用
- 提供`get()`,创建实例.
- 根据实例对象是否存在,确定最后是否实例化对象


``` java
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
```


