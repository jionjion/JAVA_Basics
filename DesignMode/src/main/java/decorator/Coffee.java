package decorator;

/**
 *  开发类中间类.
 * @author Jion
 */
public class Coffee extends AbstractDrink {
    /** 计算价格方法 */
    @Override
    public Double cose() {
        return super.getPrice();
    }
}
