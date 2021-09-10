package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 天气信息,被观察对象
 *
 * @author Jion
 */
public class WeatherData implements Subject{

    /** 所有观察者 */
    List<Observer> observer = new ArrayList<>(4);

    @Override
    public void registerObserver(Observer observer) {
        this.observer.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observer.remove(observer);
    }

    @Override
    public void notifyObservers(Float temperature) {
        observer.forEach(o -> o.update(temperature));
    }
}
