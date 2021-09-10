package visitor;

/**
 * 具体访问者
 * 扩展,打分状态. 等待晋升
 *
 * @author Jion
 */
public class Wait extends Action {

    @Override
    public void getManResult(Man man) {
        System.out.println("男歌手等待晋升..." + man.name);
    }

    @Override
    public void getWoManResult(Woman woman) {
        System.out.println("男歌手等待晋升..." + woman.name);
    }
}
