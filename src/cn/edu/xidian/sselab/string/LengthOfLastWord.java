package cn.edu.xidian.sselab.string;

/**
 * 
 * @author zhiyong wang
 * title: Length of Last Word
 * content:
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * For example,
 * Given s = "Hello World",
 * return 5. 
 *
 */
public class LengthOfLastWord {

	//这个题的关键是把各种情况考虑全面，
	//1.字符串为null，2.字符串为空，3.字符串不包含空格4.字符串都包含，但字符的位置可能在最后，也可能不是最后
	public int lengthOfLastWord(String s){
		if(s == null || s.isEmpty()) return 0;
		if(!s.contains(" ")) return s.length();
		String[] spilts = s.split(" ");
		int len = spilts.length;
		if(len == 0) return 0;
		if(spilts[len - 1].equals("")) return 0;
		else return spilts[len - 1].length();		
	}
	
	//参考大牛的做法
	public int lengthOfLastWords(String s){
		return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
	}

}
