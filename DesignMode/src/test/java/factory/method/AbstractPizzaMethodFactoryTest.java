package factory.method;

import factory.method.pizza.AbstractPizza;
import org.junit.Test;

/**
 * @author Jion
 */
public class AbstractPizzaMethodFactoryTest {

    @Test
    public void createPizza(){
        AbstractPizzaMethodFactory factory = new BjPizzaMethodFactory();
        // 北京地区的奶酪披萨
        AbstractPizza cheese = factory.createPizza("cheese");
        cheese.prepared();
        cheese.bake();
        cheese.cut();
        cheese.box();
    }
}