package commons.collections;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.IterableSortedMap;
import org.apache.commons.collections4.MapUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 14345
 *	MapUtils 类的例子
 */
public class MapUtilsExample {

	private Map<String, Object> map1 = new HashMap<>();
	private Map<String, Object> map2 = new TreeMap<>();
	
	/** 初始化数据 */
	@Before
	public void initData() {
		map1.put("string", "ABC");
		map1.put("short", 1);
		map1.put("byte", 1);
		map1.put("int", 123);
		map1.put("float", 1.23F);
		map1.put("double", 1.23D);
		map1.put("long", 123L);
		map1.put("boolean", true);
		map1.put("map", map2);

		map2.put("string", "ABC");
		map1.put("short", 1);
		map2.put("byte", 1);
		map2.put("int", 123);
		map2.put("float", 1.23F);
		map2.put("double", 1.23D);
		map2.put("long", 123L);
		map2.put("boolean", true);
	}
	
	/** 格式化打印  */
	@Test
	public void testDebugPrint() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream outPrint = new PrintStream(out);
		MapUtils.debugPrint(outPrint, "Print Map", map1);
		String EXPECTED_OUT = out.toString();
		System.out.println(EXPECTED_OUT);
	}

	/** 判断map是否为null,如是null,则返回一个空map,否则返回参数本身  */
	@Test
	public void	testEmptyIfNull(){
		Map<String,Object> result = MapUtils.emptyIfNull(map1);
		System.out.println(result);
	}

	/** 返回传入map的对应固定map */
	@Test
	public void testFixedSizeMap(){
		IterableMap<String, Object> result = MapUtils.fixedSizeMap(map1);
		System.out.println(result);
	}

	/**返回传入有序map对应的固定map */
	@Test
	public void	testFixedSizeSortedMap() {
		 SortedMap<String,Object> result = MapUtils.fixedSizeSortedMap((SortedMap<String, Object>) map2);
		 System.out.println(result);
	}
	
	/** 返回map中key对应的Boolean包装类的值,如果不存在则返回null */
	@Test
	public void testGetBoolean() {
		Boolean result = MapUtils.getBoolean(map1, "boolean");
		System.out.println(result);
	}

	/** 返回map中key对应的Boolean包装类的值,如果不存在则返回默认值 */
	@Test
	public void testGetBoolean2() {
		Boolean result = MapUtils.getBoolean(map1, "boolean", false);
		System.out.println(result);
	}

	/** 返回map中key对应的boolean类型的值,如果不存在则返回false */
	@Test
	public void	testGetBooleanValue() {
		boolean result = MapUtils.getBooleanValue(map1, "booleanX");
		System.out.println(result);
	}

	/** 返回map中key对应的boolean类型的值,如果不存在则返回默认值 */
	@Test
	public void	testGetBooleanValue2() {
		boolean result = MapUtils.getBooleanValue(map1, "boolean",false);
		System.out.println(result);
	}

	/** 返回map中key对应的Byte包装类的值,如果不存在则返回null */
	@Test
	public void testGetByte() {
		Byte result = MapUtils.getByte(map1, "bytes");
		System.out.println(result);
	}

	/** 返回map中key对应的Byte包装类的值,如果不存在则返回默认值 */
	@Test
	public void	testGetByte2() {
		Byte result = MapUtils.getByte(map1, "byte",(byte) 0);
		System.out.println(result);		
	}

	/** 返回map中key对应的byte类型的值,如果不存在则返回0 */
	@Test
	public void	testGetByteValue() {
		byte result = MapUtils.getByteValue(map1, "byteX");
		System.out.println(result);
	}

	/** 返回map中key对应的byte类型的值,如果不存在则返回默认值 */
	@Test
	public void	testGetByteValue2() {
		byte result = MapUtils.getByteValue(map1, "byte", (byte)0);
		System.out.println(result);
	}

	/** 返回map中key对应的Double包装类的值,如果不存在则返回null */
	@Test
	public void testGetDouble() {
		Double result = MapUtils.getDouble(map1, "double");
		System.out.println(result);
	}

	/** 返回map中key对应的Double包装类的值,如果不存在则返回默认值 */
	@Test
	public void	testGetDouble2() {
		Double result = MapUtils.getDouble(map1, "double", 3.21D);
		System.out.println(result);
	}

	/** 返回map中key对应的double类型的值,如果不存在则返0.0 */
	@Test
	public void testGetDoubleValue() {
		double result = MapUtils.getDoubleValue(map1, "doubleX");
		System.out.println(result);
	}

	/** 返回map中key对应的double类型的值,如果不存在则返回默认值 */
	@Test
	public void testGetDoubleValue2() {
		double result = MapUtils.getDoubleValue(map1, "doubleX", 3.21D);
		System.out.println(result);
	}

	/** 返回map中key对应的Float包装类的值,如果不存在则返回null */
	@Test
	public void	testGetFloat() {
		Float result = MapUtils.getFloat(map1, "float");
		System.out.println(result);
	}

	/** 返回map中key对应的Float包装类的值,如果不存在则返回默认值 */
	@Test
	public void	testGetFloat2() {
		Float result = MapUtils.getFloat(map1, "float", 3.21F);
		System.out.println(result);
	}

	/** 返回map中key对应的float类型的值,如果不存在则返回 0.0 */
	@Test
	public void testGetFloatValue() {
		float result = MapUtils.getFloatValue(map1, "floatX");
		System.out.println(result);
	}

	/** 返回map中key对应的float类型的值,如果不存在则返回默认值 */
	@Test
	public void testGetFloatValue2() {
		float result = MapUtils.getFloatValue(map1, "floatX", 3.21F);
		System.out.println(result);
	}

	/** 返回map中key对应的Integer包装类的值,如果不存在则返回null */
	@Test
	public void testGetInteger() {
		Integer result = MapUtils.getInteger(map1, "int");
		System.out.println(result);
	}

	/** 返回map中key对应的Integer包装类的值,如果不存在则返回默认值 */
	@Test
	public void testGetInteger2() {
		Integer result = MapUtils.getInteger(map1, "int", 0);
		System.out.println(result);
	}

	/** 返回map中key对应的int类型的值,如果不存在则返回0值 */
	@Test
	public void	testGetIntValue() {
		int result = MapUtils.getIntValue(map1, "intX");
		System.out.println(result);
	}

	/** 返回map中key对应的int类型的值,如果不存在则返回默认值 */
	@Test
	public void	testGetIntValue2() {
		int result = MapUtils.getIntValue(map1, "intX", 0);
		System.out.println(result);		
	}

	/** 返回map中key对应的Long包装类的值,如果不存在则返回null */
	@Test
	public void	testGetLong() {
		Long result = MapUtils.getLong(map1, "long");
		System.out.println(result);
	}

	/** 返回map中key对应的Long包装类的值,如果不存在则返回默认值 */
	@Test
	public void	testGetLong2() {
		Long result = MapUtils.getLong(map1, "long", 321L);
		System.out.println(result);
	}

	/** 返回map中key对应的long类型的值,如果不存在则返回默认值 */
	@Test
	public void	testGetLongValue() {
		long result = MapUtils.getLongValue(map1, "longX");
		System.out.println(result);
	}

	/** 返回map中key对应的long类型的值,如果不存在则返回默认值 */
	@Test
	public void testGetLongValue2() {
		long result = MapUtils.getLongValue(map1, "longX", 0L);
		System.out.println(result);
	}

	/** 返回map中key嵌套的Map集合,如果不存在,返回null */
	@Test
	public void	testGetMap() {
		Map<?, ?> result = MapUtils.getMap(map1, "map");
		System.out.println(result);
	}

	/** 返回map中key嵌套的Map集合,如果不存在,返回默认值 */
	@Test
	public void	testGetMap2() {
		Map<?, ?> result = MapUtils.getMap(map1, "mapX", map2);
		System.out.println(result);		
	}

	/** 返回map中key对应的Long包装类的值,如果不存在则返回null */
	@Test
	public void	testGetNumber() {
		Number result = MapUtils.getNumber(map1, "int");
		System.out.println(result);
	}

	/** 返回map中key对应的Long包装类的值,如果不存在则返回默认值 */
	@Test
	public void	testGetNumber2() {
		Number result = MapUtils.getNumber(map1, "intX", 0);
		System.out.println(result);
	}

	/** 返回map中key对应的Object类的值,如果不存在则返回null */
	@Test
	public void	testGetObject() {
		Object result = MapUtils.getObject(map1, "string");
		System.out.println(result);
	}
	
	/** 返回map中key对应的Object类的值,如果不存在则返回默认值 */
	@Test
	public void	testGetObject2() {
		Object result = MapUtils.getObject(map1, "stringX", "None");
		System.out.println(result);
	}

	/** 返回map中key对应的Short包装类的值,如果不存在则返回null */
	@Test
	public void	testGetShort() {
		Short result = MapUtils.getShort(map1, "short");
		System.out.println(result);
	}

	/** 返回map中key对应的Short包装类的值,如果不存在则返回默认值 */
	@Test
	public void	testGetShort2() {
		Short result = MapUtils.getShort(map1, "short", (short) 0);
		System.out.println(result);
	}

	/** 返回map中key对应的short类型的值,如果不存在则返回0 */
	@Test
	public void testGetShortValue() {
		short result = MapUtils.getShortValue(map1, "shortX");
		System.out.println(result);
	}

	/** 返回map中key对应的short类型的值,如果不存在则返回默认值 */
	@Test
	public void	testGetShortValue2() {
		short result = MapUtils.getShortValue(map1, "shortX", (short)0);
		System.out.println(result);
	}

	/** 返回map中key对应的String类的值,如果不存在则返回null */
	@Test
	public void	testGetString() {
		String result = MapUtils.getString(map1, "string");
		System.out.println(result);
	}

	/** 返回map中key对应的String类的值,如果不存在则返回默认值 */
	@Test
	public void	testGetString2() {
		String result = MapUtils.getString(map1, "string","None");
		System.out.println(result);
	}

	
	/** 返回一个新的HashMap,包含传入的map的所有元素 */ 
	@Test
	public void	testInvertMap(){
		Map<Object, String> map = MapUtils.invertMap(map1);
		System.out.println(map);
	}

	/** 判断是否为空map */
	@Test
	public void	testIsEmpty() {
		boolean result = MapUtils.isEmpty(map1);
		System.out.println(result);
	}

	/** 判断是否为不是空map */
	@Test
	public void	testIsNotEmpty() {
		boolean result = MapUtils.isNotEmpty(map1);
		System.out.println(result);
	}

	/** 获得一个IterableMap类,便于迭代 */
	@Test
	public void	testIterableMap() {
		IterableMap<String, Object> iterableMap = MapUtils.iterableMap(map1);
		System.out.println(iterableMap);
	}

	/*

	/** 获得一个IterableSortedMap类,便于迭代 */ 
	@Test
	public void	testIterableSortedMap() {
		IterableSortedMap<String, Object> iterableSortedMap = MapUtils.iterableSortedMap((SortedMap<String, Object>) map2);
		System.out.println(iterableSortedMap);
	}

	/**

	//Returns a "lazy" map whose values will be created on demand.
	public <K,V> IterableMap<K,V>	lazyMap(Map<K,V> map, Factory<? extends V> factory)

	//Returns a "lazy" map whose values will be created on demand.
	public <K,V> IterableMap<K,V>	lazyMap(Map<K,V> map, Transformer<? super K,? extends V> transformerFactory)

	//Returns a "lazy" sorted map whose values will be created on demand.
	public <K,V> SortedMap<K,V>	lazySortedMap(SortedMap<K,V> map, Factory<? extends V> factory)

	//Returns a "lazy" sorted map whose values will be created on demand.
	public <K,V> SortedMap<K,V>	lazySortedMap(SortedMap<K,V> map, 
	Transformer<? super K,? extends V> transformerFactory)

	//Deprecated. 
	//since 4.1, use MultiValuedMap instead
	public <K,V> MultiValueMap<K,V>	multiValueMap(Map<K,? super Collection<V>> map)

	//Deprecated. 
	//since 4.1, use MultiValuedMap instead
	public <K,V,C extends Collection<V>>
	MultiValueMap<K,V>	multiValueMap(Map<K,C> map, Class<C> collectionClass)

	//since 4.1, use MultiValuedMap instead
	//Deprecated. 
	public <K,V,C extends Collection<V>>
	MultiValueMap<K,V>	multiValueMap(Map<K,C> map, Factory<C> collectionFactory)

	//Returns a map that maintains the order of keys that are added backed by the given map.
	public <K,V> OrderedMap<K,V>	orderedMap(Map<K,V> map)

	//Populates a Map using the supplied Transformers to transform the elements into keys and values.
	public <K,V,E> void	populateMap(Map<K,V> map, Iterable<? extends E> elements, Transformer<E,K> keyTransformer, Transformer<E,V> valueTransformer)

	//Populates a Map using the supplied Transformer to transform the elements into keys, using the unaltered element as the value in the Map.
	public <K,V> void	populateMap(Map<K,V> map, Iterable<? extends V> elements, Transformer<V,K> keyTransformer)

	//Populates a MultiMap using the supplied Transformers to transform the elements into keys and values.
	public <K,V,E> void	populateMap(MultiMap<K,V> map, Iterable<? extends E> elements, Transformer<E,K> keyTransformer, Transformer<E,V> valueTransformer)

	//Populates a MultiMap using the supplied Transformer to transform the elements into keys, using the unaltered element as the value in the MultiMap.
	public <K,V> void	populateMap(MultiMap<K,V> map, Iterable<? extends V> elements, Transformer<V,K> keyTransformer)

	//Returns a predicated (validating) map backed by the given map.
	public <K,V> IterableMap<K,V>	predicatedMap(Map<K,V> map, Predicate<? super K> keyPred, Predicate<? super V> valuePred)

	//Returns a predicated (validating) sorted map backed by the given map.
	public <K,V> SortedMap<K,V>	predicatedSortedMap(SortedMap<K,V> map, Predicate<? super K> keyPred, Predicate<? super V> valuePred)

	//Puts all the keys and values from the specified array into the map.
	public <K,V> Map<K,V>	putAll(Map<K,V> map, Object[] array)

	//Protects against adding null values to a map.
	public <K> void	safeAddToMap(Map<? super K,Object> map, K key, Object value)

	//Gets the given map size or 0 if the map is null
	public int	size(Map<?,?> map)

	//Returns a synchronized map backed by the given map.
	public <K,V> Map<K,V>	synchronizedMap(Map<K,V> map)

	//Returns a synchronized sorted map backed by the given sorted map.
	public <K,V> SortedMap<K,V>	synchronizedSortedMap(SortedMap<K,V> map)

	//Creates a new HashMap using data copied from a ResourceBundle.
	public Map<String,Object>	toMap(ResourceBundle resourceBundle)

	//Gets a new Properties object initialised with the values from a Map.
	public <K,V> Properties	toProperties(Map<K,V> map)

	//Returns a transformed map backed by the given map.
	public <K,V> IterableMap<K,V>	transformedMap(Map<K,V> map, Transformer<? super K,? extends K> keyTransformer, Transformer<? super V,? extends V> valueTransformer)

	//Returns a transformed sorted map backed by the given map.
	public <K,V> SortedMap<K,V>	transformedSortedMap(SortedMap<K,V> map, Transformer<? super K,? extends K> keyTransformer, Transformer<? super V,? extends V> valueTransformer)

	//Returns an unmodifiable map backed by the given map.
	public <K,V> Map<K,V>	unmodifiableMap(Map<? extends K,? extends V> map)

	//Returns an unmodifiable sorted map backed by the given sorted map.
	public <K,V> SortedMap<K,V>	unmodifiableSortedMap(SortedMap<K,? extends V> map)

	//Prints the given map with nice line breaks.
	public void	verbosePrint(PrintStream out, Object label, Map<?,?> map)

	 */	
}
