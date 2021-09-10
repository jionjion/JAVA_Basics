package java8.methodRef;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Jion
 *      构造器引用
 */
public class ConstructorRefTest {

    /** 无参构造器方法引用 */
    @Test
    public void testA(){
        // 供给型接口, 返回一个实例
        Supplier<String> supplier1 = () -> new String();

        // 构造器引用
        Supplier<String> supplier2 = String::new;
    }

    /** 有参数的构造器方法引用 */
    @Test
    public void testB(){
        // 有参数的
        Function<String, String> supplier1B = (x) -> new String(x);

        // 构造器引用
        Function<String, String> supplier2B = String::new;
    }

}
