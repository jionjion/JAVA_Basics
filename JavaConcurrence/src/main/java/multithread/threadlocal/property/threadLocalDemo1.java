package multithread.threadlocal.property;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 两个线程打印日期
 *
 * @author Jion
 */
public class threadLocalDemo1 {

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
        // 使用线程处理
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(dateFormat(10));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(dateFormat(10470));
            }
        }).start();
    }
}