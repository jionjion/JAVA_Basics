package factory.abs;

import factory.abs.pizza.Pizza;
import org.junit.Test;

/**
 * @author Jion
 */
public class AbstractPizzaFactoryTest {

    @Test
    public void createPizza(){
        AbstractPizzaFactory factory = new BJPizzaMethodFactory();
        // 北京地区的奶酪披萨
        Pizza cheese = factory.createPizza("cheese");
        cheese.perpare();
        cheese.bake();
        cheese.cut();
        cheese.box();
    }
}