package visitor;

/**
 * 具体访问者
 * 打分成功
 *
 * @author Jion
 */
public class Success extends Action {

    @Override
    public void getManResult(Man man) {
        System.out.println("男歌手晋升成功..." + man.name);
    }

    @Override
    public void getWoManResult(Woman woman) {
        System.out.println("女歌手晋升成功..." + woman.name);
    }
}
