package strategy;

/**
 *  抽象,鸭子类.
 *  定义方法,被子类重写
 * @author Jion
 */
public abstract class Duck {

    /** 飞行策略 */
    protected FlyBehavior flyBehavior;

    /** 叫策略 */
    protected QuackBehavior quackBehavior;

    /** 飞行 */
    protected void fly(){ }

    /** 叫声 */
    protected void quack(){ }
}
