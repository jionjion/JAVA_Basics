package xmlReadAndWriter.xmlRead.jdom;

import java.io.File;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;


/**	使用Jdom方式解析XML文件*/
public class ReadXmlByJdom {

	public static void main(String[] args) throws Exception{
		//引入文件
		File xml = new File("src/xmlReadAndWriter/xmlRead/Books.xml");
		
		//创建SAXBuilder
		SAXBuilder saxBuilder = new SAXBuilder();
		//传入文件,创建Document对象
		Document document = saxBuilder.build(xml);
		//解析,生成根节点
		Element rootElement = document.getRootElement();
		//获得根节点下的子节点
		List<Element> childrenElements = rootElement.getChildren();
		//变量子节点
		for (Element children : childrenElements) {
			//节点名
			String childrenName = children.getName();
			//获得节点的属性
			List<Attribute> childrenAttributes = children.getAttributes();
			//变量属性集合
			for (Attribute childrenAttribute : childrenAttributes) {
				String childrenAttributeName  = childrenAttribute.getName(); //获得属性名
				String childrenAttributeValue  = childrenAttribute.getValue(); //获得属性值
				System.out.println("节点名:"+childrenName+"	属性:"+childrenAttributeName+"	属性值:"+childrenAttributeValue);
			}
			
			//获得子节点的子节
			List<Element> grandsonElements = children.getChildren();
			//遍历孙子节点
			for (Element grandsonElement : grandsonElements) {
				String grandsonElementName = grandsonElement.getName();
				String grandsonElementvalue = grandsonElement.getValue();
				System.out.println("孙子节点名: "+grandsonElementName+"	节点值: "+grandsonElementvalue);
			}
		}
	}
}
