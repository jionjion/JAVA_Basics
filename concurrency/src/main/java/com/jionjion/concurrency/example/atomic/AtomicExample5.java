package com.jionjion.concurrency.example.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;


/**
 * 	AtomicIntegerFieldUpdater示例
 * 	实现原子性修改
 */
public class AtomicExample5 {

	//volatile修饰非static修饰的共享变量
	public volatile int count = 100;
	
	//AtomicIntegerFieldUpdater类实例化一个类
	private static AtomicIntegerFieldUpdater<AtomicExample5> updater = 
			//实例化的同步对象和共享字段
			AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");
	
	
	public static void main(String[] args) {
		//实例化共享对象
		AtomicExample5 example5 = new AtomicExample5();
		
		//如果对象字段为100,则更新为200
		if (updater.compareAndSet(example5, 100, 200)) {
			System.out.println("对象count字段,更新为" + example5.getCount());
		}else {
			System.out.println("对象count字段,更新失败,当前值为" + example5.getCount());
		}
	}

	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
