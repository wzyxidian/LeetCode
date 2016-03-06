package cn.edu.xidian.sselab.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author zhiyong wang
 * title: Group Anagrams
 * content:
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * 
 * [
 *   ["ate", "eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 
 * Note:
 * 
 *     For the return value, each inner list's elements must follow the lexicographic order.
 *     All inputs will be in lower-case.
 * 
 *
 */
public class GroupAnagrams {
	//参考大神的做法，自己没有想到可以用map作为容器进行存储，key为排序之后的一个串，value就是这个串对应的list
	//因为每个子list要求是排序的，所以第一步，先对strs里面所有的字符串进行排序，这样添加到每个list里面的就是排好序的
	public List<List<String>> groupAnagrams(String[] strs){
		if(strs == null || strs.length == 0) return new ArrayList<List<String>>();
		Arrays.sort(strs);
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		for(int i=0;i<strs.length;i++){
			String temp = strs[i];
			char[] beforeSort = temp.toCharArray();
			Arrays.sort(beforeSort);
			String afterSort = String.valueOf(beforeSort);
			if(!map.containsKey(afterSort)) map.put(afterSort, new ArrayList<String>());				
				map.get(afterSort).add(temp);
		}
		return new ArrayList<List<String>>(map.values());
	}
}
