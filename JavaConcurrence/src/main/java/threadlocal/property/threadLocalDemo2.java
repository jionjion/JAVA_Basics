package threadlocal.property;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池打印日期
 * 线程池比线程更加快速,性能要更好
 *
 * @author Jion
 */
public class threadLocalDemo2 {

    /**
     * 将当前时间戳转为日期格式化
     *
     * @param second 秒
     * @return 时间
     */
    public static String dateFormat(int second) {
        Date date = new Date(second * 1000L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

    }
}