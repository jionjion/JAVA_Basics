package multithread.threadlocal.property;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池打印日期,并把日期格式化类储存为静态变量.
 * 在线程池中,10个核心工作线程公用同一个静态变量,调用时会有线程安全问题
 * 通过对10个核心工作线程通过 TheadLocal 添加线程安全变量
 *
 * @author Jion
 */
public class threadLocalDemo5 {

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
        // 通过 TheadLocal , 从当前线程中获取对应的 SimpleDateFormat , 避免线程安全
        SimpleDateFormat simpleDateFormat = ThreadSafeDateFormat.dateFormatThreadLocal.get();
        return simpleDateFormat.format(date);
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

/**
 * 线程安全的日期格式化工具
 */
class ThreadSafeDateFormat {

    /**
     * 线程安全的 SimpleDateFormat 对象
     */
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        // 初始化值
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
}