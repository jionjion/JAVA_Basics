package deadlock;

/**
 * 哲学家就餐问题, 有五个哲学家和五根筷子, 需要相互组合才可以吃饭
 *
 * @author Jion
 */
@SuppressWarnings("ALL")
public class DiningPhilosophers {


    public static void main(String[] args) {
        // 哲学家
        Philosopher[] philosophers = new Philosopher[5];
        // 筷子
        Object[] chopsticks = new Object[5];

        for (int i = 0; i < 5; i++) {
            chopsticks[i] = new Object();
        }
        for (int i = 0; i < 5; i++) {
            // 初始化左筷子
            Object leftChopstick = chopsticks[i];
            // 初始化右筷子, 数组长度+1 后对 5 取余, 这样超出后就会循环.
            Object rightChopstick = chopsticks[(i + 1) % 5];
            // 初始化哲学家
            philosophers[i] = new Philosopher(leftChopstick, rightChopstick);

            // 通过修改最后一位拿餐具的顺序, 解决循环等待问题
            if(i==4){
                philosophers[i] = new Philosopher(rightChopstick, leftChopstick);
            }

            // 初始化线程
            Thread thread = new Thread(philosophers[i], ("哲学家" + (i + 1)));
            // 启动程序
            thread.start();
        }
    }

    public static class Philosopher implements Runnable {

        Object leftChopstick;
        Object rightChopstick;

        public Philosopher(Object leftChopstick, Object rightChopstick) {
            this.leftChopstick = leftChopstick;
            this.rightChopstick = rightChopstick;
        }

        @Override
        public void run() {
            while (true) {
                doAction("正在思考...");

                synchronized (leftChopstick) {
                    doAction("拿起左边筷子");
                    synchronized (rightChopstick) {
                        doAction("拿起右边筷子");

                        doAction("吃饭中...");

                        doAction("放下右边筷子");

                    }
                    doAction("放下左边筷子");
                }
            }
        }

        /**
         * 动作
         */
        private void doAction(String action) {
            System.out.println(Thread.currentThread().getName() + " " + action);
            try {
                Thread.sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
