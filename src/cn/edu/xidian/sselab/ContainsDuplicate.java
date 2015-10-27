package cn.edu.xidian.sselab;

import java.util.HashSet;
/**
 * title:Contains Duplicate
 * content:
 * Given an array of integers, find if the array contains any duplicates.
 *Your function should return true if any value appears at least twice in the array, 
 *and it should return false if every element is distinct. 
 */
public class ContainsDuplicate {

	/**
	 * @author wzy
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{12,2,3,4};
		ContainsDuplicate cd = new ContainsDuplicate();
		long t1 = System.currentTimeMillis();
		cd.containsDuplicate(nums);
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		
	}

	//这道题判断一个数组中是否存在两个相同的值
	//为了使时间复杂度比较低，可以达到O(n)的程度，这里可以将取出来的值放到HashSet，Hashtable，ArrayList等中，
	//因为这些容器内置了contains方法，之用调用他们的接口就可以进行判断是否有相同的存在
	//对数组进行遍历，将里面的数值放到容器中，然后判断是否相同的值，要注意这里是先判断后存放
	public boolean containsDuplicate(int[] nums){	
		int len = nums.length;
		HashSet<Integer> temp = new HashSet<Integer>();
		for(int i=0;i<len;i++){			
			if(temp.contains(nums[i]))
				return true;
			temp.add(nums[i]);
		}
		return false;
	}
}
