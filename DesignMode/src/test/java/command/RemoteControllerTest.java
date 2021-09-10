package command;

import org.junit.Test;

/**
 * 调用遥控器
 *
 * @author Jion
 */
public class RemoteControllerTest {

    @Test
    public void test(){
        // 接收者: 电灯
        LightReceiver lightReceiver = new LightReceiver();

        // 命令: 开,关
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

        // 调用者: 遥控器
        RemoteController remoteController = new RemoteController();
        // 遥控器,命令数组初始化
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);

        // 具体操作... 开..关..撤销
        remoteController.onButtonClick(0);
        remoteController.offButtonClick(0);
        remoteController.undoButtonClick();

        // 接收者: 电视机
        TvReceiver tvReceiver = new TvReceiver();

        // 命令: 开,关
        TvOnCommand tvOnCommand = new TvOnCommand(tvReceiver);
        TvOffCommand tvOffCommand = new TvOffCommand(tvReceiver);

        // 遥控器,命令数组初始化
        remoteController.setCommand(1, tvOnCommand, tvOffCommand);

        // 具体操作... 开..关..撤销
        remoteController.onButtonClick(1);
        remoteController.offButtonClick(1);
        remoteController.undoButtonClick();
    }
}