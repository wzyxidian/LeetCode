package cn.edu.xidian.sselab.string;

/**
 * 
 * @author zhiyong wang
 * title: Longest Common Prefix
 * content:
 *
 *Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

	//把第一个字符串作为前缀来判断，然后从第二个字符串开始遍历，如果他的indexOf不等于0，说明第一个字符串不是他的前缀，
	//这个时候，将第一个字符串的最后一位去掉来作为前缀继续判断，直到该字符串是他的前缀为止，然后判断他是否是下一个的前缀，时间复杂度为O(N)
	public String longestCommonPrefix(String[] strs){
		if(strs == null || strs.length == 0) return "";
		String pre = strs[0];
		int i = 1;
		while(i < strs.length){
			while(strs[i].indexOf(pre) != 0)
				pre = pre.substring(0,pre.length() - 1);
			i++;
		}
		return pre;
	}
	
}
