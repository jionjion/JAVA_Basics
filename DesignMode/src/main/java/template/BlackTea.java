package template;

/**
 * 红茶的制作
 *
 * @author Jion
 */
public class BlackTea extends AbstractTea {

    @Override
    protected void select() {
        System.out.println("选择红茶...");
    }

    @Override
    protected void boil() {
        super.boil();
        System.out.println("红茶煮沸中...");
    }
}
