package visitor;

import org.junit.Test;

/**
 * 访问者模式使用
 *
 * @author Jion
 */
public class ObjectStructuresTest {

    @Test
    public void test() {
        // 对象数据结构
        ObjectStructures context = new ObjectStructures();

        // 添加对象
        context.attach(new Man("男一号"));
        context.attach(new Woman("女一号"));

        // 打分,成功
        Success success = new Success();
        context.dispaly(success);

        // 打分,失败
        Fail fail = new Fail();
        context.dispaly(fail);

        //扩展状态.等待
        Wait wait = new Wait();
        context.dispaly(wait);
    }
}