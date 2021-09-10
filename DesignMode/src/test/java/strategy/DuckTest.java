package strategy;

import org.junit.Test;

/**
 *  测试. 策略模式
 * @author Jion
 */
public class DuckTest {


    @Test
    public void test(){
        WildDuck wildDuck = new WildDuck();
        wildDuck.fly();
        wildDuck.quack();

        ToyDuck toyDuck = new ToyDuck();
        toyDuck.fly();
        toyDuck.quack();
        // 动态修改行为
        toyDuck.flyBehavior=new GoodFlyBehavior();
        toyDuck.fly();
    }

}