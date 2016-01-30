package cn.edu.xidian.sselab.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author zhiyong wang
 * title: Longest Substring Without Repeating Characters
 * content:
 *    Given a string, find the length of the longest substring without repeating characters. 
 *    For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 *    which the length is 3. 
 *    For "bbbbb" the longest substring is "b", with the length of 1
 *
 */
public class LongestSubString {

	//这种方法，时间超时，如果字符串非常长，时间复杂度为O(n^2)，肯定会超时，因为这是一个最优化问题，可以用动态规划来解
	public int lengthOfLongestSubString(String s){
		int length = s.length();
		if(length == 0) return 0;
		int max = 0;
		for(int i=0;i<length;i++){
			Set set = new HashSet();
			for(int j=i;j<length;j++){
				if(!set.add(s.charAt(j)) && set.size() > max){
					max = set.size();
					break;
				}		
			}
		}
		System.out.println(max);
		return max;
	}
	//参考大牛的思路，用一个map来保存，key表示s中的字符，value表示字符的下标，
	//同时用两个指针，第一个指向字符的下标，第二个指向出现相同的字符的下一个字符
	//时间复杂度为O(n)
	public int lengthOfLongestSubStrings(String s){
		int length = s.length();
		if(length == 0) return 0;
		int max = 0;
		Map<Character,Integer> map = new HashMap();
		for(int i=0,j=0;i<length;i++){
			if(map.containsKey(s.charAt(i))){
				j = Math.max(j, map.get(s.charAt(i))+1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;	
	}
}
