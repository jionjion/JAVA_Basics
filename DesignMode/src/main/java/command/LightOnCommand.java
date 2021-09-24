package command;

/**
 * 灯打开命令,聚合具体的执行者.
 * 并将命令与执行者相关
 *
 * @author Jion
 */
public class LightOnCommand implements Command {

    /**
     * 聚合命令具体执行者
     */
    private final LightReceiver lightReceiver;

    public LightOnCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        lightReceiver.on();
    }

    @Override
    public void undo() {
        lightReceiver.off();
    }
}
