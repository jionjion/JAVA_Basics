package state;

/**
 *  工作状态
 * @author Jion
 */
public class DestroyState implements State{

    @Override
    public void doInit() {
        System.out.println("禁止");
    }

    @Override
    public void doWork() {
        System.out.println("禁止");
    }

    @Override
    public void doDestroy() {
        System.out.println("执行销毁方法...");
    }
}
