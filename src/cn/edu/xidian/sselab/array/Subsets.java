package cn.edu.xidian.sselab.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zhiyong wang
 * title: SubSets
 * content:
 *  Given a set of distinct integers, nums, return all possible subsets.
 *  Note:
 *
 *    Elements in a subset must be in non-descending order.
 *    The solution set must not contain duplicate subsets.
 *
 *	For example,
 *		If nums = [1,2,3], a solution is:
 *
 *		[
 *		  [3],
 *		  [1],
 *		  [2],
 *		  [1,2,3],
 *		  [1,3],
 *		  [2,3],
 *		  [1,2],
 *		  []
 *		]
 *
 *
 */
public class Subsets {

	public List<List<Integer>> subsert(int[] nums){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(nums.length == 0)return list;
		if(nums == null) return null;
		List<Integer> first = new ArrayList<Integer>();
		list.add(new ArrayList<Integer>(first));
		
		return null;
	}
}
