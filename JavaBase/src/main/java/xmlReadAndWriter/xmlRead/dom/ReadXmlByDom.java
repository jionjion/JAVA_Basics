package xmlReadAndWriter.xmlRead.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**	使用Dom方式解析XML文件*/
public class ReadXmlByDom {

	public static void main(String[] args) throws Exception{
	
		//引入文件
		File file = new File("src/xmlReadAndWriter/xmlRead/Books.xml");
		
		//创建一个DocumentBuilderFactory对象
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		
		//创建一个DocumentBuilder对象
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		//解析XML文件,创建Document对象
		Document document = documentBuilder.parse(file);
		
		//解析Document对象
		//获得book节点.使用Dom方式解析可以获取任何我们感兴趣的节点,不需要层级关系
		NodeList bookLists = document.getElementsByTagName("book");	//返回的为一个节点list
		
		//遍历节点集合
		for (int i = 0; i < bookLists.getLength(); i++) {
			//解析每个book节点
			Node bookNode = bookLists.item(i);
			//节点名字
			String bookNodeName = bookNode.getNodeName();
			//获取book节点属性Map
			NamedNodeMap bookAttributes = bookNode.getAttributes();
			//遍历属性
			for (int j = 0; j < bookAttributes.getLength(); j++) {
				//莫得book节点每个属性对象
				Node attribute = bookAttributes.item(j);		//遍历每个属性
				//获得book节点每个属性
				String attributeName = attribute.getNodeName();		//获得属性名
//				String attributeValue = attribute.getNodeValue();	//互动属性值
				String attributeValue = ((Element) bookNode).getAttribute("id");	//将book节点强制换换为Element接口,其getAttribute("属性名")方法获取属性名对应的属性值
				System.out.println("节点:"+bookNodeName +"	属性名:"+attributeName+"	属性值:"+attributeValue);
			}
			
			//获得book节点的子节点,在解析时,空白也为一个节点.
			NodeList bookChildNodes = bookNode.getChildNodes();
			for (int k = 0; k < bookChildNodes.getLength(); k++) {
					Node bookChildNode = bookChildNodes.item(k);
				if (bookChildNode.getNodeType() == Node.ELEMENT_NODE) {	//如果为元素类型,则遍历
					String bookChildNodeName = bookChildNode.getNodeName();	//获得节点的名字
					String bookChildNodeValue = bookChildNode.getFirstChild().getNodeValue();	//默认节点的文本信息属于子节点内的值	
//					String bookChildNodeValue = bookChildNode.getTextContent();		//获得节点内的文本信息,仅限于获得纯文本的节点内容
					System.out.println("子节点:"+ bookChildNodeName+"	节点值:"+bookChildNodeValue);	//空白和换行符的为#text
				}
					
			}
		}
	}
}
