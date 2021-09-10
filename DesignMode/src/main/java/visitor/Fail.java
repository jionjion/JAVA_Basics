package visitor;

/**
 * 具体访问者
 * 打分失败
 *
 * @author Jion
 */
public class Fail extends Action {

    @Override
    public void getManResult(Man man) {
        System.out.println("男歌手晋升失败..." + man.name);
    }

    @Override
    public void getWoManResult(Woman woman) {
        System.out.println("女歌手晋升失败..." + woman.name);
    }
}
