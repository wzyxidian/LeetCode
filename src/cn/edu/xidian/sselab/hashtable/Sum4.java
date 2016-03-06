package cn.edu.xidian.sselab.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author zhiyong wang
 * title: 4Sum
 * content:
 *		Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 *Note:
 *
 *    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 *    The solution set must not contain duplicate quadruplets.
 *
 *    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 *    A solution set is:
 *    (-1,  0, 0, 1)
 *    (-2, -1, 1, 2)
 *    (-2,  0, 0, 2)
 *
 */
public class Sum4 {

	//自己只想到了循环四次，这种方法时间超时，下面是参考大牛的做法
	//时间复杂度为O(n^3),第一次循环，选择第一个点；第二次循环，选择第二个点，第三次循环，取出最大值与最小值，然后判断四个值之和是否为target，如果小于，最小值加，反之，最大值减
	//学习到了一个新方法Arrays.sort()对数组进行排序，Arrays.asList()新建一个ArrayList对象
	public List<List<Integer>> fourSum(int[] nums, int target){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int length = nums.length;
		if(length < 4 || nums == null) return list;		
		Arrays.sort(nums);
		if(target < 4 * nums[0] || target > 4 * nums[length-1]) return list;
		for(int i=0;i<length-3;i++){
			if(i>0 && nums[i]== nums[i-1]) continue;
			for(int j=i+1;j<length-2;j++){
				if(j>i+1 && nums[j]==nums[j-1]) continue;
				int low = j+1;
				int high = length-1;
				while(low < high){
					int sum = nums[i]+nums[j]+nums[low]+nums[high];
					if(sum == target){
						list.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
						while(low<high && nums[low]==nums[low+1]) low++;
						while(low<high && nums[high]==nums[high-1]) high--;
						low++;
						high--;
					}else if(sum <target){
						low++;
					}else{
						high--;
					}
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		Sum4 s = new Sum4();
		int[] nums = {0,0,0,0};
		s.fourSum(nums, 0);
	}
}
