package mediator;

import org.junit.Test;

/**
 *  中介者模式测试
 * @author Jion
 */
public class ConcreteMediatorTest {

    @Test
    public void test(){
        // 创建一个中介者
        Mediator mediator = new ConcreteMediator();
        // 创建各个子系统
        Alarm alarm = new Alarm(mediator, "alarm");
        Tv tv = new Tv(mediator, "tv");
        Light light = new Light(mediator, "light");
        // 发送消息
        alarm.sendMessage(1);
        light.sendMessage(2);
        tv.sendMessage(3);
    }
}