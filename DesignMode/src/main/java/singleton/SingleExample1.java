package singleton;

/**
 * 饿汉式单例模式
 * 通过静态常量
 *
 * @author Jion
 */
public class SingleExample1 {

    /**
     * 1.私有构造方法
     */
    private SingleExample1() {

    }

    /**
     * 2.创建类实例
     */
    private final static SingleExample1 INSTANCE = new SingleExample1();

    /**
     * 3.提供共有静态方法,返回实例
     */
    public static SingleExample1 getInstance() {
        return INSTANCE;
    }
}
