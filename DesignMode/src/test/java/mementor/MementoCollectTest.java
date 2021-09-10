package mementor;

import org.junit.Test;

/**
 *  备忘录模式
 * @author Jion
 */
public class MementoCollectTest {

    @Test
    public void test(){
        Originator originator = new Originator();

        // 备忘录集合
        MementoCollect collect = new MementoCollect();

        // 状态 1
        originator.status = "状态#1";
        // 保存状态
        collect.add(originator.save());

        // 状态 2
        originator.status = "状态#2";
        collect.add(originator.save());

        // 状态 3
        originator.status = "状态#3";
        collect.add(originator.save());

        // 获得之前状态
        System.out.println(collect.get(2).status);
        // 恢复
        originator.recoverStatusFromMemento(collect.get(2));
    }
}