package networkCommunication.TCPNetwork;

import java.net.ServerSocket;
import java.net.Socket;

/**	TCP通讯的服务端,首先打开
 * 	实现侦听,读取客户端的请求
 * 	调用多线程类*/
public class Server {

	public static void main(String[] args) throws Exception {
		int count = 0;	
		//1.创建服务器端的ServerSocket,并侦听端口
		ServerSocket serverSocket = new ServerSocket(8888);
		//2.开始侦听,等待连接
		System.out.println("-----循环侦听,等待客户度连接....------");
		while(true){
			Socket socket = serverSocket.accept();
			//创建一个新的线程,启动
			ServerThread thread = new ServerThread(socket);
			//启动线程  
			thread.start();
			count++;					//统计连接过的服务器
			System.out.println("当前您为第"+count+"个用户");
		}	
	}
}