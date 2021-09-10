package prototype.clone;

import org.junit.Test;

import java.io.IOException;

/**
 * @author Jion
 */
public class DeepProtoTypeTest {


    @Test
    public void test() throws CloneNotSupportedException {
        // 浅拷贝
        DeepProtoType deepProtoType1 = new DeepProtoType();
        deepProtoType1.setSheep(new Sheep("Jion", 1));
        DeepProtoType deepProtoType2 = (DeepProtoType) deepProtoType1.clone();
        DeepProtoType deepProtoType3 = (DeepProtoType) deepProtoType1.clone();

        // 查看
        System.out.println("DeepProtoType1 " + deepProtoType1.toString());
        System.out.println("DeepProtoType1 " + deepProtoType1.getSheep().hashCode());

        System.out.println("DeepProtoType2 " + deepProtoType2.toString());
        System.out.println("DeepProtoType1 " + deepProtoType2.getSheep().hashCode());

        System.out.println("DeepProtoType3 " + deepProtoType3.toString());
        System.out.println("DeepProtoType1 " + deepProtoType3.getSheep().hashCode());
    }


    @Test
    public void deepClone() throws IOException, ClassNotFoundException {
        // 浅拷贝
        DeepProtoType deepProtoType1 = new DeepProtoType();
        deepProtoType1.setSheep(new Sheep("Jion", 1));
        DeepProtoType deepProtoType2 = (DeepProtoType) deepProtoType1.deepClone();
        DeepProtoType deepProtoType3 = (DeepProtoType) deepProtoType1.deepClone();

        // 查看
        System.out.println("DeepProtoType1 " + deepProtoType1.toString());
        System.out.println("DeepProtoType1 " + deepProtoType1.getSheep().hashCode());

        System.out.println("DeepProtoType2 " + deepProtoType2.toString());
        System.out.println("DeepProtoType1 " + deepProtoType2.getSheep().hashCode());

        System.out.println("DeepProtoType3 " + deepProtoType3.toString());
        System.out.println("DeepProtoType1 " + deepProtoType3.getSheep().hashCode());
    }
}