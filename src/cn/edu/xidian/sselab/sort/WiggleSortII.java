package cn.edu.xidian.sselab.sort;

/**
 * 
 * @author zhiyong wang
 * title: Wiggle Sort II
 * content:
 *  Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *  
 *  Example:
 *  (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 *  (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 *  
 *  Note:
 *  You may assume all input has valid answer.
 *  
 *  Follow Up:
 *  Can you do it in O(n) time and/or in-place with O(1) extra space? 
 *
 */
public class WiggleSortII {

	public void wiggleSort(int[] nums){ 
		if(nums.length < 1)
			return ;	
		for(int i=0;i<nums.length-1;i++){
			for(int j=nums.length-2;j>=0;j--){
				if(nums[j]>nums[j+1]){
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		for(int i=1;i<nums.length-1;i += 2){
			int temp = nums[i];
			nums[i] = nums[i+1];
			nums[i+1] = temp;
		}
		
	}
}
