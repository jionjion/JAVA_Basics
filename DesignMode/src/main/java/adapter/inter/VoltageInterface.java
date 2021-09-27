package adapter.inter;

/**
 * 多方法
 *
 * @author Jion
 */
public interface VoltageInterface {

    /**
     * 输出220V电流
     *
     * @return 220V电流
     */
    int output220V();

    /**
     * 输出110V电流
     *
     * @return 110V电流
     */
    int output110V();

    /**
     * 输出5V电流
     *
     * @return 5V电流
     */
    int output5V();
}
