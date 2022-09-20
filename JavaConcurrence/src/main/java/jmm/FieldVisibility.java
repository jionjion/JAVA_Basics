package jmm;

import java.util.concurrent.CountDownLatch;

/**
 * 说明: 演示内存可见性
 *
 * @author Jion
 */
public class FieldVisibility {

     int a = 1;
     int b = 2;

    /**
     * 不同线程修改变相同量
     */
    private void change() {
        a = 3;
        b = a;
    }

    /**
     * 打印验证线程变量是否相同
     */
    private void print() {
        System.out.println("a: " + a + " , b: " + b);
    }

    public static void main(String[] args) throws InterruptedException {

        FieldVisibility demo = new FieldVisibility();

        // 循环1万次, 验证多线程情况下修改相同变量会有不同
        while (true) {
            CountDownLatch latch = new CountDownLatch(1);

            // 线程1 修改值
            Thread thread1 =  new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                demo.change();
            });

            // 线程2 打印
            Thread thread2  =      new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                demo.print();
            });

            thread1.start();
            thread2.start();

            latch.countDown();
            thread1.join();
            thread2.join();
        }
    }
}
