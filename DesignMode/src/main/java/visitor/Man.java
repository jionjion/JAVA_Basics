package visitor;

/**
 * 数据, 男歌手
 *
 * @author Jion
 */
public class Man extends People {

    public Man(String name) {
        super();
        super.name = name;
    }

    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
