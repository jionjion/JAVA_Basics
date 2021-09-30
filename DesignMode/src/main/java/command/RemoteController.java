package command;

/**
 * 遥控器,持有多组命令
 *
 * @author Jion
 */
public class RemoteController {

    /**
     * 开机命令组
     */
    private final Command[] onCommands;

    /**
     * 关机命令组
     */
    private final Command[] offCommands;

    /**
     * 撤销的命令
     */
    private Command undoCommand;

    /**
     * 构造器初始化按钮组
     */
    public RemoteController() {
        int defaultCommandSize = 5;

        onCommands = new Command[defaultCommandSize];
        offCommands = new Command[defaultCommandSize];

        // 初始化,为空命令
        for (int i = 0; i < defaultCommandSize; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    /**
     * 为按钮组设置命令
     */
    public void setCommand(int index, Command onCommand, Command offCommand) {
        onCommands[index] = onCommand;
        offCommands[index] = offCommand;
    }

    /**
     * 对外提供按钮,启动
     */
    public void onButtonClick(int index) {
        // 找到具体对的家电按钮,并执行
        onCommands[index].execute();
        // 记录操作,以备撤销
        undoCommand = onCommands[index];
    }

    /**
     * 对外提供按钮,关闭
     */
    public void offButtonClick(int index) {
        // 找到具体对的家电按钮,并执行
        offCommands[index].execute();
        // 记录操作,以备撤销
        undoCommand = offCommands[index];
    }

    /**
     * 对外提供按钮,撤销
     */
    public void undoButtonClick() {
        // 执行上次的撤销命令
        undoCommand.undo();
    }
}
