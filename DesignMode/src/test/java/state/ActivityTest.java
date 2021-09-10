package state;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *  状态模式
 * @author Jion
 */
public class ActivityTest {

    @Test
    public void test(){
        // 活动,设置状态
        Activity activity = new Activity(new InitState());
        // 可以调用初始化方法
        activity.state.doInit();
        // 修改新状态,并执行
        activity.state = new WorkState();
        activity.state.doWork();
        // 修改新状态,并执行
        activity.state = new DestroyState();
        activity.state.doDestroy();
        // 尝试使用非当前状态的; 不能使用
        activity.state.doInit();

    }
}