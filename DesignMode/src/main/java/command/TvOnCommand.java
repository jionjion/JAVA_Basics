package command;

/**
 * 电视机开命令,聚合具体的执行者.
 * 并将命令与执行者相关
 *
 * @author Jion
 */
public class TvOnCommand implements Command {

    /**
     * 聚合命令具体执行者
     */
    private final TvReceiver tvReceiver;

    public TvOnCommand(TvReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }

    public void execute() {
        tvReceiver.on();
    }

    public void undo() {
        tvReceiver.off();
    }
}
