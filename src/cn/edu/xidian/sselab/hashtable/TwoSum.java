package cn.edu.xidian.sselab.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author zhiyong wang
 * title:Two Sum
 * content:
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 *  where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2 
 *
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target){
		int length = nums.length;
		int[] indices = new int[2];
		for(int i=0;i<length-1;i++){
			for(int j=1;j<length;j++){
				if(i >= j){
					continue;
				}
				if(nums[i]+nums[j]==target && i<j){
					indices[0] = i + 1;
					indices[1] = j + 1;
				}				
			}
		}
		return indices;
	}
	

	public int[] twoSums(int[] nums, int target){
		int length = nums.length;
		int[] indices = new int[2];
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<length;i++){
			if(map.containsKey(target - nums[i])){				
				indices[0] = map.get(target-nums[i]);
				indices[1] = i + 1;
				return indices;
			}else{
				map.put(nums[i], i+1);
			}
		}
		return indices;
	}
	
}
