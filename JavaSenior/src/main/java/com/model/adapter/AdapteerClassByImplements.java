package com.model.adapter;
/**	
 * 	通过接口实现
 * 	适配器的类,将特有的类转为可以被使用的类
 * 	实现需要转化的目标类的需求接口*/
public class AdapteerClassByImplements implements TargetInterface {

	/*创建转换前的目标类*/
	private AdapteeClass adaptee;
	
	/*创建构造方法*/
	public AdapteerClassByImplements (AdapteeClass adaptee) {
		this.adaptee = adaptee;
	}
	
	
	@Override
	public void targetWay() {
		System.out.println("通过接口适配器调用......");
		adaptee.AdapteeWay(); 		//转化前目标类的方法,在适配器中进行调用
	}

}
