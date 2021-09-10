package commons.collections;

import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.map.LinkedMap;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 14345
 *	OrderedMap 类的例子
 *	继承自 org.apache.commons.collections4.IterableMap 有父类大部分方法,并提供特有的方法
 */
public class OrderedMapExample {

	
	private OrderedMap<String, String> orderedMap;
	
	@Before
	public void initData() {
		orderedMap = new LinkedMap<String, String>();
		orderedMap.put("a", "A");
		orderedMap.put("b", "B");
		orderedMap.put("c", "C");
		orderedMap.put("d", "D");
	}
	
	/** 有序的Map */
	@Test
	public void test() {
		System.out.println(orderedMap);
	}
	
	/** 获得第一个key */
	@Test
	public void testFirstKey() {
		String key = orderedMap.firstKey();
		System.out.println(key);
	}
	
	/** 获得最后一个key */
	@Test
	public void testLastKey() {
		String key = orderedMap.lastKey();
		System.out.println(key);		
	}
	
	/** 获得一个迭代器 */
	@Test
	public void testMapIterator() {
		OrderedMapIterator<String, String> iterator = orderedMap.mapIterator();
		// 迭代,存在下一个
		while (iterator.hasNext()) {
			// 获得Key
			String key = iterator.next();
			// 获得key
			String key2 = iterator.getKey();
			// 获得key对应得值
			String value = iterator.getValue();
			// 更新值
			iterator.setValue(value + value);
			//存在前一个
			if(iterator.hasPrevious()) {
				// 删除值
				iterator.remove();
			}
		}
		System.out.println(orderedMap);
	}
	
	/** 获得指定key的下一个 key */
	@Test
	public void testNextKey() {
		String key = orderedMap.nextKey("b");
		System.out.println(key);
	}

	/** 获得指定key的前一个key */
	@Test
	public void testPreviousKey(){
		String key = orderedMap.previousKey("b");
		System.out.println(key);
	}
	
}
