package java8.functions;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 *  @author Jion
 *      测试 Consumer<T> 消费型接口
 *          有参数, 无返回值
 */
public class ConsumerTest {

    private HashSet<String> lowerStrs = new HashSet<String>(){
        {
            add("a");
            add("b");
            add("d");
            add("e");
        }
    };

    /** 将字符串列表转为大写 */
    private Consumer<Set<String>> acceptStrListUpper = strs -> {
        // 迭代器修改
        for (String s : strs) {
            System.out.println("转为大写: " + s.toUpperCase());
        }
    };

    @Test
    public void testAcceptStrListUpper(){
        // 将小写转为大写
        acceptStrListUpper.accept(lowerStrs);
    }



    /** 获得字符串对应的哈希码 */
    private Consumer<Set<String>> acceptStrListHashCode = strs -> {
        for(String s : strs){
            System.out.println( s + " 的哈希码是: " + s.hashCode());
        }
    };

    @Test
    public void testHashCodeListStrs(){
        // 获得字符串列表的哈希码
        acceptStrListHashCode.accept(lowerStrs);
    }

    /** 多次调用消费,注意消费并不影响原有属性 */
    @Test
    public void testAndThen(){
        // 首先获得其哈希码, 再获得其大写表示
        acceptStrListHashCode.andThen(acceptStrListUpper).accept(lowerStrs);
    }

}
