package javaEail.until;

import java.util.UUID;


/**随机生成UUID无序数字*/
public class UUIDUntil {

	public String getUUID() {
		UUID uuid = UUID.randomUUID();			//72cf6662-f5de-4450-b3c2-0fd32536ef4e
		String id = uuid.toString().replace("-", "");
		System.out.println(id);					//d74f5f91241241a787984507d059c302
		return id;
	}
}
