package decorator;

/**
 * 美式咖啡
 *
 * @author Jion
 */
public class LongBlackCoffee extends Coffee {

    /**
     * 构造器
     */
    public LongBlackCoffee() {
        // 为其指定属性
        setDescription("美式咖啡");
        setPrice(5D);
    }
}
