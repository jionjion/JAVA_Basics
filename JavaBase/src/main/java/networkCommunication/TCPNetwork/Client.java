package networkCommunication.TCPNetwork;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**	TCP协议的客户端,随后请求
 * 	实现请求,建立连接*/
public class Client {

	public static void main(String[] args) throws Exception{
		//1.创建Socket,指定服务器地址和端口
		Socket socket = new Socket("127.0.0.1", 8888);
		//2.获取输出流,发送信息
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
		printWriter.write("你好,我是客户端!");
		printWriter.flush();
		socket.shutdownOutput();
		//3.读取服务器端的相应
		BufferedReader reader = new BufferedReader(
											new InputStreamReader(
												socket.getInputStream(),"UTF-8"));
		String info = null;		//读取输入流
		while((info=reader.readLine()) != null){
			System.out.println("侦听到来自服务器的:"+info);
		}
		//4.关闭资源
		printWriter.close();
		socket.close();
	}
}
