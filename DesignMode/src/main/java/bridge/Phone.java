package bridge;

/**
 * 手机,抽象类,组合品牌类型.
 * 起到桥接的作用.
 *
 * @author Jion
 */
public abstract class Phone {

    /** 桥,一方组合品牌 */
    private Brand brand;

    /** 构造器传入,组合 */
    public Phone(Brand brand){
        super();
        this.brand = brand;
    }

    /** 桥,让另一方被继承子类调用组合方法 */
    protected void open(){
        this.brand.open();
    }

    /** 调用组合方法 */
    protected void close(){
        this.brand.close();
    }

    /** 调用组合方法 */
    protected void call(){
        this.brand.call();
    }
}
