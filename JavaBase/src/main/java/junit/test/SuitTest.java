package junit.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 	测试套件的使用,完成对多个测试类内的多个测试方法完成测试
 * 	写一个空类,作为入口类.
 * 	@RunWith: Suite.class
 * 	@SuiteClasses: 传入各种测试类
 * */

@RunWith(Suite.class)			//套件运行专用类
@SuiteClasses({ComputeTest.class,Junitlifecycle.class})		//多个运行的测试类...
public class SuitTest {

}
