package immutable;

/**
 * 演示不可变的对象
 *
 * @author Jion
 */
public class Person {

    /**
     * final 在声明时赋值
     */
    private final int age = 18;

    /**
     * final 在代码块中赋值
     */
    private final String name;


    {
        name = "Jion";
    }

    /**
     * final 在构造函数中赋值
     */
    private final String address;


    public Person() {
        this.address = "杨浦区";
    }

    /**
     * static final 在声明时赋值
     */
    private static final String country = "中国";

    /**
     * static final 在静态代码看中赋值
     */
    private static final String province;


    static {
        province = "上海";
    }


    void sayHello() {
        String message;

        // 使用变量前必须赋值
        message = "Hello, " + name;
        System.out.println("说: " + message);
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.sayHello();
    }
}
