package cn.edu.xidian.sselab.array;

/**
 * 
 * @author zhiyong wang
 * title:Remove Duplicates from Sorted Array
 * content:
 *  Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 *  Do not allocate extra space for another array, you must do this in place with constant memory.
 *  For example,
 *  Given input array nums = [1,1,2],
 *  Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length. 
 */
public class RemoveDuplicatesfromSortedArray {

	//这个题与RemoveElement几乎相同，因为是已经排好序的数组，比较条件改成相邻的两个数进行比较
	//同样是统计double的数字的对数，每个数前移相同的数字的个数
	//不过比较的时候要注意问题，不要越界，这里特别主要，nums里面个数小于2个时候，不做任何处理，只有多于1个时才会进行比较
	public int removeDuplicates(int[] nums){
		int length = nums.length;
		int count = 0;
		if(length>1){
			for(int i=1;i<length;i++){
				if(nums[i-1] == nums[i]){
					count++;
				}else{
					nums[i-count] = nums[i];
				}
			}
		}
		return length-count;
	}
}
