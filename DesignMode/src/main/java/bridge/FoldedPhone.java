package bridge;

/**
 *  组合, 折叠手机
 * @author Jion
 */
public class FoldedPhone extends Phone {

    /** 继承自父类,父类无隐式父类构造器,必须显示调用父类有构造器.传入对象 */
    public FoldedPhone(Brand brand) {
        super(brand);
    }

    /** 重写抽象父类方法 */
    @Override
    protected void open() {
        super.open();
        System.out.println("折叠样式手机打开");
    }

    @Override
    protected void close() {
        super.close();
        System.out.println("折叠样式手机关闭");
    }

    @Override
    protected void call() {
        super.call();
        System.out.println("折叠样式手机打电话");
    }
}
