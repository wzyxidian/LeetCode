package cn.edu.xidian.sselab.array;

/**
 * 
 * @author zhiyong wang
 * title: Merge Sorted Array
 * content:
 *			Given two sorted integer arrays nums1 and nums2, 
 *			merge nums2 into nums1 as one sorted array.
 *	Note:
 *		You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
 *		The number of elements initialized in nums1 and nums2 are m and n respectively. 
 *
 */
public class MergeSortedArray {

	//从后面往前面来进行比较，这样就不会产生数据不断移动的困扰
	//因为是往nums1来插入数据，如果nums2比较完了，nums1还有剩余，就不用管了，不用再进行一遍赋值操作
	//这个题就是数据结构的第一个例题
	public void merge(int[] nums1, int m, int[] nums2, int n){
		int aIndex = m-1;
		int bIndex = n-1;
		int index = m + n - 1;
		while(aIndex >= 0 && bIndex >= 0){
			if(nums1[aIndex] > nums2[bIndex]){
				nums1[index--] = nums1[aIndex--];
			}else{
				nums1[index--] = nums2[bIndex--];
			}
		}
		while(bIndex >= 0){
			nums1[index--] = nums2[bIndex--];
		}		
	}
}
