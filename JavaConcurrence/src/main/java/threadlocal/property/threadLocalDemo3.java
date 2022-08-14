package threadlocal.property;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池打印日期,并把日期格式化类储存为静态变量.
 * 在线程池中,10个核心工作线程公用同一个静态变量,调用时会有线程安全问题
 *
 * @author Jion
 */
public class threadLocalDemo3 {

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