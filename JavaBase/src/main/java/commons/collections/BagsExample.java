package commons.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 14345
 *	Bags 类的例子
 *	额外提供了对set的统计,计算类
 */
public class BagsExample {

	
	// 统计set出现的次数
	private Bag<String> bag = new HashBag<>();
	
	private Set<String> set = new HashSet<>();
	
	@Before
	public void initData() {
		// 1个A
		bag.add("A");
		// 2个B
		bag.add("B");
		bag.add("B");
		System.out.println(bag);
		System.out.println();
		
		// Set新增
		set.add("A");
		set.add("B");
	}
	
	/** 添加一个key,并将其计数+1 */
	@Test
	public void testAdd() {
		bag.add("C");
		System.out.println(bag);
	}
	
	/** 添加一个key,并将其计数增加 */
	@Test
	public void testAdd2() {
		bag.add("C", 5);
		System.out.println(bag);
	}
	
	/** 将Set集合添加到计数集合中进行计数 */
	@Test
	public void testAddAll() {
		bag.addAll(set);
		System.out.println(bag);
	}

	/** 清除当前集合 */
	@Test
	public void testClear() {
		bag.clear();
		System.out.println(bag);
	}

	/** 判断该元素是否在集合中出现.如果不在,则返回false */
	@Test
	public void testContains() {
		boolean result = bag.contains("AX");
		System.out.println(result);
	}
	
	/** 判断集合是否全部包含在当前统计中 */
	@Test
	public void testContainsAll() {
		boolean result = bag.containsAll(set);
		System.out.println(result);
	}


	/** 返回给定元素的出现次数,未出现返回0 */
	@Test
	public void testGetCount() {
		int result = bag.getCount("A");
		System.out.println(result);
	}
	

	/** 判断当前集合是否为null */
	@Test
	public void	testIsEmpty() {
		boolean result = bag.isEmpty();
		System.out.println(result);
	}

	/** 返回一个迭代器,迭代集合内每一个元素,如果元素出现多次,则迭代多次 */
	@Test
	public void testIterator() {
		Iterator<String> iterator = bag.iterator();
		while (iterator.hasNext()) {
			String str = (String) iterator.next();
			System.out.println(str);
		}
	}

	/** 删除指定元素,无论该元素出现几次,均删除 */
	@Test
	public void testRemove() {
		bag.remove("B");
		System.out.println(bag);
	}

	/** 删除指定元素出现次数,如果元素删除后次数小于0,则删除元素本身 */
	@Test
	public void testRemove2() {
		bag.remove("B", 2);
		System.out.println(bag);
	}

	/** 将穿入Set的元素,均在计数集合中自减一次计数 */
	@Test
	public void testRemoveAll() {
		bag.removeAll(set);
		System.out.println(bag);
	}

	/** 删除所有未在传入set集合中出现的元素及其次数,使其剩下次数为1 */
	@Test
	public void testRetainAll() {
		set.remove("A"); // 仅剩B
		bag.retainAll(set);
		System.out.println(bag);
	}
	

	/** 返回当前计数集合的总次数,如果出现多次,则计数多次 */
	@Test
	public void testSize() {
		int result = bag.size();
		System.out.println(result);
	}

	
	/** 将计数集合内的成员作为对象数组返回,如果成员出现多次,则返回多次 */
	@Test
	public void testToArray() {
		Object[] result = bag.toArray();
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	/** 将计数集合内的成员作为指定数据结构数组返回,如果成员出现多次,则返回多次 */
	@Test
	public void testToArray2() {
		String[] result = bag.toArray(new String[bag.size()]);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	/** 返回集合中,所有的元素,每个元素只出现一次 */
	@Test
	public void testUniqueSet() {
		Set<String> set = bag.uniqueSet();
		System.out.println(set);
	}
	
	
}
