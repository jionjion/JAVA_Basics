package state;

/**
 *  初始化状态
 * @author Jion
 */
public class InitState implements State{
    @Override
    public void doInit() {
        System.out.println("执行初始方法...");
    }

    @Override
    public void doWork() {
        System.out.println("禁止");
    }

    @Override
    public void doDestroy() {
        System.out.println("禁止");
    }
}
