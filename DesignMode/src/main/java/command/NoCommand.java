package command;

/**
 * 空命令,控制性.用于初始化
 * 当调用时,什么也不做
 *
 * @author Jion
 */
public class NoCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
