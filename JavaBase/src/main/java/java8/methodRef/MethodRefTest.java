package java8.methodRef;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author Jion
 */
public class MethodRefTest {


    /**
     *  方法引用,注意参数列表与返回值相同
     *      对象::实例方法名
     */
    @Test
    public void testA(){
        // 消费函数,打印
        Consumer<String> print1 = s -> System.out.println(s);
        print1.accept("AAA");

        // 方法引用,直接引用实例方法
        Consumer<String> print2 = System.out::println;
        print2.accept("BBB");
    }

    /**
     *  方法引用,注意参数列表与返回值相同
     *      类::静态方法名
     */
    public void testB(){
        // 比较大小,调用Integer的比较方法
        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);

        // 方法引用,直接引用静态方法
        Comparator<Integer> comparator2 = Integer::compare;
    }

    /**
     *  方法引用,参数列表中第一个参数是方法调用实例,第二个参数是实例方法参数
     *      类::实例方法名
     */
    @Test
    public void testC(){
        // 对多个参数进行断言,判断两个参数是否相同
        BiPredicate<String, String> predicate1 = (s1, s2) -> s1.equals(s2);
        boolean result1 = predicate1.test("A","B");
        System.out.println(result1);

        // 方法引用
        BiPredicate<String, String> predicate2 = String::equals;
        boolean result2 =predicate2.test("A","B");
        System.out.println(result2);
    }


}
