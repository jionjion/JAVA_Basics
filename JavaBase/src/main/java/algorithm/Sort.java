package algorithm;

import java.util.Arrays;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 *	排序算法的实现
 */
public class Sort {

	/**
	 * 返回指定区间随机数和元素长度的数组
	 * @param start 前区间
	 * @param end	后区间
	 * @param num	数组长度
	 * @return		返回指定区间随机数和元素长度的数组
	 */
	public int[] getRandomArray(int start , int end , int num) {
		//随机数,以当前时间为随机种子
		Random random = new Random(System.currentTimeMillis());
		//随机数组长度指定
		int[] array = new int[num];
		//赋值随机数
		for(int i=0 ; i<num ; i++) {
			//随机数范围,差值+1,构成了前后闭区间
			array[i] = start + random.nextInt(end - start + 1);
		}
		return array;
	}
	
	private long startTime;
	private long endTime;
	
	@Before
	public void before() {
		startTime = System.nanoTime();
	}
	
	@After
	public void after() {
		endTime = System.nanoTime();
		System.out.println("算法用时:" + (endTime - startTime) + "纳秒!");
	}
	
	/* 
	*	O(n^2)的排序算法,时间和数量为平方关系
	*/
	
	/* 	选择排序算法,从小到大排序
	 * 	将当前数组中最小,交换第一个位置
	 * 	剩下部分中的最小,交换第二个位置
	 * 	剩下部分中的最小,交换第三个位置
	 */
	@Test
	public void selectSort() {
		int[] array = getRandomArray(0, 100, 100);
		for(int i=0 ; i<array.length ; i++ ) {
			//寻找[i,length]最小值的索引
			int minIndex = i;
			for(int j=i ; j<array.length ; j++) {
				if ( array[j] <= array[minIndex] ) {
					//最小值索引
					minIndex = j;
				}
			}
			//交换位置上的数字
			int swap = array[i];
			array[i] = array[minIndex];
			array[minIndex] = swap;
		}
		
		System.out.println("---选择排序法---");
		System.out.println(Arrays.toString(array));
	}
	
	/**	插入排序算法,从小到大排序,特别适合近乎有序的排序
	 * 	第一个元素不动.
	 * 	第二个元素和前面第一个比较,如果比较小,就插入到第一个前面
	 * 	第三个元素依次和前面第二个和第一个依次比较,如果比它们小,就交换位置
	 */
	@Test
	public void insertSort() {
		int[] array = getRandomArray(0, 100, 100);
		for(int i=1 ; i<array.length ; i++) {
			//寻找元素array[i]合适的插入位置
			for(int j=i ; j>0 ; j--) {
				if(array[j] < array[j-1]) {
					int swap = array[j];
					array[j] = array[j-1];
					array[j-1] = swap;
				} else {
					break;
				}
			}
		}
		System.out.println("---插入排序---");
		System.out.println(Arrays.toString(array));
	}

	/**	冒泡排序算法,从小到大排序
	 * 	将第一个元素与下一元素依次比较大小,如果前者比较大,则交换位置,依次浮动,直到到倒数第一个元素为止
	 * 	将第一个元素与下一元素依次比较大小,如果前者比较大,则交换位置,依次浮动,直到到倒数第二个元素为止
	 */
	@Test
	public void bubbleSort() {
		int[] array = getRandomArray(0, 100, 100);
        for(int i=0 ; i<array.length-1 ; i++) {
        	for(int j=0 ; j<array.length-1-i ; j++) {
        		if (array[j] >= array[j+1]) {
        			int swap = 0 ; 
        			swap = array[j];
        			array[j] = array[j+1];
        			array[j+1] = swap;
        		}
        	}
        }
        System.out.println("---冒泡排序---");
        System.out.println(Arrays.toString(array));
	}


	/*
	 * 	N log(N)的排序算法
	 */
	/**	归并排序
	 * 	
	 */
	public void mergeSort() {
		
	}
	
}
