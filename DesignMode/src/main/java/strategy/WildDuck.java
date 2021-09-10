package strategy;

/**
 *  野鸭
 * @author Jion
 */
public class WildDuck extends Duck {

    /** 在构造器中定义具体策略 */
    public WildDuck(){
        // 飞行,叫声 行为
        super.flyBehavior = new GoodFlyBehavior();
        super.quackBehavior = new GoodQuackBehavior();
    }

    /**
     * 飞行
     */
    @Override
    protected void fly() {
        super.flyBehavior.fly();
    }

    /**
     * 叫声
     */
    @Override
    protected void quack() {
        super.quackBehavior.quack();
    }
}