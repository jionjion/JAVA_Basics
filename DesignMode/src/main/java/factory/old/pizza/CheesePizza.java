package factory.old.pizza;

/**
 * 起司披萨
 *
 * @author Jion
 */
public class CheesePizza extends AbstractPizza {

    @Override
    public void prepared() {
        System.out.println("起司披萨准备原材料");
    }
}
