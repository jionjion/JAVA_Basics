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
    private final List<BasePeople> peoples = new LinkedList<BasePeople>();

    /**
     * 增加
     */
    public void attach(BasePeople people) {
        peoples.add(people);
    }

    /**
     * 移除
     */
    public void detach(BasePeople people) {
        peoples.remove(people);
    }

    /**
     * 测试
     */
    public void dispaly(AbstractAction action) {
        for (BasePeople people : peoples) {
            people.accept(action);
        }
    }
}
