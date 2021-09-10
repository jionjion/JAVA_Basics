package networkCommunication.TCPNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/**	服务器端,进行处理类
 * 	传入一个Socket,交由多线程任务同步进行,类似于回调函数,可以处理多并发请求*/
public class ServerThread extends Thread {

	//1.本线程相关的socket
	Socket socket = new Socket();
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	/**2.重写线程方法,调用一个线程,相应客户端的请求*/
	@Override
	public void run() {
		
		BufferedReader bufferedReader = null;
		PrintWriter printWriter = null;
		
		try {
			//3.获取输入流,读取客户端信息
			bufferedReader = new BufferedReader(	//开启输入流
										new InputStreamReader(
											socket.getInputStream(), "UTF-8"));
			String info = null;		//读取输入流
			while((info=bufferedReader.readLine()) != null){
				System.out.println("侦听到来自客户端的:"+info);
			}
			socket.shutdownInput();	//关闭输入流
			//4.获取输出流,相应客户端的请求
			printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write("欢迎你,客户端.....");
			printWriter.flush();
			socket.shutdownOutput();
		} catch (Exception e) {
			System.err.println("客户端读取相应出现异常...");
			e.printStackTrace();
		} finally {
			try {
				//5.关闭资源
				printWriter.close();
				bufferedReader.close();
				socket.close();
			} catch (IOException e) {
				System.err.println("客户端关闭出现异常...");	
				e.printStackTrace();
			}
		}
	}
}
