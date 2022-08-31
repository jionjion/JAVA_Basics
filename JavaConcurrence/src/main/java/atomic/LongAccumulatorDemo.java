package atomic;

import sun.rmi.runtime.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * 演示: Accumulator 统计求和
 *
 * @author Jion
 */
public class LongAccumulatorDemo {

    public static void main(String[] args) {

        // x 是初始值, y 是下一个值, 函数里面是运算过程.. 初始值是0
        LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 0);
        // 执行, 0 +1 = 1
        accumulator.accumulate(1);
        // 执行, 1 +2 = 3
        accumulator.accumulate(2);
        System.out.println(accumulator);

        // 线程池
        ExecutorService executor =  Executors.newFixedThreadPool(10);

        accumulator.reset();
        IntStream.range(0, 10).forEach(i -> executor.submit(() -> accumulator.accumulate(i)));
        executor.shutdown();
        System.out.println(accumulator);
    }
}
