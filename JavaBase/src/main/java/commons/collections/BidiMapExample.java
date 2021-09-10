package commons.collections;

import java.util.Set;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 14345
 *	BidiMap 类的例子
 *	可以通过key寻找value,也可以通过value寻找key
 *	要求Key-Value一一对应,否则如果key或者value重复,只会保存最后一个结果
 */
public class BidiMapExample {

	BidiMap<String, String> bidiMap = new DualHashBidiMap<>();
	
	@Before
	public void initDate() {
		// 如果key已经存在,或者value已经存在,则会只保存最后一对
		bidiMap.put("a", "A");
		bidiMap.put("b", "B");
		bidiMap.put("c", "C");
	}
	
	
	
	
	/** 根据Value获得对应的Key */
	@Test
	public void testGetKey() {
		String result = bidiMap.getKey("A");
		System.out.println(result);
	}

	
	/** 将Key-Value进行反转 */
	@Test
	public void testInverseBidiMap() {
		BidiMap<String, String> result = bidiMap.inverseBidiMap();
		System.out.println(result);
	}
	
	/** 存入新的Key-Value,如果有任何重复,则替换原有的 */
	@Test
	public void testPut() {
		bidiMap.put("a", "AA");
		bidiMap.put("bb","B");
		System.out.println(bidiMap);
	}
	
	/** 根据Value删除对应的key-value对 */
	@Test
	public void testRemoveValue() {
		bidiMap.removeValue("A");
		System.out.println(bidiMap);
	}
	
	/** 获得key对应的set集合 */
	@Test
	public void	testValues() {
		Set<String> set = bidiMap.values();
		System.out.println(set);
	}
}
