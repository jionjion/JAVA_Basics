package commons.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.SetUtils.SetView;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 14345 SetView类,只读的set集合
 */
public class SetViewExample {

	
	// 正常集合
	private Set<String> set1;
	private Set<String> set2;

	// 只读集合
	private SetView<String> setView;
	
	@Before
	public void initDate() {
		set1 = new HashSet<>();
		set1.add("a");
		set1.add("b");
		set1.add("c");
		set2 = new HashSet<>();
		set2.add("A");
		set2.add("B");
		set2.add("C");
		
		// 创建一个不可以修改的SetView集合
		setView = new SetView<String>() {
			
			@Override
			protected Iterator<String> createIterator() {
				return set1.iterator();
			}
		};
	}
	
	/** 拷贝集合 */
	@Test
	public void testCopyInto() {
		Set<String> set = new HashSet<>() ;
		setView.copyInto(set);
		System.out.println(set);
	}
	
	/** 集合长度 */
	@Test
	public void testSize() {
		// 集合的长度
		System.out.println(setView.size());
	}
	
	/** 返回集合迭代器 */
	@Test
	public void testIterator() {
		// 返回一个迭代器,用于迭代元素
		Iterator<String> iterator = setView.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
	
	/** 返回一个可以修改的集合 */
	@Test
	public void testToSet() {
		Set<String> set = setView.toSet();
		System.out.println(set);
	}
}