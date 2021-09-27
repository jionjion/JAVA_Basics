package factory.method.pizza;

/**
 * 南京希腊披萨
 *
 * @author Jion
 */
public class NjGreekPizza extends AbstractPizza {

    @Override
    public void prepared() {
        System.out.println("南京希腊披萨准备原材料");
    }
}
