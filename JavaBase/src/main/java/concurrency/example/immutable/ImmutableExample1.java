package concurrency.example.immutable;
/**
 *	final关键字的使用
 *	修饰基本变量与引用变量
 */

import java.util.HashMap;
import java.util.Map;

public class ImmutableExample1 {

	private final static Integer i = 1;
	
	private final static String str = "Str";
	
	private final static Map<Integer, Integer> imap = new HashMap<>();

	//类初始化时,赋值map
	static {
		imap.put(1, 3);
		imap.put(2, 4);
	}
	
	private void test(final int i) {
		//i = 1;		//使用final修饰形参,参数不能发生修改 
	}
	
	/** 测试 */
	public static void main(String[] args) {
		//i = 2 ;		//基础数据能不修改
		Map<Integer, Integer> iimap = new HashMap<>();
		//imap = iimap; //引用数据能不修改指向
		imap.put(1, 5);	//但是可以修改引用对象内的属性
		System.out.println(imap.get(1)); 
	}
}
