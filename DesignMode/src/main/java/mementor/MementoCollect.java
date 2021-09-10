package mementor;

import java.util.ArrayList;
import java.util.List;

/**
 *  备忘录集合
 * @author Jion
 */
public class MementoCollect {

    private final List<Memento> mementos = new ArrayList<>(4);

    /** 添加状态 */
    public void add(Memento memento){
        mementos.add(memento);
    }

    /** 获得状态 */
    public Memento get(int index){
        return mementos.get(index);
    }
}
