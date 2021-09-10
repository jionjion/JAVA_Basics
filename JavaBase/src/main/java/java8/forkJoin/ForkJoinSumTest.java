package java8.forkJoin;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author Jion
 */
public class ForkJoinSumTest {


    /** 测试 Fork-Join模式计算 */
    @Test
    public void test(){
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSum(1L, 100000000L);
        Long sum = pool.invoke(task);
        System.out.println("执行结果:" + sum);
    }


    /**
     *  测试并行流计算
     *      通过 parallel() 方法切换并行流与串行流
     */
    @Test
    public void test2(){
        long result = LongStream.rangeClosed(1L, 100000000L)
                .parallel()
                .reduce(0, Long::sum);
        System.out.println("执行结果" + result);
    }
}
