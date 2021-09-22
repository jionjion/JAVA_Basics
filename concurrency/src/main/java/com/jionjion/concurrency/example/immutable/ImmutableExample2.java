package com.jionjion.concurrency.example.immutable;
/**
 *	Collections.unmodifiableXXX类
 *	内部通过重写方法,在调用修改方法时抛出异常来实现集合框架的不可修改
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableExample2 {

	private static Map<Integer, Integer> imap = new HashMap<>();

	//类初始化时,赋值map
	static {
		imap.put(1, 3);
		imap.put(2, 4);
		//将map修饰为不可变的类
		imap = Collections.unmodifiableMap(imap);
	}
	/** 测试 */
	public static void main(String[] args) {
		
		//修改被Collections.unmodifiable调用过的map内对象值,会抛出异常
		imap.put(1, 5);
		System.out.println(imap.get(1)); 
	}
}
