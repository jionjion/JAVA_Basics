package flows.condition;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 场景: 通过 Condition 实现 生产 - 消费 模式
 *
 * @author Jion
 */
public class ConditionDemo2 {

    /**
     * 队列大小
     */
    private int queueSize = 10;

    /**
     * 队列
     */
    private PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);

    /**
     * 锁
     */
    private Lock lock = new ReentrantLock();

    /**
     * 条件, 当前队列未慢
     */
    private Condition notFull = lock.newCondition();

    /**
     * 条件, 当前队列未空
     */
    private Condition notEmpty = lock.newCondition();

    /**
     * 消费者
     */
    class Consumer extends Thread {

        @Override
        public void run() {
            consumer();
        }

        /**
         * 消费方法, 一直执行
         */
        private void consumer() {
            while (true) {
                lock.lock();

                try {
                    while (queue.size() == 0) {
                        System.out.println("队列为空, 等待数据进入...");

                        // 当前队列为空, 线程等待
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // 弹出线程消费
                    queue.poll();

                    // 能弹出消费, 说明队列中还有东西, 唤醒
                    notFull.signalAll();
                    System.out.println("从队列中取出数据, 剩余元素" + queue.size());
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    /**
     * 生成着
     */
    class Producer extends Thread {

        @Override
        public void run() {
            producer();
        }

        /**
         * 消费方法, 一直执行
         */
        private void producer() {
            while (true) {
                lock.lock();

                try {
                    while (queue.size() == queueSize) {
                        System.out.println("队列满了, 等待空余...");

                        // 当前队列为空, 线程等待
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // 放入队列中插入元素
                    queue.offer(1);

                    // 能弹出消费, 说明队列中还有东西, 唤醒
                    notEmpty.signalAll();
                    System.out.println("向队列中插入数据, 剩余空间" + (queueSize - queue.size()));
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    public static void main(String[] args) {
        ConditionDemo2 demo = new ConditionDemo2();
        Producer predicate = demo.new Producer();
        Consumer consumer = demo.new Consumer();

        predicate.start();
        consumer.start();
    }
}
