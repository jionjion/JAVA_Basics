package visitor;

/**
 * 数据, 女歌手
 *
 * @author Jion
 */
public class Woman extends BasePeople {

    public Woman(String name) {
        super();
        super.name = name;
    }

    @Override
    public void accept(AbstractAction action) {
        action.getWoManResult(this);
    }
}
