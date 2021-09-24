package factory.method;

import factory.method.pizza.Pizza;
import org.junit.Test;

/**
 * @author Jion
 */
public class PizzaMethodFactoryTest {

    @Test
    public void createPizza(){
        PizzaMethodFactory factory = new BJPizzaMethodFactory();
        // 北京地区的奶酪披萨
        Pizza cheese = factory.createPizza("cheese");
        cheese.prepared();
        cheese.bake();
        cheese.cut();
        cheese.box();
    }
}