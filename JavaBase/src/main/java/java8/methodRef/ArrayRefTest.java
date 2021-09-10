package java8.methodRef;

import org.junit.Test;

import java.util.function.Function;

/**
 *  @author Jion
 *      数组引用
 */
public class ArrayRefTest {

    /** 数组引用 */
    @Test
    public void test(){
        // 创建数组,并指定长度
        Function<Integer, String[]> function1 = (x) -> new String[x];
        String[] len1 = function1.apply(10);
        System.out.println("长度: " + len1.length);

        // 数组引用
        Function<Integer, String[]> function2 = String[]::new;
        String[] len2 = function2.apply(10);
        System.out.println("长度: " + len2.length);
    }
}
