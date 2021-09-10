package observer;

/**
 *  观察者, 订阅用户天气.手机
 *
 * @author Jion
 */
public class WeatherMobile implements Observer{

    /** 观察内容: 天气温度 */
    public void use(Float temperature){
        System.out.println("手机观察天气: " + temperature);
    }

    @Override
    public void update(Float temperature) {
        // 执行内部方法
        use(temperature);
    }
}
