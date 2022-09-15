package multithread.collection.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 场景: ArrayBlockQueue 队列的使用
 * 业务: 模拟面试官面试
 *
 * @author Jion
 */
public class ArrayBlockQueueOptions {

    public static void main(String[] args) {
        // 初始化队列长度, 为3, 即每次队列中只能有三个在排队的
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        // 面试官, 生产者, 产生10个队列元素
        Interviewer interviewer = new Interviewer(queue);
        // 面试者, 消费者, 消费每个队列元素
        Consumer concurrent = new Consumer(queue);

        new Thread(concurrent).start();
        new Thread(interviewer).start();
    }
}

/**
 * 面试官, 消费者
 */
class Consumer implements Runnable {

    BlockingQueue<String> queue;

    Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            // 从队列中取出..并消费
            String candidate = queue.take();
            while (!candidate.equals("stop")) {
                System.out.println("面试者为: " + candidate);
                candidate = queue.take();
            }
            System.out.println("所有面试者完成面试...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


/**
 * 面试官, 生产者
 */
class Interviewer implements Runnable {

    BlockingQueue<String> queue;

    Interviewer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("当前候选人都来了...");
        for (int i = 0; i < 10; i++) {
            String candidate = "候选人" + i;
            try {
                queue.put(candidate);
                System.out.println("安排好了: " + candidate);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // 结束完成后, 放入队列结束信号
        try {
            System.out.println("所有人面试安排完毕...");
            queue.put("stop");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}