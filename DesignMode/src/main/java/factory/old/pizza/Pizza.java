package factory.old.pizza;

/**
 * 披萨,抽象类
 *
 * @author Jion
 */
public abstract class Pizza {

    /** 披萨类型 */
    protected String name;


    /** 准备披萨,交给子类实现 */
    public abstract void perpare();

    /** 烘烤 */
    public void bake(){
        System.out.println(name + "烘烤披萨");
    }

    /** 切割 */
    public void cut(){
        System.out.println(name + "切割披萨");

    }
    /** 打包 */
    public void box(){
        System.out.println(name + "打包披萨");

    }

    /** 披萨名赋值 */
    public void setName(String name) {
        this.name = name;
    }
}
