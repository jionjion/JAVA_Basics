package javaReflex;

public class User {

	public User(){}
	
	public User(String username){
		this.username = username;
	}
	
	public String username;
	
	public int age;
	
	public void say() {
		System.out.println("我是人,我能说话!!");
	}
	
	public void sing(String singName) {
		System.out.println("我是人,我能唱歌,来一首"+singName+"!!");
	}
	
	public void play(String game,int min) {
		System.out.println("我是人,我能跑,我能玩"+game+"不吃不喝"+min+"小时!!");
	}
}
