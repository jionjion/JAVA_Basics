package singleton;

/**
 * 懒汉式单例模式
 *
 * @author Jion
 */
public class SingleExample3 {

    /**
     * 1.私有构造方法
     */
    private SingleExample3() {

    }

    /**
     * 2.私有变量
     */
    private static SingleExample3 instance;

    /**
     * 3.提供共有静态方法,返回实例.
     * 使用时创建,否则不创建
     * 通过 synchronized 加锁关键字, 保证多个线程调用时, 只有一个线程进入创建实例..
     */
    public static synchronized SingleExample3 getInstance() {
        if (instance == null) {
            return new SingleExample3();
        }
        return instance;
    }
}
