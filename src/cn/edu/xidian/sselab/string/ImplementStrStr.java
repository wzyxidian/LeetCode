package cn.edu.xidian.sselab.string;

/**
 * 
 * @author zhiyong wang
 * title: Implement strStr()
 * content:
 *  Implement strStr().
 *  
 *  Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. 
 *
 */
public class ImplementStrStr {
	//这个题非常简单，就是一个求索引下标的题目，会用indexOf即可
	public int strStr(String haystack, String needle){
		if(haystack == null || needle == null) return -1;
		 return haystack.indexOf(needle);
	}
}
