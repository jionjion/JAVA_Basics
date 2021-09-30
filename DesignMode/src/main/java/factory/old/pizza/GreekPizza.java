package factory.old.pizza;

/**
 * 希腊披萨
 *
 * @author Jion
 */
public class GreekPizza extends AbstractPizza {

    @Override
    public void prepared() {
        System.out.println("希腊披萨准备原材料");
    }
}
