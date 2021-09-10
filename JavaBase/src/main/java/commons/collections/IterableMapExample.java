package commons.collections;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.HashedMap;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 14345
 *	IterableMap类的例子
 *	大部分方法继承自java.util.Map,这里不做演示
 *	部分方法继承自	org.apache.commons.collections4.Put
 *	部分方法继承自	org.apache.commons.collections4.IterableGet
 *	部分方法继承自	org.apache.commons.collections4.Get
 */
public class IterableMapExample {

	private IterableMap<String, String> iterableMap1;
	private IterableMap<String, String> iterableMap2;
	
	@Before
	public void initData() {
		iterableMap1 = new HashedMap<>();
		iterableMap1.put("a", "A");
		iterableMap1.put("b", "B");
		iterableMap1.put("c", "C");
		
		iterableMap2 = new HashedMap<>();
		iterableMap2.put("c", "C");
		iterableMap2.put("d", "D");
		iterableMap2.put("e", "E");
	}
	
	/*
	 * 	继承自org.apache.commons.collections4.Put中定义的方法 
	 */
	
	/** 调用Map.clean()方法,删除map中的全部元素 */
	@Test
	public void testClear() {
		iterableMap1.clear();
		System.out.println(iterableMap1);
	}
	
	/** 将元素放到映射中,并返回对象类型的值 */
	@Test
	public void testPut() {
		String result = (String) iterableMap1.put("a", "A");
		System.out.println(result);
	}
	
	/** 将集合全部放到 */
	@Test
	public void testPutAll() {
		iterableMap1.putAll(iterableMap2);
		System.out.println(iterableMap1);
	}
	
	/* org.apache.commons.collections4.IterableGet中定义的方法 */
	
	/** 调用迭代器迭代,可以在迭代中修改Map的映射值 */
	@Test
	public void testMapIterator() {
		MapIterator<String,String> iterator = iterableMap1.mapIterator();
		while (iterator.hasNext()) {
			// 下一个key
			String key = (String) iterator.next();
			// 获得当前的key
			String key2 = (String) iterator.getKey(); 
			String value = iterator.getValue();
			
			System.out.println("key:"   + key);
			System.out.println("key2:"  + key2);
			System.out.println("value:" + value);
			
			// 修改值,修改值只能在next()方法后和remove()前调用
			iterator.setValue(value + value);
			// 可以在迭代时修改数据
			if ("A".equals(value)) {
				// 删除值
				iterator.remove();
			}
		}
		// 修改后的Map
		System.out.println(iterableMap1);
	}
	
	
	/* org.apache.commons.collections4.Get中定义的方法 */
	
	/** 调用 Map.containsKey(Object) 判断集合是否包含指定Key */
	@Test
	public void testContainsKey() {
		boolean result = iterableMap1.containsKey("a");
		System.out.println(result);
	}

	/** 调用 Map.containsValue(Object) 判断集合是否包含指定Value  */
	@Test
	public void testContainsValue() {
		boolean result = iterableMap1.containsValue("A");
		System.out.println(result);
	} 

	/** 调用 Map.entrySet() 返回,具有map结构的集合 */
	@Test
	public void testEntrySet() {
		Set<Entry<String, String>> set = iterableMap1.entrySet();
		System.out.println(set);
	} 

	/** 调用 Map.get(Object) 返回key对应的值 */
	@Test
	public void testGet() {
		String result = iterableMap1.get("a");
		System.out.println(result);
	} 

	/** 调用 Map.isEmpty() 判断map是否为空map  */
	@Test
	public void testIsEmpty() {
		boolean result = iterableMap1.isEmpty();
		System.out.println(result);
	} 

	/** 调用 Map.keySet() 返回所有key的集合 */
	@Test
	public void testKeySet() {
		Set<String> set = iterableMap1.keySet();
		System.out.println(set);
	} 

	/** 调用 Map.remove(Object) 删除key对应的值,并将其返回 */
	@Test
	public void testRemove() {
		String result = iterableMap1.remove("a");
		System.out.println(result);
		System.out.println(iterableMap1);
	}
	
	/** 调用 Map.size() 返回map大小 */
	@Test
	public void testSize() {
		int result = iterableMap1.size();
		System.out.println(result);
	}
	
	/** 调用 Map.values() 返回map值的集合 */
	@Test
	public void testValues() {
		Collection<String> set = iterableMap1.values();
		System.out.println(set);
	} 
	
}
