package com.model.adapter;
/**
 *	通过继承实现适配器
 */
public class AdapteerClassByExtends extends AdapteeClass implements TargetInterface {

	@Override
	public void targetWay() {
		System.out.println("通过继承适配器调用....");
		this.AdapteeWay();  	//调用继承中的方法
	}
	

}
