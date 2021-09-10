package adapter.inter;

/**
 *  抽象适配器类, 全部空实现
 * @author Jion
 */
public abstract class AbstractVoltage implements VoltageInterface{

    public int output220V() {
        return 0;
    }

    public int output110V() {
        return 0;
    }

    public int output5V() {
        return 0;
    }
}
