package cn.edu.xidian.sselab.hashtable;

import java.util.Vector;

/**
 * 
 * @author zhiyong wang
 * title: Minimum Window Substring
 * content:
 * 	 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 *
 * Minimum window is "BANC".
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 *
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S. 
 *
 */
public class MinimunWindowSubstring {

	public String minWindow(String s, String t){
		if(s == null || s.length() == 0) return "";
		if(t == null || t.length() == 0) return "";
		if(s.length() < t.length()) return "";
		
	}
}
