package xmlReadAndWriter.xmlRead.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**解析XML的Handler*/
public class SaxHandler extends DefaultHandler{

	
	/**开始解析xml*/
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("--------XML文件开始解析-------");
	}

	/**开始解析节点方法*/
	@Override			//qName:节点名	attributes:属性
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		System.out.println("-----节点:"+qName+"解析开始-----");
		//只有book标签有属性值.需要解析属性
		if (qName.equals("book")) {
			//遍历获取属性信息
			for (int i = 0; i < attributes.getLength(); i++) {
				String attributeName = attributes.getQName(i);		//遍历获取属性名
				String attributeValue = attributes.getValue(i);		//遍历获取属性值
//				String attributeValue = attributes.getValue("id");		//知道属性名,直接获取属性值
				System.out.println("节点:"+qName+"	属性名:"+attributeName+"	属性值:"+attributeValue);
			}
		}
		
		//解析只有只有文本的节点,即不是bookstore和book的节点
		if ( !qName.equals("bookstore") && !qName.equals("book") ) {
			String childNodeName = qName;
			System.out.print("节点:"+childNodeName);
		}
	}
	
	/**解析节点内的文本信息*/
	@Override			//ch:节点中的文本信息		start:开始的位置	length:文本的长度
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String childNodeValue = new String(ch, start, length);
		//SAX解析会将空格和换行解析为xml元素
		if (!"".equals(childNodeValue.trim())) {
			System.out.println("	节点值:"+childNodeValue);
		}
	}
	
	/**结束解析节点方法*/
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		//是否针对book节点结束
		System.out.println("-----节点:"+qName+"解析结束-----");	//每个节点结束后都触发
	}

	/**结束解析xml*/
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("--------XML文件结束解析-------");
	}


	
}
