package com.jionjion.concurrency.example.lock;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 	JAVA中,锁机制
 * 	使用ReentrantReadWriteLock构建安全的读写容器
 * 	在执行写入之前,需要获取写锁,如果有读锁正在执行,需要等待直到读锁结束.如果持续等待,则会造成线程饥饿
 */
public class LockExample3 {

	
	/**
	 * 	内部类
	 */
	class Data{
		
	}
	

	//线程锁
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	//定义读锁和写锁
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();
	
	//维护内部的Map集合
	private final Map<String, Data> map = new TreeMap<>();

	//定义内部Map集合的方法
	public Data get(String key) {
		//使用读锁,获得容器类的值
		readLock.lock();
		try {
			return map.get(key);
		} finally {
			readLock.unlock();
		}
	}
	
	//获得
	public Set<String> getAllKeys() {
		readLock.lock();
		try {
			return map.keySet();
		} finally {
			readLock.unlock();
		}
	}
	
	public Data put(String key , Data value) {
		writeLock.lock();
		try {
			map.put(key, value);
		} finally {
			writeLock.unlock();
		}
		return null;
	}
	
	public static void main(String[] args) {
		
	}
}
