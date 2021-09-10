package singleton;

/**
 * 双重检查单例模式
 *
 * @author Jion
 */
public class SingleExample4 {

    /**
     * 1.私有构造方法
     */
    private SingleExample4() {

    }

    /** 2.私有变量, 添加volatile关键字,防止指令重排序,使对象完成初始化分配,刷入主内存,多线程间可见 */
    private static volatile SingleExample4 instance;

    /**
     * 3.提供共有静态方法,返回实例.
     *  使用时创建,否则不创建.
     */
    public static SingleExample4 getInstance() {
        if(instance == null){
            // 同步代码块.锁对象为实例类
            synchronized (SingleExample4.class){
                // 再次检查,避免多线程进入 getInstance , 导致最初判断失效
                if(instance == null){
                    return new SingleExample4();
                }
            }
        }
        return instance;
    }
}
