package state;

/**
 *  工作状态
 * @author Jion
 */
public class WorkState implements State{
    @Override
    public void doInit() {
        System.out.println("禁止");
    }

    @Override
    public void doWork() {
        System.out.println("执行工作方法...");
    }

    @Override
    public void doDestroy() {
        System.out.println("禁止");
    }
}
