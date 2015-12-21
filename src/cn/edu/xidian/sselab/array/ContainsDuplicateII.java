package cn.edu.xidian.sselab.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author zhiyong wang
 * title:	Contains Duplicate II	
 * content:
 * 		Given an array of integers and an integer k, 
 * 		find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
 * 		and the difference between i and j is at most k. 
 * 这个地方注意是：最大差距是k，可以比k小，所以不能用等于，要用小于等于
 *
 */
public class ContainsDuplicateII {
	//多个if判断条件，如果可以写到一起，就用&&或者||操作写到一起，尽量不要用多级判断，一方面是形式上不好看，另一方面增加了时间的开销
	//这里是用HashMap记录数值出现的下标与数值，当有重复数值出现，且下标值小于等于指定的最大值k时，返回正确的结果
	public boolean containsNearbyDuplicate(int[] nums,int k){
		int length = nums.length;
		HashMap<Integer,Integer> containers = new HashMap<Integer,Integer>();
		for(int i=0;i<length;i++){
			if(containers.containsKey(nums[i]) && i-containers.get(nums[i])<=k){
				return true;
			}else{
				containers.put(nums[i], i);
			}
		}
		return false;
	}
	
	//通过Set来进行判断
	public boolean containsNearbyDuplicates(int[] nums,int k){
		int start = 0;
		int end = 0;
		int length = nums.length;
		Set<Integer> containers = new HashSet<Integer>();
		for(int i=0;i<length;i++){
			if(!containers.contains(nums[i])){
				end++;
				containers.add(nums[i]);
			}else return true;
			if(end - start > k){
				containers.remove(nums[start]);
				start++;
			}
		}
		return false;
	}
}
