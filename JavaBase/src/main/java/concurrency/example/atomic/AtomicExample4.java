package concurrency.example.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 	AtomicReference示例
 * 	AtomicStampedReference 与之一致,只不过在对象每次更新时,增加了内部版本号,解决了ABA问题
 */
public class AtomicExample4 {

	//AtomicReference类创建一个数字
	private static AtomicReference<Integer> count = new AtomicReference<Integer>(0);
	
	public static void main(String[] args) {
		//如果count=0,则更新为1,否则不执行
		count.compareAndSet(0, 1);
		count.compareAndSet(0, 2);
		count.compareAndSet(1, 3);
		count.compareAndSet(2, 4);
		System.out.println("期望数字:" + count.get());
		
	}
}
