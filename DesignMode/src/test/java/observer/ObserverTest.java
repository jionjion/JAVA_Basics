package observer;

import org.junit.Test;

/**
 * 测试观察者模式
 *
 * @author Jion
 */
public class ObserverTest {

    @Test
    public void test(){
        // 被观察者对象
        WeatherData weatherData = new WeatherData();

        // 观察者, 用户
        WeatherUser user = new WeatherUser();
        // 观察者, 手机
        WeatherMobile mobile = new WeatherMobile();

        // 注册观察者
        weatherData.registerObserver(user);
        weatherData.registerObserver(mobile);

        // 更新事件
        weatherData.notifyObservers(52F);
    }

}