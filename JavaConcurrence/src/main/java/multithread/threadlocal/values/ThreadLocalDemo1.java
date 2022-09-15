package multithread.threadlocal.values;

/**
 * 模拟 SpringMVC 调用时,参数传递
 *
 * @author Jion
 */
public class ThreadLocalDemo1 {
    /**
     * 不同方法间调用时, 获得线程变量
     */
    public static void main(String[] args) {
        Service1 service1 = new Service1();
        service1.process();
    }
}

class Service1 {

    /**
     * 第一个服务中中,获得对象放入到线程中..
     */
    public void process() {
        User user = new User("Jion");
        // 放入到容器中
        UserContextHolder.setUser(user);
        System.out.println("服务1存放变量: " + user);
        new Service2().process();
    }
}

class Service2 {

    /**
     * 第二个服务中中,获得对象放入到线程中..
     */
    public void process() {
        // 从到容器中获取
        User user = UserContextHolder.getUser();
        System.out.println("服务2获取变量: " + user);
        new Service3().process();
    }
}

class Service3 {

    /**
     * 第三个服务中中,获得对象放入到线程中..
     */
    public void process() {
        // 从到容器中获取
        User user = UserContextHolder.getUser();
        System.out.println("服务3获取变量: " + user);
        // 使用完成后, 手动删除, 避免内存泄露
        UserContextHolder.clear();
    }
}

/**
 * User 类的持有容器
 */
class UserContextHolder {
    private static ThreadLocal<User> holder = new ThreadLocal<>();

    public static User getUser() {
        return holder.get();
    }

    public static void setUser(User user) {
        holder.set(user);
    }

    public static void clear() {
        holder.remove();
    }
}

class User {
    String name;

    User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + '}';
    }
}