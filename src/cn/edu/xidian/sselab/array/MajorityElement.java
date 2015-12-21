package cn.edu.xidian.sselab.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author zhiyong wang
 * title: Majority Element
 * content:
 * 		Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * 		You may assume that the array is non-empty and the majority element always exist in the array.
 *
 */
public class MajorityElement {

	//从头开始遍历数组中所有的数，用一个HashMap记录每个数字及数字出现的次数，选出次数大于数组个数一半的数值
	public int majorityElement(int[] nums){
		int length = nums.length;
		int result = nums[0];
		Map<Integer,Integer> times = new HashMap<Integer,Integer>();
		for(int i=0;i<length;i++){
			if(times.containsKey(nums[i])){
				int time = times.get(nums[i]) + 1;
				if(time >= length / 2){
					result = nums[i];
					break;
				}
				times.put(nums[i], time);
			}else{
				times.put(nums[i], 0);
			}
		}
		return result;
	}
	
	//从leetcode学习的方法，非常巧妙，调用Arrays自动排序接口，因为搜求结果一定会大于一半，所以中间的数值一定就是所求的值
	public int majorityElement1(int[] nums){
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
	
}
