package visitor;

/**
 * 数据, 男歌手
 *
 * @author Jion
 */
public class Man extends BasePeople {

    public Man(String name) {
        super();
        super.name = name;
    }

    @Override
    public void accept(AbstractAction action) {
        action.getManResult(this);
    }
}
