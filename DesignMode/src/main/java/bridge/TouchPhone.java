package bridge;

/**
 * 组合, 触摸屏手机
 * 在调用时,传入不同的品牌,完成桥接组合
 *
 * @author Jion
 */
public class TouchPhone extends BasePhone {

    /**
     * 继承自父类,父类无隐式父类构造器,必须显示调用父类有构造器.传入对象
     */
    public TouchPhone(Brand brand) {
        super(brand);
    }

    /**
     * 重写抽象父类方法
     */
    @Override
    protected void open() {
        super.open();
        System.out.println("触摸屏样式手机打开");
    }

    @Override
    protected void close() {
        super.close();
        System.out.println("触摸屏样式手机关闭");
    }

    @Override
    protected void call() {
        super.call();
        System.out.println("触摸屏样式手机打电话");
    }
}
