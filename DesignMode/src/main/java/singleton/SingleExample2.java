package singleton;

/**
 * 饿汉式单例模式
 * 通过静态代码块
 *
 * @author Jion
 */
public class SingleExample2 {

    /**
     * 1.私有构造方法
     */
    private SingleExample2() {

    }

    /**
     * 私有变量
     */
    private static final SingleExample2 INSTANCE;

    /*
     * 2.在静态代码块中创建类实例, 通过类加载保证唯一性
     */
    static {
        INSTANCE = new SingleExample2();
    }

    /**
     * 3.提供共有静态方法,返回实例
     */
    public static SingleExample2 getInstance() {
        return INSTANCE;
    }
}
