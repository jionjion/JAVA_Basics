package java8.steam;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Jion
 */
public class OperateStreamITest {


    private Stream<String> stream = null;


    @Before
    public void init(){
        stream = Stream.of("Jion", "Arise", "Bro", "Si", "Jion");
    }

    /*
        filter      过滤      接受lambda表达式,并删除某些
        limit(n)    限制      限制最大数量,前n个元素
        skip(n)     跳过      跳过前n个元素,若流中元素不足n个,则返回一个空流
        distinct    去重      通过hashCode()和equals()去除重复元素
        map         映射      将每一个元素通过某个方法进行转换
        flatMap     映射整流   将每个元素处理并返回的流整合为一个流
        sorted      排序      自然排序(Comparable),或者传入排序规则(Comparator)排序
        allMatch    全部匹配   检查是否全部匹配
        anyMatch    至少匹配   检查是否至少匹配一个
        noneMatch   没有匹配   检查是否没有匹配
        findFirst            查找第一个
        findAny              全部
        count                总个数
        max         最大值
        min         最小值

     */

    /**
     *  filter 过滤
     *      筛选长度为4的字符串
     */
    @Test
    public void testFilter(){
        // 过滤,筛选,Predicate<? super T> 断言接口
        stream.filter(s -> s.length()>=4 )
                // Consumer<? super T> 消费接口
                .forEach(System.out::println);
    }


    /**
     *  外部迭代
     *      通过迭代器,进行外部循环迭代
     */
    @Test
    public void testIterator(){
        Iterator<String> iterator = stream.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     *  limit   限制
     *      最多产生四条数据
     */
    @Test
    public void testLimit(){
        stream.limit(4).forEach(System.out::println);
    }

    /**
     *  skip    跳过
     *      跳过前两2个,取后面的
     */
    @Test
    public void testSkip(){
        stream.skip(2).forEach(System.out::println);
    }

    /**
     *  distinct    去重
     *      根据HashCode()和equals()方法进行去重
     */
    @Test
    public void testDistinct(){
        stream.distinct().forEach(System.out::println);
    }

    /**
     *  map         映射
     *      将当前流中的每一个元素均执行函数方法
     *      将字符串全部大写
     */
    @Test
    public void testMap(){
        // Function<? super T, ? extends R> 函数接口
        stream.map(String::toUpperCase).forEach(System.out::println);
    }

    /**
     *  flatMap
     *      将流中的每一个元素转为每一个新流,并将新流连接起来
     *      将流中的每一个单词拆分为字节,并返回一个流
     */
    @Test
    public void testFlatMap(){
        stream.flatMap(OperateStreamITest::apply).forEach(System.out::print);
    }
    /** 将每个字符串进行拆分,返回字节流 */
    private static Stream<Character> apply(String s) {
        List<Character> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            list.add(c);
        }
        return list.stream();
    }

    /**
     *  sorted  排序
     *      根据自然规则排序(Comparable),或者传入定制排序(Comparator)
     */
    @Test
    public void testSorted(){
        // 字典顺序
        stream.sorted().forEach(System.out::println);

        // 定制排序,根据字符串长度进行排序
        stream.sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
    }

    /**
     *  allMatch    是否全部匹配
     */
    @Test
    public void testAllMatch(){
        // Predicate<? super T> 断言
        boolean result = stream.allMatch(s -> s.startsWith("J"));
        System.out.println("是否全部以J开头: " + result);
    }

    /**
     *  anyMatch    是否至少匹配一个
     */
    @Test
    public void testAnyMatch(){
        // Predicate<? super T> 断言
        boolean result = stream.anyMatch(s -> s.startsWith("J"));
        System.out.println("是否至少存在一个以J开头: " + result);
    }

    /**
     *  noneMatch   全部都不匹配
     */
    @Test
    public void testNoneMatch(){
        // Predicate<? super T> 断言
        boolean result = stream.noneMatch(s -> s.startsWith("J"));
        System.out.println("是否都不存在以J开头: " + result);
    }

    /**
     *  findFirst   获取第一个
     */
    @Test
    public void testFindFirst(){
        Optional<String> first = stream.findFirst();
        System.out.println("获得第一个元素: " + first.get());
    }

    /**
     *  findAny     随便获取一个
     *      在串行流中,默认取第一个符合要求的
     *      在并行流中,根据某个线程执行结果获得
     */
    @Test
    public void testFindAny(){
        Optional<String> any = stream.findAny();
        System.out.println("随机获取一个素: " + any.get());
    }

    /**
     *  max         获得最大值
     *              获取最长字符串
     */
    @Test
    public void testMax(){
        Optional<String> max = stream.max(Comparator.comparingInt(String::length));
        System.out.println("获取最长的字符: " + max.get());
    }

    /**
     *  min         获得最小值
     *              获取最短字符串
     */
    @Test
    public void testMin(){
        Optional<String> min = stream.min(Comparator.comparingInt(String::length));
        System.out.println("获取最长的字符: " + min.get());
    }
}
