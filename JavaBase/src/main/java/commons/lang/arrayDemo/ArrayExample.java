package commons.lang.arrayDemo;

import java.util.Objects;

import org.apache.commons.lang3.ArrayUtils;

/**
 *	数组工具类的使用 	
 *	对Arrays类的扩展
 * @author JionJion
 */
public class ArrayExample {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
	
		// 通过{ }创建数组
		int[] nums1 = { 1, 2, 3, 4, 5, 6 };    
        // 通过常量创建新数组    int[0],0长度的int数组
        int[] nums2 = ArrayUtils.EMPTY_INT_ARRAY;    
   
        // 比较两个数组是否相等    
        Objects.deepEquals(nums1, nums2);    
   
        // 输出数组,第二参数为数组为空时输出提示    
        ArrayUtils.toString(nums1, "array is null");    
   
        // 克隆新数组,注意此拷贝为深拷贝    
        int[] nums3 = ArrayUtils.clone(nums1);    
   
        // 截取数组 
        ArrayUtils.subarray(nums1, 1, 2);    
   
        // 判断两个数组长度是否相等    
        ArrayUtils.isSameLength(nums1, nums2);    
   
        // 判断两个数组类型是否相等,注意int和Integer比较时不相等    
        ArrayUtils.isSameType(nums1, nums2);    
   
        // 反转数组    
        ArrayUtils.reverse(nums1);    
   
        // 查找数组元素位置    
        ArrayUtils.indexOf(nums1, 5);    
   
        // 查找数组元素最后出现位置    
        ArrayUtils.lastIndexOf(nums1, 4);    
   
        // 查找元素是否存在数组中    
        ArrayUtils.contains(nums1, 2);    
   
        // 将基本数组类型转为包装类型    
        Integer[] nums4 = ArrayUtils.toObject(nums1);    
   
        // 判断是否为空,length=0或null都属于    
        ArrayUtils.isEmpty(nums1);    
   
        // 并集操作,合并数组    
        ArrayUtils.addAll(nums1, nums2);    
   
        // 增加元素,在下标5中插入10,注意此处返回是新数组    
        ArrayUtils.add(nums1, 5, 10);    
   
        // 删除指定位置元素,注意返回新数组,删除元素后面的元素会前移,保持数组有序    
        ArrayUtils.remove(nums1, 5);    
   
        // 删除数组中值为10的元素,以值计算不以下标    
        ArrayUtils.removeElement(nums1, 10);    
    }    
}
