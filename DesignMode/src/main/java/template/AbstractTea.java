package template;

/**
 * 抽象类,定义模板
 *
 * @author Jion
 */
public abstract class AbstractTea {

    /**
     * 模板方法,不允许修改
     */
    public final void make() {
        select();

        boil();

        finish();

        // 钩子方法
        if (isPack()) {
            pack();
        }
    }

    /**
     * 1. 选材,抽象类,子类必须实现
     */
    protected abstract void select();


    /**
     * 2. 煮沸,子类选择实现
     */
    protected void boil() {
        System.out.println("煮沸中...");
    }

    /**
     * 3. 完成
     */
    public void finish() {
        System.out.println("制作完成...");
    }

    /**
     * 4. 钩子方法,是否打包
     */
    public void pack() {
        System.out.println("打包....");
    }

    public boolean isPack() {
        return false;
    }
}
