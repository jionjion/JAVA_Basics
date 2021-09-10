package visitor;

/**
 * 数据, 女歌手
 *
 * @author Jion
 */
public class Woman extends People {

    public Woman(String name) {
        super();
        super.name = name;
    }

    @Override
    public void accept(Action action) {
        action.getWoManResult(this);
    }
}
