package concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch的测试类
 * 设定线程数与计数器数量,完成对多线程次数的调用
 *
 * @author Jion
 */
@Slf4j
public class CountDownLatchExample1 {

    //计数数量
    private static int threadCount = 200;

    public static void main(String[] args) throws Exception {

        //线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //构建计数器,计数数量为200
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        //循环启动线程池
        for (int i = 0; i < threadCount; i++) {
            //final修饰的变量可以传入线程中
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    //执行测试方法
                    test(threadNum);
                } catch (Exception e) {
                    log.error("错误:{}", e);
                } finally {
                    //执行结束,当前计数器-1
                    countDownLatch.countDown();
                }
            });
        }

        //等待,直到计数器中计数归零
        countDownLatch.await();
        log.info("线程结束");
        //线程池关闭
        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        log.info("线程{}", threadNum);
    }
}
