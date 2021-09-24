package factory.abs.pizza;

/**
 * 南京起司披萨
 *
 * @author Jion
 */
public class NjCheesePizza extends Pizza {

    @Override
    public void prepared() {
        System.out.println("南京起司披萨准备原材料");
    }
}
