package bridge;

/**
 *  实现品牌
 * @author Jion
 */
public class XiaoMi implements Brand {
    public void open() {
        System.out.println("小米手机开机...");
    }

    public void close() {
        System.out.println("小米手机关机...");
    }

    public void call() {
        System.out.println("小米手机打电话...");
    }
}
