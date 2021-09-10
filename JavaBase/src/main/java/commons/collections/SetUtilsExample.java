package commons.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

import org.apache.commons.collections4.SetUtils;
import org.apache.commons.collections4.SetUtils.SetView;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 14345
 *	SetUtils类常用的方法
 */
public class SetUtilsExample {

	Set<String> set1;
	Set<String> set2;
	
	@Before
	public void initData() {
		// 考虑Hash是根据地址信息判断对象是否相同
		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		String e = "e";
		
		set1 = new HashSet<String>();
		set1.add(a);
		set1.add(b);
		set1.add(c);
		
		set2 = new HashSet<String>();
		set2.add(c);
		set2.add(d);
		set2.add(e);
		
	}
	
	/** 集合1 和 集合2 的 差集  */
	@Test
	public void testDifference() {
		SetView<String> setView = SetUtils.difference(set1, set2);
		System.out.println(setView);
	}
	
	/** 集合1 - 集合2 的差集 */
	@Test
	public void testDisjunction() {
		SetView<String> setView = SetUtils.disjunction(set1, set2);
		System.out.println(setView);
	}
	
	/** 判断集合是否为null,如果集合为null,返回一个新的长度为0的不可变集合,否则返回原来的集合 */
	@Test
	public void testEmptyIfNull() {
		Set<String> set = SetUtils.emptyIfNull(set1);
		System.out.println(set);
	}
	
	/** 清空传入的集合,并返回 */
	@Test
	public void testEmptySet() {
		Set<String> set = SetUtils.emptySet();
		System.out.println(set);
	}
	
	/** 获得一个空的,不可修改的排序集合 */
	@Test
	public void testEmptySortedSet() {
		Set<String> set = SetUtils.emptySortedSet();
		System.out.println(set);
	}
	
	/** 使用set1.hashCode()指定的方法,生成重新生成set集合 */
	@Test
	public void testHashCodeForSet() {
		int result =  SetUtils.hashCodeForSet(set1);
		System.out.println(result);
	}
	
	/** 使用给定的类型创建一个新的集合 */
	@Test
	public void testHashSet() {
		Set<String> set = SetUtils.hashSet("a","b","c");
		System.out.println(set);
	}
	
	/** 求两个集合中的交集,返回一个不可变的集合. */
	@Test
	public void testIntersection() {
		SetView<String> setView = SetUtils.intersection(set1, set2);
		System.out.println(setView);
	}
	
	/** 判断两个集合是否完全相同 */
	@Test
	public void testIsEqualSet() {
		boolean result = SetUtils.isEqualSet(set1, set2);
		System.out.println(result);
	}
	
	/** 返回一个新的哈希集，该哈希集与基于==Not Equals（）的元素匹配。 */
	@Test
	public void testNewIdentityHashSet() {
		Set<String> set = SetUtils.newIdentityHashSet();
		set.add("a");
		System.out.println(set);
	}
	
	/** 将传入的Set集合包装为ListOrderedSet,维护集合内元素的顺序 */
	@Test
	public void testOrderedSet() {
		Set<String> set = SetUtils.orderedSet(set1);
		set.add("e");
		System.out.println(set);
	}
	
	/** 返回一个线程安全的集合 */
	@Test
	public void testSynchronizedSet() {
		Set<String> set = SetUtils.synchronizedSet(set1); 
		System.out.println(set);
	}
	
	/** 返回一个线程安全的排序集合 */
	@Test
	public void testSynchronizedSortedSet() {
		Set<String> set = SetUtils.synchronizedSortedSet((SortedSet<String>) set1);
		System.out.println(set);
	}
	
	/** 求两个集合的并集,并返回一个不可变的集合 */
	@Test
	public void testUnion() {
		SetView<String> setView = SetUtils.union(set1, set2);
		System.out.println(setView);
	}
	
	/** 根据传入项目,返回一个不可变的集合 */
	@Test
	public void testUnmodifiableSet() {
		Set<String> setView = SetUtils.unmodifiableSet("a","b","c","d");
		System.out.println(setView);
	}
	
	/** 根据传入的排序集合,返回一个不可以修改的集合 */
	@Test
	public void testUnmodifiableSortedSet() {
		Set<String> set = SetUtils.unmodifiableSortedSet((SortedSet<String>) set1);
		System.out.println(set);
	}
	
	
	
	
	
	
}