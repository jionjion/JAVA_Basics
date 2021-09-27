package decorator;

/**
 *  具体的调味品,牛奶
 * @author Jion
 */
public class Milk extends Decorator{

    /** 调味品,种类与价格 */
    public Milk(AbstractDrink obj) {
        super(obj);
        setDescription("牛奶调味品..");
        setPrice(2.2D);
    }
}
