package cn.edu.xidian.sselab.string;

/**
 * 
 * @author zhiyong wang
 * title: Count and Say
 * content:
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string. 
 *
 */
public class CountAndSay {

	//这个题主要是理解题意，理解了题意就好做了，其实就是一个时间复杂度为O(N^2)操作，第一层是对n从1开始进行遍历，第二层是求每一层的数值
	public String countAndSays(int n){
		String s = "1";
		for(int i=1;i<n;i++){
			s = countAndSay(s);
		}
		return s;
	}
	public String countAndSay(String s){
		char[] ch = s.toCharArray();
		int len = ch.length;
		StringBuilder sb = new StringBuilder();
		if(len == 1) sb.append(1).append(s);
		int i=0;
		int j = 0;
		while(i<len-1){
			j = 0;
			while(i< len-1 && ch[i] == ch[i+1]){
				i++;
				j++;
			}		
			sb.append(j+1).append(ch[i]);
			i++;
		}
		if(len > 1 && ch[len-1] != ch[len-2]){
			sb.append(1).append(ch[len-1]);
		}
		return sb.toString();			
	}
}
