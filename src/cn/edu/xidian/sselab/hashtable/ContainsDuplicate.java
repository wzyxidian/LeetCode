package cn.edu.xidian.sselab.hashtable;

import java.util.HashSet;
/**
 * title:Contains Duplicate
 * content:
 * Given an array of integers, find if the array contains any duplicates.
 *Your function should return true if any value appears at least twice in the array, 
 *and it should return false if every element is distinct. 
 */
public class ContainsDuplicate {

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
