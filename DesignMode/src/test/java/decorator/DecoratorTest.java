package decorator;

import org.junit.Test;

/**
 *  测试使用装饰者模式
 * @author Jion
 */
public class DecoratorTest {

    @Test
    public void test(){
        // 1.确定单体咖啡
        Drink coffee = new LongBlackCoffee();
        // 尝试..计算价格..=> 5
        System.out.println(coffee.getDescription());
        System.out.println(coffee.cose());

        // 2.加入调料,新的饮料
        Milk coffeeMilk = new Milk(coffee);
        // 尝试..计算价格..=> 5 + 2.2 = 7.7
        System.out.println(coffeeMilk.getDescription());
        System.out.println(coffeeMilk.cose());

        // 3.加入调料,新的饮料
        Chocolate coffeeMilkChocolate = new Chocolate(coffeeMilk);
        // 尝试..计算价格..=> 5 + 2.2 + 3.3 = 10.5
        System.out.println(coffeeMilkChocolate.getDescription());
        System.out.println(coffeeMilkChocolate.cose());
    }
}