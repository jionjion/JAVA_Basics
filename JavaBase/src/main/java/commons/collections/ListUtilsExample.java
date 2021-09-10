package commons.collections;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.TransformerUtils;
import org.junit.Test;

/**
 * @author 14345 测试ListUtils类的常用方法
 */
public class ListUtilsExample {

	/** 判断传入的第一个列表是否为null,若果是则将第二个列表作为默认值返回,否则返回第一个列表 */
	@Test
	public void testDefaultIfNull() {
		List<String> list1 = null;
		List<String> list2 = new ArrayList<>();
		list2.add("a");
		list2.add("b");
		list2.add("c");
		// 如果list1为null,则返回list2的值
		List<String> result = ListUtils.defaultIfNull(list1,list2);
		System.out.println(result);
	}
	
	/** 判断穿入的列表是否为null,如果是则返回一个不可变长度的空列表,否则返回传入列表本身 */
	@Test
	public void testEmptyIfNull() {
		List<String> list1 = null;
		
		List<String> result = ListUtils.emptyIfNull(list1);
		System.out.println(result);
	}

	/** 传入一个列表,并将其列表内元素固定,禁止新增或者删除列表内元素 */
	@Test
	public void testFixedSizeList() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		List<String> result = ListUtils.fixedSizeList(list1);
		System.out.println(result);
		
	}
	
	/** 返回两个列表中的交集,如果元素多次重复,只返回一次 */
	@Test
	public void testIntersection() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("b");
		List<String> list2 = new ArrayList<>();
		list2.add("b");
		list2.add("b");
		list2.add("c");
		
		List<String> result = ListUtils.intersection(list1, list2);
		System.out.println(result);
	}
	
	/** 判断两个列表是否元素相同,列表顺序无关结果,只要列表个数,元素对象相同即可 */
	@Test
	public void testIsEqualList() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		List<String> list2 = new ArrayList<>();
		list2.add("a");
		list2.add("b");
		list2.add("c");
		boolean result = ListUtils.isEqualList(list1, list2);
		System.out.println(result);
	}
	
	/** 将列表根据指定的大小进行拆分,返回拆分后的列表的列表集合*/
	@Test
	public void testPartition() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("e");
		list1.add("f");
		list1.add("g");
		List<List<String>> result = ListUtils.partition(list1, 4);
		System.out.println(result);
	}	
	
	/** 从列表1中,移除全部列表2中出现的元素 */
	@Test
	public void testRemoveAll() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("c");
		
		List<String> list2 = new ArrayList<>();
		list2.add("b");
		list2.add("c");
		
		List<String> result = ListUtils.removeAll(list1, list2);
		System.out.println(result);
	}	
	
	/** 返回列表1和列表2的交集,如果元素多次重复,则返回多个  */
	@Test
	public void testRetainAll() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("c");
		list1.add("d");
		
		List<String> list2 = new ArrayList<>();
		list2.add("b");
		list2.add("c");
		
		List<String> result = ListUtils.retainAll(list1, list2);
		System.out.println(result);
	}
	
	/** 返回集合1和集合2之间的差集,如果集合1中相同元素大于集合2,则返回大于的个数的元素  */
	@Test
	public void testSubtract() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("c");
		list1.add("d");
		list1.add("d");
		
		List<String> list2 = new ArrayList<>();
		list2.add("b");
		list2.add("c");
		
		List<String> result = ListUtils.subtract(list1, list2);
		System.out.println(result);
	}
	
	/** 返回集合内元素的并集,如果元素出现多次,只返回一次 */
	@Test
	public void testSum() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		
		List<String> list2 = new ArrayList<>();
		list2.add("c");
		list2.add("d");
		
		List<String> result = ListUtils.sum(list1, list2);
		System.out.println(result);
	}
	
	/** 返回传入列表的同步列表,保证线程一致 */
	@Test
	public void testSynchronizedList() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		
		List<String> result = ListUtils.synchronizedList(list1);
		System.out.println(result);
	}
	
	/** 批量调用列表内对象的方法,并将调用结果返回为一个List */
	@Test
	public void testTransformedList() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		
		// "a".toUpperCase() 方法,无参数
		Transformer<String,String> transformer = TransformerUtils.invokerTransformer("toUpperCase");
		
		List<String> result = ListUtils.transformedList(list1,transformer);
		System.out.println(result);
	}
	
	/** 返回集合1和集合2的并集,如果集合内元素重复,则并集中出现多次 */
	@Test
	public void testUnion() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		
		List<String> list2 = new ArrayList<>();
		list1.add("b");
		list1.add("c");
		list1.add("d");
		
		List<String> result = ListUtils.union(list1, list2);
		System.out.println(result);
	}
	
}
