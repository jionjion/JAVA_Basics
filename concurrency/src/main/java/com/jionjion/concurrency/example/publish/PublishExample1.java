package com.jionjion.concurrency.example.publish;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * 	示例
 *	对象发布时,不同线程之间同时修改对象内部引用时
 *	造成数据不一致
 */
@Slf4j
public class PublishExample1 {

	private String[] states = {"a","b","c"};
	
	public String[] getStates() {
		return states;
	}
	
	/**
	 * 	测试,线程不安全的类
	 * 		在任意一个线程中,获取到对象内数组的引用后,均可改变数组的指向
	 */
	public static void main(String[] args) {
		PublishExample1 example1 = new PublishExample1();
		
		log.info("数组 {}",Arrays.toString(example1.getStates()));
		
		example1.getStates()[0] = "d";
		
		log.info("数组 {}",Arrays.toString(example1.getStates()));
	}
}
