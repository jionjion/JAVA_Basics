package deadlock;

/**
 * 说明: 必定发生死锁的情况
 *
 * @author Jion
 */
public class MustDeadLockFix implements Runnable {
    
    
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    int flag = 1;

    public static void main(String[] args) {
        MustDeadLockFix dome1 = new MustDeadLockFix();
        MustDeadLockFix dome2 = new MustDeadLockFix();
        dome1.flag = 0;
        dome2.flag = 1;
        Thread thread1 = new Thread(dome1);
        Thread thread2 = new Thread(dome2);
        thread1.start();
        thread2.start();

    }

    @Override
    public void run() {
        System.out.println("flag" + flag);
        if (flag == 0) {
            synchronized(lock1){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized(lock2){
                    System.out.println("线程1拿到了两把锁!");
                }
            }
        }
        if(flag == 1) {
            synchronized(lock2){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized(lock1){
                    System.out.println("线程2拿到了两把锁!");
                }
            }
        }
    }
}
