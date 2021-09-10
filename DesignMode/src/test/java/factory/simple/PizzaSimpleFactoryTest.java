package factory.simple;

import factory.simple.pizza.Pizza;
import org.junit.Test;

/**
 *  简单工厂模式
 * @author Jion
 */
public class PizzaSimpleFactoryTest {

    @Test
    public void createPizza(){
        // 通过工厂模式获得 对象示例
        PizzaSimpleFactory factory = new PizzaSimpleFactory();
        Pizza pizza = factory.createPizza("cheese");
        pizza.perpare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }
}