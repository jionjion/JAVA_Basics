package networkCommunication.UDPNetwork;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**UDP的服务端*/
public class Server {

	public static void main(String[] args) throws Exception {
		//1.创建服务端的DatagramSocket,指定端口
		DatagramSocket socket = new DatagramSocket(9999);
		//2.创建数据报,接收客户端的数据报信息
		byte[] request = new byte[1024];	//创建字节数组,指定数据报的大小
		DatagramPacket packet = new DatagramPacket(request, request.length);
		//3.接收客户端发送的数据
		System.out.println("---------服务器正在监听-----------");
		socket.receive(packet);			//该方法在接收到数据报之前会一直阻塞
		//4.读取数据
		String info = new String(request, 0, packet.getLength());
		System.out.println("服务器收到数据报:"+info);
		

		
		//5.响应请求,从数据报中发送来的客户端地址,端口
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] response = new String("欢迎您,嘤嘤...").getBytes();
		//6.创建数据报,包含响应的数据信息
		DatagramPacket packet2 = new DatagramPacket(response, response.length, address, port);
		//7.响应客户端
		socket.send(packet2);
		//8.关闭资源
		socket.close();
	}
}
