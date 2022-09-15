package multithread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 场景: 演示 Future 接口在批量情况下的使用..
 *
 * @author Jion
 */
public class ListFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 一次执行两个任务
        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<Future> futureList = new ArrayList<Future>();

        // 向线程池中放任务...
        for (int i = 0; i < 20; i++) {
            Future<Integer> future = executor.submit(() -> {
                Thread.sleep(3000);
                return new Random().nextInt();
            });
            futureList.add(future);
        }

        // 循环获取结果,
        for (int i = 0; i < 20; i++) {
            Future<Integer> future = futureList.get(i);
            Integer integer = future.get();
            System.out.println("获取结果.. " + integer);
        }

        executor.shutdown();
    }

}
