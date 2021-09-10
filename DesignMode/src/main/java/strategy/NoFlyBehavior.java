package strategy;

/**
 *  飞行策略实现, 不会飞
 * @author Jion
 */
public class NoFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞翔的鸭子...");
    }
}
