package cn.edu.xidian.sselab.string;

import java.awt.datatransfer.StringSelection;

/**
 * 
 * @author zhiyong wang
 * title: Valid Palindrome
 * content:
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *  
 *  For example,
 *  "A man, a plan, a canal: Panama" is a palindrome.
 *  "race a car" is not a palindrome.
 *  
 *  Note:
 *  Have you consider that the string might be empty? This is a good question to ask during an interview.
 *  
 *  For the purpose of this problem, we define empty string as valid palindrome. 
 *
 */
public class ValidPalindrome {

	//这个题很多地方一开始没有想到，调试出了许多错误：
	//1.没有注意到字符串里面有很多不是字母或者数字，如果是不是字母或者数字，要跳过他们，不管他们
	//2.内部两个循环，第一落下了start小于end的约束条件，第二忘记把if改成while循环
	//3.比较的时候忘记了还有大小写的情况，数字、字母都可以调用toLowerCase
	public boolean isPalindrome(String s){
		if(s == null) return false;
		int len = s.length();
		if(s.isEmpty()) return true;
		int start = 0; 
		int end = len - 1;
		while(start < end){
			while(start < end && !Character.isLetterOrDigit(s.charAt(start)))
				start++;
			while(start < end && !Character.isLetterOrDigit(s.charAt(end)))
				end--;
			if(start < end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
					return false;
			start++;
			end--;
		}
		return true;
	}
}
