package cn.edu.xidian.sselab.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author zhiyong wang
 * title:
 * content:
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 *  No two characters may map to the same character but a character may map to itself.
 *  For example,
 *  Given "egg", "add", return true.
 *  Given "foo", "bar", return false.
 *  Given "paper", "title", return true.
 *  Note:
 *  You may assume both s and t have the same length.
 *
 */
public class IsomorphicStrings {

	//自己想到的方法，注意else里面多加了一个条件，防止出现一对多的映射
	public boolean isIsomorphic(String s, String t){
		if(s == null || t == null) return false;
		int lengthS = s.length();
		int lengthT = t.length();
		if(lengthS != lengthT) return false;
		if(lengthS == 0 && lengthT != 0 || lengthS !=0 && lengthT == 0) return false;
		Map index = new HashMap();
		for(int i=0;i<lengthS;i++){
			if(index.containsKey(s.charAt(i))){
				if(!index.get(s.charAt(i)).equals(t.charAt(i)))
					return false;
			}else{
				if(index.containsValue(t.charAt(i)))
					return false;
				index.put(s.charAt(i), t.charAt(i));
			}
		}
		return true;
	}
	
	//参考了大牛的做法,这个题与Valid Vnagram解题思路类似，但又不同,这里不是从0开始加，而是循环次数加1
	 public boolean isIsomorphics(String s, String t) {
		 int[] temp1 = new int[256];
		 int[] temp2 = new int[256];
		 int length = s.length();
		 for(int i=0;i<length;i++){
			 if(temp1[s.charAt(i)] != temp2[t.charAt(i)])
				 return false;
			 temp1[s.charAt(i)] = i+1;
			 temp2[t.charAt(i)] = i+1;
		 }
	      return true;
	    }
	
}
