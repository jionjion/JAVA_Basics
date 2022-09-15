package multithread.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 演示: AtomicIntegerFieldUpdater 对类的属性进行升级操作, 对属性进行原子化操作, 将普通变量, 升级为原子变量. 通过操作升级后的原子变量, 实现线程安全
 * 业务: 对 Candidate 类中的 score 基本类型属性进行操作, 一个升级为原子属性, 另一个不变, 自增验证线程安全..
 *
 * @author Jion
 */
public class AtomicIntegerFieldUpdaterDemo implements Runnable {

    /**
     * 候选人类
     */
    static class Candidate {
        /**
         * 候选人分数
         */
        volatile int score;
    }

    /**
     * 静态变量, 候选人 tom
     */
    static Candidate tom = new Candidate();

    /**
     * 静态变量, 候选人 peter
     */
    static Candidate peter = new Candidate();

    /**
     * 原子升级引用, 指定需要升级的类和属性
     */
    public static AtomicIntegerFieldUpdater<Candidate> scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");


    /**
     * 定义多线程操作, 对升级后的原子属性进行操作
     */
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            // 正常的基本类型操纵
            tom.score++;
            //原子操作
            scoreUpdater.getAndIncrement(peter);
        }
    }


    public static void main(String[] args) throws InterruptedException {

        AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();
        // 创建线程, 传入多线程任务. 竞争操作
        Thread thread1 = new Thread(demo);
        Thread thread2 = new Thread(demo);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("未升级的基本变量" + tom.score);
        System.out.println("升级后的基本变量" + peter.score);
    }
}


