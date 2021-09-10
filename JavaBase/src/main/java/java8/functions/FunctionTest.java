package java8.functions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author Jion
 *      函数型接口
 *          有参数,有返回值
 */
public class FunctionTest {


    private List<String> lowerStrs = Arrays.asList("a","b","c","d");

    /**
     *  R apply(T t);
     *      字符串列表转为大写
     */
    private Function<List<String>, List<String>> convertToUpperCase = (strs)->{
        List<String> result = new ArrayList<>();
        for (String s : strs){
            result.add(s.toUpperCase());
        }
        return result;
    };

    /**
     *  测试 R apply(T t);
     *      字符串列表转为大写
     */
    @Test
    public void testConvertToUpperCase(){
        // 调用方法
        List<String> result = convertToUpperCase.apply(lowerStrs);
        System.out.println("获得大写列表: " + result);
    }


    /**
     *  获得字符串对应的哈希码
     *      R apply(T t);
     */
    private Function<List<String>, List<Integer>> convertToHashCode = strs -> {
        List<Integer> result = new ArrayList<>();
        for(String s : strs){
            result.add(s.hashCode());
        }
        return result;
    };

    /**
     *  测试
     *      R apply(T t);
     *      获得字符列表的hashcode
     */
    @Test
    public void testConvertToHashCode(){
        List<Integer> result = convertToHashCode.apply(lowerStrs);
        System.out.println("获得哈希码: " + result);
    }

    /**
     *  测试
     *      <V> Function<T, V> andThen(Function<? super R, ? extends V> after)
     *          在A函数执执行完成后,根据A函数执行返回结果,调用B函数
     *          首先转为大写,随后获得其哈希码
     */
    @Test
    public void testAndThen(){
        List<Integer> result = convertToUpperCase.andThen(convertToHashCode).apply(lowerStrs);
        System.out.println("获得大写列表的哈希码: " + result);
    }

    /**
     *  测试
     *       <V> Function<V, R> compose(Function<? super V, ? extends T> before)
     *       在A函数执行之前,首先调用B函数,并将B函数的返回结果作为A函数的参数调用
     *          首先转为大写,随后获得其哈希码
     */
    @Test
    public void testCompose(){
        List<Integer> result = convertToHashCode.compose(convertToUpperCase).apply(lowerStrs);
        System.out.println("获得大写列表的哈希码: " + result);
    }
}
