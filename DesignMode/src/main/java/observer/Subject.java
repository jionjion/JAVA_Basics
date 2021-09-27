package observer;

/**
 * 主题
 *
 * @author Jion
 */
public interface Subject {

    /**
     * 注册
     *
     * @param observer 观察者
     */
    void registerObserver(Observer observer);

    /**
     * 移除
     *
     * @param observer 观察者
     */
    void removeObserver(Observer observer);

    /**
     * 观察
     *
     * @param temperature 观察对象,温度变化
     */
    void notifyObservers(Float temperature);
}
