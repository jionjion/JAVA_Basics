package command;

/**
 * 命令接口
 *
 * @author Jion
 */
public interface Command {

    /** 执行动作 */
    public void execute();

    /** 撤销动作 */
    public void undo();
}
