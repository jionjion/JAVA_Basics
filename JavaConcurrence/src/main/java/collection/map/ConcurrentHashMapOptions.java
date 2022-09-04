package collection.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 场景: 线程安全的原子操作
 * 业务: 通过计算加和, 在并发场景下的集合框架的安全
 *
 * @author Jion
 */
public class ConcurrentHashMapOptions implements Runnable {

    static ConcurrentHashMap<String, Integer> scores = new ConcurrentHashMap<>();

    @Override
    public void run() {
        // 线程不安全的操作, 只能 put/get 值的时候的安全, 不能保证同时修改时的安全.....
        for (int i = 0; i < 100; i++) {
            Integer score = scores.get("小明");
            Integer newScore = score + 1;
            scores.put("小明", newScore);
        }

        // 除非加 代码块锁..
        for (int i = 0; i < 100; i++) {
            synchronized (ConcurrentHashMapOptions.scores) {
                Integer score = scores.get("小李");
                Integer newScore = score + 1;
                scores.put("小李", newScore);
            }
        }


        for (int i = 0; i < 100; i++) {
            while (true) {
                Integer score = scores.get("小王");
                Integer newScore = score + 1;
                // cas 组合操作, 当前值是否可以被修改为预期值..  类似还有 scores.putIfAbsent()
                boolean result = scores.replace("小王", score, newScore);
                //  除非修改成功, 否则继续循环
                if (result) {
                    break;
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        scores.put("小明", 0);
        scores.put("小李", 0);
        scores.put("小王", 0);


        Thread thread1 = new Thread(new ConcurrentHashMapOptions());
        Thread thread2 = new Thread(new ConcurrentHashMapOptions());

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("当前数值" + scores.get("小明"));
        System.out.println("当前数值" + scores.get("小李"));
        System.out.println("当前数值" + scores.get("小王"));

    }
}
