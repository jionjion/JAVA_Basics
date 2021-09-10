package junit.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.src.Compute;

/**单元测试时遇到的异常*/
public class JunitException {

	/**	使用单元测试,运行异常
	 * 	expected:捕获算数异常,并被忽略
	 * 	timeout:运行毫秒数,结束*/
	@Test(expected=ArithmeticException.class,timeout=100)
	public void testAdd() {
		//抛出一个零除异常
		assertEquals(1, new Compute().division (1, 0));
	}
}
