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

	//�Ӻ�����ǰ�������бȽϣ������Ͳ���������ݲ����ƶ�������
	//��Ϊ����nums1���������ݣ����nums2�Ƚ����ˣ�nums1����ʣ�࣬�Ͳ��ù��ˣ������ٽ���һ�鸳ֵ����
	//�����������ݽṹ�ĵ�һ������
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
