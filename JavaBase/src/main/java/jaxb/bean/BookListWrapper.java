package jaxb.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 	通过静态内部类,完成对多个javaBean转为xml
 */

// 根节点
@XmlRootElement(name = "books")
public class BookListWrapper {

	// 私有属性,不支持@XmlElement注解
	private String bookcase;
	
	// 可以注解在get()
	@XmlElement(name="bookcase")
	public String getBookcase() {
		return bookcase;
	}

	public void setBookcase(String bookcase) {
		this.bookcase = bookcase;
	}



	// 子节点们
	private List<book> books;
	
	// 
	public List<book> getBooks() {
		return books;
	}

	// 也可以注解在set()
	@XmlElement(name="book")
	// 被<list>标签,包裹列表
	@XmlElementWrapper(name = "list")
	public void setBooks(List<book> books) {
		this.books = books;
	}




	/** 内部类 */
	public static class book {
		private String name;

		private String author;

		private Double price;

		public book() {
			super();
		}
		
		public book(String name, String author, Double price) {
			super();
			this.name = name;
			this.author = author;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}
	}
}
