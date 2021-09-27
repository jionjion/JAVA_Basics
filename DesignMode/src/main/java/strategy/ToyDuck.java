package strategy;

/**
 *  玩具鸭子
 * @author Jion
 */
public class ToyDuck extends BaseDuck {

    /** 在构造器中定义具体策略 */
    public ToyDuck(){
        // 飞行,叫声 行为
        super.flyBehavior = new NoFlyBehavior();
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