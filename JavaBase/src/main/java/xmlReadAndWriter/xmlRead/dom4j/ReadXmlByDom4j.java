package xmlReadAndWriter.xmlRead.dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**	使用Dom4j方式解析XML文件*/
public class ReadXmlByDom4j {

	public static void main(String[] args) throws Exception{

		//引入文件
		File xml = new File("src/xmlReadAndWriter/xmlRead/Books.xml");
		//创建SAXReader对象
		SAXReader saxReader = new SAXReader();
		//加载XML,生成Document对象
		Document document = saxReader.read(xml);
		//获得根节点
		Element rootElement = document.getRootElement();
		//获得根节点下的子节点
		Iterator<Element> childrenIterator = rootElement.elementIterator();
		//遍历迭代器
		while (childrenIterator.hasNext()) {
			//获得book的节点
			Element childrenElement = (Element) childrenIterator.next();
			//获得book节点的节点名
			String childrenElementName = childrenElement.getName();
			//获得属性集合
			List<Attribute> childrenAttributes = childrenElement.attributes();
			//遍历属性集合
			for (Attribute childrenAttribute : childrenAttributes) {
				String childrenAttributeName = childrenAttribute.getName();
				String childrenAttributeValue = childrenAttribute.getValue();
				System.out.println("节点:"+childrenElementName+"	属性名:"+childrenAttributeName+"	属性值:"+childrenAttributeValue);
			}
			//解析book节点的子节点
			Iterator<Element> grandsonIterator = childrenElement.elementIterator();
			while (grandsonIterator.hasNext()) {
				Element grandsonElement = (Element) grandsonIterator.next();
				String grandsonName = grandsonElement.getName();
				String grandsonValue = grandsonElement.getText();
				System.out.println("节点名:"+grandsonName+"	节点值:"+grandsonValue);
			}
		}
	}
}
