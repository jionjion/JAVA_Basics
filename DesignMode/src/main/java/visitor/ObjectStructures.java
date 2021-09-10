package visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * 维护成员的数据结构
 *
 * @author Jion
 */
public class ObjectStructures {

    /**
     * 维护集合
     */
    private final List<People> peoples = new LinkedList<People>();

    /**
     * 增加
     */
    public void attach(People people) {
        peoples.add(people);
    }

    /**
     * 移除
     */
    public void detach(People people) {
        peoples.remove(people);
    }

    /**
     * 测试
     */
    public void dispaly(Action action) {
        for (People people : peoples) {
            people.accept(action);
        }
    }
}
