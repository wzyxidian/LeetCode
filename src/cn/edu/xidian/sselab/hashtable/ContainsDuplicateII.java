package cn.edu.xidian.sselab.hashtable;

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
 * ����ط�ע���ǣ��������k�����Ա�kС�����Բ����õ��ڣ�Ҫ��С�ڵ���
 *
 */
public class ContainsDuplicateII {
	
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
	
	//ͨ��Set�������ж�
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
