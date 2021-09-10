package singleton;

/**
 * 静态内部类实现单例模式
 *
 * @author Jion
 */
public class SingleExample5 {

    /**
     * 1.私有构造方法
     */
    private SingleExample5() {

    }

    /** 2.私有变量 */
    private static SingleExample5 instance;


    /** 3.声明一个静态内部类 */
    private static class SingleExample5Instance {
        // 类装载机制,在外部类装载完成后.内部类在使用时装载.装载时线程安全.
        private static final SingleExample5 INSTANCE = new SingleExample5();
    }

    /** 4.将静态内部类维护实例返回 */
    public static SingleExample5 getInstance(){
        return SingleExample5Instance.INSTANCE;
    }

}
