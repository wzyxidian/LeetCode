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

	//�������RemoveElement������ͬ����Ϊ���Ѿ��ź�������飬�Ƚ������ĳ����ڵ����������бȽ�
	//ͬ����ͳ��double�����ֵĶ�����ÿ����ǰ����ͬ�����ֵĸ���
	//�����Ƚϵ�ʱ��Ҫע�����⣬��ҪԽ�磬�����ر���Ҫ��nums�������С��2��ʱ�򣬲����κδ���ֻ�ж���1��ʱ�Ż���бȽ�
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
