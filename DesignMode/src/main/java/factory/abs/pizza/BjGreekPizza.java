package factory.abs.pizza;

/**
 * 北京希腊披萨
 *
 * @author Jion
 */
public class BjGreekPizza extends AbstractPizza {

    @Override
    public void prepared() {
        System.out.println("北京的希腊披萨准备原材料");
    }
}
