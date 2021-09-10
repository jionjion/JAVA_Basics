package observer;

/**
 *  观察者, 订阅用户天气.
 *  可以有多个,各种观察者实现
 * @author Jion
 */
public class WeatherUser implements Observer{

    /** 观察内容: 天气温度 */
    public void use(Float temperature){
        System.out.println("用户观察天气: " + temperature);
    }

    @Override
    public void update(Float temperature) {
        // 执行内部方法
        use(temperature);
    }
}
