package multithread.immutable;

/**
 * 演示: 栈封闭技术, 避免争抢修改相同变量
 *
 * @author Jion
 */
public class StackConfinement implements Runnable {

    int index = 0;

    public void inThread() {
        int localIndex = 0;
        for (int i = 0; i < 10000; i++) {
            localIndex++;
        }
        System.out.println("栈内变量: " + localIndex);
    }

    @Override
    public void run() {
        // 线程不安全的, 多个线程执行 run 时, 会修改相同变量
        for (int i = 0; i < 10000; i++) {
            index++;
        }

        // 方法内, 变量栈封闭
        inThread();
    }

    public static void main(String[] args) throws InterruptedException {
        // 多个线程同时执行方法, 访问修改同一个类实例 demo 的属性 index , 会有线程安全问题...
        StackConfinement demo = new StackConfinement();
        Thread thread1 = new Thread(demo);
        Thread thread2 = new Thread(demo);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("栈外变量: " + demo.index);
    }

    /**
     * final 修饰关键字的引用地址, 是常量池还是栈空间
     */
    public void problem() {
        String a = "wukong2";  // 常量, 常量池
        final String b = "wukong"; // 常量,final 修饰常量池
        String d = "wukong"; // 常量,常量池
        String c = b + 2;  // 编译时, 已经根据final修饰的字符串算过, 常量池
        String e = d + 2;   // 运行时, 堆上确定
        System.out.println((a == c)); // 常量池 == 常量池
        System.out.println((a == e)); // 常量池 != 堆空间
    }
}
