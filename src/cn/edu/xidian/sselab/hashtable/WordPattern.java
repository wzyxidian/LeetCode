package cn.edu.xidian.sselab.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author zhiyong wang
 * title: Word Pattern
 * content:
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, 
 * such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 *		Examples:
 *
 *    pattern = "abba", str = "dog cat cat dog" should return true.
 *    pattern = "abba", str = "dog cat cat fish" should return false.
 *    pattern = "aaaa", str = "dog cat cat dog" should return false.
 *    pattern = "abba", str = "dog dog dog dog" should return false.
 *
 *  Notes:
 *  You may assume pattern contains only lowercase letters, 
 *  and str contains lowercase letters separated by a single space. 
 *
 */
public class WordPattern {
	
	//这个地方犯了两次错误，怎么就一直不改正呢
	//没有把key不同，value相同的情况排除掉  即没有排除：abab,dog dog dog dog这种情况
	public boolean wordPattern(String pattern, String str){
		if(pattern == null || str == null) return false;
		int lengthP = pattern.length();
		String[] strArray = str.split(" ");
		int lengthS =  strArray.length;
		if(lengthP == 0 || lengthS == 0 || lengthP != lengthS) return false;
		HashMap<Character,String> container =  new HashMap<Character,String>();
		for(int i=0;i<lengthP;i++){
			if(container.containsKey(pattern.charAt(i))){
				if(!container.get(pattern.charAt(i)).equals(strArray[i])){
					return false;
				}
			}else{
				if(container.containsValue(strArray[i])){
					return false;
				}else{
					container.put(pattern.charAt(i), strArray[i]);
				}				
			}
		}	
		return true;
	}
	
	//大牛的算法,这里学习了index.put(key,value)的返回值，根据key来判断
	/*
	 * 这是最原始的put的返回值的注释
	 * the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     *         (A <tt>null</tt> return can also indicate that the map
     *         previously associated <tt>null</tt> with <tt>key</tt>,
     *         if the implementation supports <tt>null</tt> values.)
     *  大意是如果put的key值原来并不在map中，则返回null，如果key已经存在了，那么返回key值对应的前一个value值       
     *  用这种方法判断，key存放的pattern的每一个字符，与str的每一个单词，然后根据对应的位置value来判断是否是一一影射
     * 	这里注意一下返回值是一个对象
     * */
	public boolean wordPatterns(String pattern, String str){
		String[] words = str.split(" ");
		if(words.length != pattern.length()) 
			return false;
		Map index = new HashMap();
		for(Integer i=0;i<words.length;i++){//这里一开始用int报错了
			if(index.put(pattern.charAt(i),i) != index.put(words[i],i)) 
				return false;
		}
		return true;
	}
	
}
