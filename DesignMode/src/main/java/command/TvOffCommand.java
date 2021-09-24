package command;

/**
 * 电视机关命令,聚合具体的执行者.
 * 并将命令与执行者相关
 *
 * @author Jion
 */
public class TvOffCommand implements Command {

    /**
     * 聚合命令具体执行者
     */
    private final TvReceiver tvReceiver;

    public TvOffCommand(TvReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }
    @Override
    public void execute() {
        tvReceiver.off();
    }

    @Override
    public void undo() {
        tvReceiver.on();
    }
}
