package multithread.cas;

/**
 * 模拟CAS操作
 *
 * @author Jion
 */
public class SimulatedCAS {

    private volatile int value;

    /**
     * 利用CAS原理, 控制并发安全
     *
     * @param expected 期望的值
     * @param newValue 期望的值
     * @return 原内存的值
     */
    public synchronized int compareAndSwap(int expected, int newValue) {
        int oldValue = value;
        if (oldValue == expected) {
            value = newValue;
        } else {
            System.err.println(Thread.currentThread().getName() + "交换失败");
        }
        return oldValue;
    }


    public static void main(String[] args) throws InterruptedException {
        SimulatedCAS cas = new SimulatedCAS();
        Runnable job = () -> cas.compareAndSwap(0, 1);
        Thread thread1 = new Thread(job);
        Thread thread2 = new Thread(job);
        thread1.start();
        thread2.start();
        thread1.join();
        thread1.join();

        System.out.println(cas.value);
    }
}
