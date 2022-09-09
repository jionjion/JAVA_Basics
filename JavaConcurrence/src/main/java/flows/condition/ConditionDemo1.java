package flows.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 场景: 演示 Condition 接口的作用
 * 业务: A方法线程条件不满足, B方法唤醒线程A继续执行..
 *
 * @author Jion
 */
public class ConditionDemo1 {

    /**
     * 可重入锁
     */
    private ReentrantLock lock = new ReentrantLock();

    /**
     * 条件解锁
     */
    private Condition condition = lock.newCondition();


    void methodA() throws InterruptedException {
        lock.lock();

        try {
            // 条件加锁
            System.out.println("条件不满足, 线程等待");
            // 等待之前, 必须先获得锁..
            condition.await();
            System.out.println("条件满足, 开始执行后续任务");
        } finally {
            lock.unlock();
        }
    }


    void methodB() {
        lock.lock();

        try {
            // 准备..
            System.out.println("准备工作完成, 唤醒其他线程");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo1 demo = new ConditionDemo1();
        new Thread(() -> {
            // 在子线程中, 唤醒线程...
            demo.methodB();
        }).start();
        // 沉睡线程
        demo.methodA();
    }
}
