package factory.old.order;

import org.junit.Test;

/**
 *  测试订购 披萨
 * @author Jion
 */
public class OrderPizzaTest {


    @Test
    public void test(){
        OrderPizza orderPizza = new OrderPizza();
        orderPizza.order("cheese");
    }
}