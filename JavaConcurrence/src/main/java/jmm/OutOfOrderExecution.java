package jmm;

import java.util.concurrent.CountDownLatch;

/**
 * 说明: 演示指令重排序现象
 *
 * @author Jion
 */
@SuppressWarnings("ALL")
public class OutOfOrderExecution {

    private static int x = 0, y = 0;

    private static int a = 0, b = 0;


    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true) {
            i ++;
            CountDownLatch latch = new CountDownLatch(1);

            Thread thread1 = new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                a = 1;
                x = b;
            });

            Thread thread2 = new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                b = 1;
                y = a;
            });

            thread1.start();
            thread2.start();
            // 同时执行
            latch.countDown();
            thread1.join();
            thread2.join();

            /*
             * 多个线程中, 静态变量的赋值可能各不相同..
             * 可能, 线程1 先执行, 线程2 后执行;
             * 或者, 线程1 后执行, 线程2 先执行;
             * 或者, 线程1 执行赋值后暂停; 线程2 执行赋值后暂停; 最后再分别执行传值,
             */
            System.out.println("第" + i + "次运行, " + "x: " + x + ", y: " + y);
            if (x == 0 && y == 0){
                break;
            }
        }
    }

}
