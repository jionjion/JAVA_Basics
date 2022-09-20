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
     * 2.创建类实例, 通过类加载的时候, 保证实例唯一
     */
    private static final SingleExample1 INSTANCE = new SingleExample1();

    /**
     * 3.提供共有静态方法,返回实例
     */
    public static SingleExample1 getInstance() {
        return INSTANCE;
    }
}
