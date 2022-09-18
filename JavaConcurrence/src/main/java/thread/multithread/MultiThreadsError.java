package thread.multithread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述: 模拟在多线程情况下, 同时操作一个类的属性进行自增造成线程安全性问题
 *
 * @author Jion
 */
@SuppressWarnings("ALL")
public class MultiThreadsError implements Runnable {

    /**
     * 静态变量, 多个线程情况下对相同对象进行操作会有线程安全问题
     */
    static MultiThreadsError instance = new MultiThreadsError();

    /**
     * 进行自加的值, 多线程情况
     */
    int index = 0;

    /**
     * 总共的自增次数, 院子类保证计数准确
     */
    static AtomicInteger realIndex = new AtomicInteger();

    /**
     * 错误的发生的次数, 原子类保证计数准确
     */
    static AtomicInteger wrongCount = new AtomicInteger();

    /**
     * 倒数门栓, 控制并发流程, 模拟多线程情况下, 对变量进行 index++ 操作
     */
    static CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
    static CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);

    /**
     * 数组, 标记每次计算的正确与否.. 计数大一点, 避免最后位数的时候多线程自增后数组越界
     */
    final boolean[] marked = new boolean[99999];

    public static void main(String[] args) throws InterruptedException {
        // 声明两个线程, 传入相同的任务对象, 修改相同成员的变量
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        // 统计
        System.out.println("表面上结果是" + instance.index);
        System.out.println("真正运行的次数" + realIndex.get());
        System.out.println("错误次数" + wrongCount.get());
    }

    @Override
    public void run() {
        // 循环, 进行自增操作..
        for (int i = 0; i < 10000; i++) {
            // 倒数门栓, 在自增前将两个线程拦截
            try {
                cyclicBarrier2.reset();
                cyclicBarrier1.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

            index++;

            // 倒数门栓, 在自增后将两个线程拦截
            try {
                cyclicBarrier1.reset();
                cyclicBarrier2.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

            // 总共的执行次数统计
            realIndex.incrementAndGet();

            // 通过 synchronized 锁定一个类或者类的静态属性, 将锁监视器写入到对象中, 并且保证改类的所有对象均会去争用这个锁, 进而多线程下只有一个线程执行该方法
            synchronized (instance) {
                // 判断失败的条件: 如果这个两个相邻的位数同时被修改为 true, 说明发生了在两个线程中 index++ 自增出现问题...
                if (marked[index] && marked[index - 1]) {
                    System.out.println("发生错误" + index);
                    wrongCount.incrementAndGet();
                }
                // 正常线程执行完自增后, 对应位数值为 true
                marked[index] = true;
            }
        }
    }
}