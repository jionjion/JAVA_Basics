package prototype.clone;

import org.junit.Test;

/**
 * @author Jion
 */
public class ShallowProtoTypeTest {

    @Test
    public void test() throws CloneNotSupportedException {
        // 浅拷贝
        ShallowProtoType shallowProtoType1 = new ShallowProtoType();
        shallowProtoType1.setSheep(new Sheep("Jion", 1));
        ShallowProtoType shallowProtoType2 = (ShallowProtoType) shallowProtoType1.clone();
        ShallowProtoType shallowProtoType3 = (ShallowProtoType) shallowProtoType1.clone();

        // 查看
        System.out.println("DeepProtoType1 " + shallowProtoType1.toString());
        System.out.println("DeepProtoType1 " + shallowProtoType1.getSheep().hashCode());

        System.out.println("DeepProtoType2 " + shallowProtoType2.toString());
        System.out.println("DeepProtoType2 " + shallowProtoType2.getSheep().hashCode());

        System.out.println("DeepProtoType3 " + shallowProtoType3.toString());
        System.out.println("DeepProtoType3 " + shallowProtoType3.getSheep().hashCode());
    }
}