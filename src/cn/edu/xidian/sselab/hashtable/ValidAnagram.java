package cn.edu.xidian.sselab.hashtable;

import java.util.HashMap;

/**
 * 
 * @author zhiyong wang
 * title: Valid Anagram
 * content:
 * Given two strings s and t, 
 * write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 */
public class ValidAnagram {

	//自己用map来做，犯了一个愚蠢的错误，竟然移除元素的时候根据value来做了，只能根据key来移除元素
	//要考虑两种情况：（1）s或者t为null的时候（2）s与t长度都是0的情况
	//这种方法用key来保存s具体的字符，value表示key出现的次数，然后检查t中是否有不在s中的
	public boolean isAnagram(String s, String t){
		if(s == null || t == null) return false;
		int lengthS = s.length();
		int lengthT = t.length();
		if(lengthS != lengthT){
			return false;
		}else if(lengthS == 0){
			return true;
		}else{
			HashMap<Character,Integer> containerS = new HashMap<Character,Integer>();
			for(int i=0;i<lengthS;i++){
				if(containerS.containsKey(s.charAt(i))){
					containerS.put(s.charAt(i), containerS.get(s.charAt(i)) + 1);
				}else{
					containerS.put(s.charAt(i), 1);
				}
			}
			for(int i=0;i<lengthT;i++){
				if(containerS.containsKey(t.charAt(i)) && containerS.get(t.charAt(i))>0){
					containerS.put(t.charAt(i), containerS.get(t.charAt(i))-1);
				}else{
					return false;
				}
			}
		}
		return true;
	}
	
	//自己看到大牛做的很高超的手法，让我想到了快排，为26个字母建立一个长度为26的数组
	//每个字母按照顺序依次对应的数值为字母出现的次数，初始值都为0
	//判断s的过程是计算每个字母出现顺序的过程，
	//判断t的过程是将每个字母出现的顺序依次减去，如果最后回到每个字母的次数都为0，说明true
	public boolean isAnagram1(String s,String t){
		int[] times = new int[26];
		for(int i=0;i<s.length();i++){
			times[s.charAt(i) - 'a']++;
		}
		for(int i=0;i<t.length();i++){
			times[t.charAt(i) - 'a']--;
		}
		for(int i=0;i<26;i++){
			if(times[i] != 0){
				return false;
			}
		}
		return true;
	}
}
