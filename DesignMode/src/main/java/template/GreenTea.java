package template;

/**
 * 绿茶的制作
 *
 * @author Jion
 */
public class GreenTea extends AbstractTea {

    @Override
    protected void select() {
        System.out.println("选择绿茶...");
    }

    @Override
    public void pack() {
        super.pack();
    }

    /** 重写父类方法,钩子方法执行 */
    @Override
    public boolean isPack(){
        return true;
    }
}
