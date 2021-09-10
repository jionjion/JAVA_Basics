package networkCommunication.UDPNetwork;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**UDP通信的客户端*/
public class Client {

	public static void main(String[] args) throws Exception {
		//1.指定发送的地址,端口号,数据
		InetAddress address = InetAddress.getByName("127.0.0.1");
		int port = 9999;
		byte[] request = new String("(｡･∀･)ﾉﾞ嗨").getBytes();
		//2.创建数据报,包含发送的数据信息
		DatagramPacket packet = new DatagramPacket(request, request.length, address, port);
		//3.创建DatagramSocket对象
		DatagramSocket socket = new DatagramSocket();
		//4.向服务器端发送数据报
		socket.send(packet);
		
		//5.接收服务器端信息,获取数据报
		byte[] respose = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(respose, respose.length);
		//6.接收服务器的相应数据
		socket.receive(packet2);
		//7.读取数据
		String info = new String(respose, 0, packet2.getLength());
		System.out.println("服务器响应为:"+info);
		//8.关闭资源
		socket.close();
	}
}
