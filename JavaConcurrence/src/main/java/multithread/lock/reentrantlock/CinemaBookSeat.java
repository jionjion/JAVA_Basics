package multithread.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用  ReentrantLock 类去锁定资源. 然后约定时间内, 只能有一个线程完成操作...
 * 代码演示预定电影票类
 *
 * @author Jion
 */
public class CinemaBookSeat {

    private static ReentrantLock lock = new ReentrantLock();

    private static void bookSeat(){
        // 上锁
        lock.lock();
        try  {
            // 临界区内业务, 一次只能有一个线程完成预定座位
            System.out.println(Thread.currentThread().getName()  + "开始预定座位");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()  + "结束预定座位");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // 尝试每个线程去预定作为, 但是由于有锁的存在, 导致每次获取锁时只能有一个线程被抢到.. 一次只能有一个线程完成动作
        new Thread(CinemaBookSeat::bookSeat).start();
        new Thread(CinemaBookSeat::bookSeat).start();
        new Thread(CinemaBookSeat::bookSeat).start();
        new Thread(CinemaBookSeat::bookSeat).start();
    }
}
