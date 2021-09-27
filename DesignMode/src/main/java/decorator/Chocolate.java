package decorator;

/**
 *  具体的调味品,巧克力
 * @author Jion
 */
public class Chocolate extends Decorator{

    /** 调味品,种类与价格 */
    public Chocolate(AbstractDrink obj) {
        super(obj);
        setDescription("巧克力调味品..");
        setPrice(3.3D);
    }
}
