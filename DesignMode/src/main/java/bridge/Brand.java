package bridge;

/**
 * 品牌类,定义手机品牌
 *
 * @author Jion
 */
public interface Brand {

    /**
     * 开机
     */
    void open();

    /**
     * 关机
     */
    void close();

    /**
     * 打电话
     */
    void call();
}

