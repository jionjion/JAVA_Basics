package networkCommunication;
/**IP地址类*/
import java.net.InetAddress;
import java.util.Arrays;

/**
 * 	InetAddress类的使用*/
public class InetAddressDemo {

	public static void main(String[] args) throws Exception{
		//获取实例
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("直接获得当前的IP和端口号:"+address.toString());
		System.out.println("当前计算机名称:"+address.getHostName());
		System.out.println("当前计算机IP:"+address.getHostAddress());
		System.out.println("字节数组形式的IP:"+Arrays.toString(address.getAddress()));
	
		//根据机器名获得InetAddress实例
		InetAddress address2 = InetAddress.getByName("DESKTOP-QLSNNQ9");
		System.out.println("计算机名:"+address2.toString());
		System.out.println("IP地址:"+address2.getHostAddress());
	
		//根据IP获得InetAddress实例
		InetAddress address3 = InetAddress.getByName("192.168.0.1");
		System.out.println("计算机名:"+address3.toString());
		System.out.println("IP地址:"+address3.getHostAddress());
	}
}
