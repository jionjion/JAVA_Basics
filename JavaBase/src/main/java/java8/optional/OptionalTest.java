package java8.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author Jion
 */
public class OptionalTest {


    /**
     *      Optional.of(T value)    创建一个实例
     */
    @Test
    public void testOf() {
        Optional<String> jion = Optional.of("Jion");
        System.out.println(jion);
    }

    /**
     *      Optional.empty()        创建一个空实例
     */
    @Test
    public void testEmpty(){
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
    }

    /**
     *  Optional.ofNullable(T value)    不为空时,创建实例;为空时,创建空实例
     */
    @Test
    public void testOfNullable(){
        Optional<String> optional = Optional.ofNullable(null);
        System.out.println(optional);
    }

    /**
     *  get 获得返回值
     */
    @Test
    public void testGet(){
        Optional<String> jion = Optional.of("Jion");
        System.out.println(jion.get());
    }

    /**
     *      isPresent()             判断是否包含值
     */
    @Test
    public void testIsPresent(){
        Optional<String> jion = Optional.of("Jion");
        System.out.println(jion.isPresent());
    }

    /**
     *      orElse(T other)         获得返回值,如果返回值不存在,则返回默认值T
     */
    @Test
    public void testOrElse(){
        // 空串也为对象
        Optional<String> optional = Optional.of("");
        String result = optional.orElse("Arise");
        System.out.println(result);
    }

    /**
     *      orElseGet(Supplier other) 获得返回值,如果返回值不存在,则调用Supplier接口,生成一个符合要求的
     */
    @Test
    public void testOrElseGet(){
        Optional<String> optional = Optional.empty();
        String result = optional.orElseGet(() -> "Arise");
        System.out.println(result);
    }

    /**
     *      map(Function mapper)    如果有值,则进行函数式计算,并返回其计算结果的Optional包装;如果为空,则直接返回空包装
     *      flatMap(Function mapper)同上
     */
    @Test
    public void testMap(){
        Optional<String> optional = Optional.of("ABCDEF");
        // Function<T,R> 接口
        Optional<String> result = optional.map(s -> {
            return s.toLowerCase();
        });
        // 将包装内对象全部小写
        System.out.println(result.toString());
    }
}
