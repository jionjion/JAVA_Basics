package facade;

/**
 *  外观类
 * @author Jion
 */
public class HomeFacade {

    // 各个子系统对象

    /** DVD */
    private final DvdPlayer dvdPlayer;

    /** Mp3 */
    private final Mp3Player mp3Player;

    /** Tv */
    private final TvPlayer tvPlayer;

    /** 构造器注入依赖 */
    public HomeFacade(){
        dvdPlayer = new DvdPlayer();
        mp3Player = new Mp3Player();
        tvPlayer = new TvPlayer();
    }

    /** 组织各个方法 */
    public void ready(){
        dvdPlayer.on();
        mp3Player.on();
        tvPlayer.on();
    }

    /** 组织各个方法 */
    public void enjoy(){
        dvdPlayer.play();
        mp3Player.fm();
        tvPlayer.change();
    }

    /** 组织各个方法 */
    public void end(){
        dvdPlayer.off();
        mp3Player.off();
        tvPlayer.off();
    }
}
