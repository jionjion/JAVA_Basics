package threadlocal.property;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池打印日期,并把日期格式化类储存为静态变量.
 * 在线程池中,10个核心工作线程公用同一个静态变量,调用时会有线程安全问题
 * 通过加锁解决
 *
 * @author Jion
 */
public class threadLocalDemo4 {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 将当前时间戳转为日期格式化
     *
     * @param second 秒
     * @return 时间
     */
    public static String dateFormat(int second) {
        Date date = new Date(second * 1000L);
        // 静态变量
        String format;
        // 通过对静态变量的调用, 避免多线程间调用安全...但是 synchronized 是一个类锁, 会将所有执行到这个方法的线程进行排队等待, 降低并发效率
        synchronized (threadLocalDemo4.class) {
            format = simpleDateFormat.format(date);
        }
        return format;
    }

    public static void main(String[] args) {

        // 使用线程池执行
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    // 每十秒
                    System.out.println(dateFormat(finalI * 10));
                }
            });

        }

        executorService.shutdown();
    }
}