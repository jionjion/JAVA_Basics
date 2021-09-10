package java8.steam;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  @author Jion
 *      Steam操作
 *
 */
public class OperateSteamIITest {

    // @TODO   改为收集操作

    /**
     *  reduce      规约
     *              将所有求和,获得一个结果
     */
    @Test
    public void testReduce(){
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5);
        // 1 + 2 + 3 + 4 + 5
        Integer result = integerStream.reduce(0, Integer::sum);
        System.out.println("求和得: " + result);
    }

    /**
     *  collect         收集,将符合要求的成员
     *
     *  Collectors      工具类,提供多种收集器
     */
    @Test
    public void testCollect(){
        Stream<String> stringStream = Stream.of("Jion", "Arise", "Bro", "Si", "Jion");
        // 收集, toList()返回一个列表   toMap()返回一个字典   toSet()返回一个集合
        List<String> list = stringStream.collect(Collectors.toList());
        System.out.println("收集结果: " + list);

        Stream<String> stringStream2 = Stream.of("Jion", "Arise", "Bro", "Si", "Jion");
        // 收集, 返回一个自定义数据结构
        List<String> list2 = stringStream2.collect(Collectors.toCollection(ArrayList::new));
        System.out.println("收集结果: " + list2);
    }

    /** 测试收集计算 */
    @Test
    public void testCollect2(){
        // 求和
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5);
        int result = integerStream.mapToInt(value -> value).sum();
        System.out.println("求和得: " + result);

        // 均值
        Stream<Integer> integerStream2 = Stream.of(1,2,3,4,5);
        Double result2 = integerStream2.collect(Collectors.averagingDouble(value -> value));
        System.out.println("均值得: " + result2);

        // 最大值
        Stream<Integer> integerStream3 = Stream.of(1,2,3,4,5);
        Optional<Integer> result3 = integerStream3.max(Integer::compare);
        System.out.println("最大值: " + result3.get());

        // 最小值
        Stream<Integer> integerStream4 = Stream.of(1,2,3,4,5);
        Optional<Integer> result4 = integerStream4.min(Integer::compare);
        System.out.println("最小值: " + result4.get());

        // 分组
//        Stream<Integer> integerStream5 = Stream.of(1,2,3,4,5);
//        Optional<Integer> result5 = integerStream5.collect(Collectors.groupingBy(o -> o.getValue))
//        System.out.println("最小值: " + result5.get());

        // 多级分组

        // 分区,根据条件分为 true 和 false两组

        // 连接字符串

    }


}
