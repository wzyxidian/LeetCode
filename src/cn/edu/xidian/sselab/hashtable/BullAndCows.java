package cn.edu.xidian.sselab.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author zhiyong wang 
 * title: Bull And Cows
 * content:
 * ou are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 * For example:
 * 
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * 
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * 
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
 * 
 * Please note that both secret number and friend's guess may contain duplicate digits, for example:
 * 
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * 
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 * 
 * You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 *
 */
public class BullAndCows {

	//自己没有想出来，参考大牛的解题思路
	//这里默认secret 与 guess的长度是相等的
	//这个地方求cow的值是通过新建一个数组来保存0到9这十个数字，初始化值都为0，如果在secret中，他对应的值加1，如果在guess中，他对应的值减1
	//这样如果在secret的某位的值在数组中显示小于0，说明他以前在guess中出现过，通过guess也是这样
	public String getHint(String secret, String guess){
		int[] numbers = new int[10];
		int bull = 0;
		int cow = 0;
		if(secret == null || guess == null) return null;
		if(secret.length() == 0 || guess.length() == 0)
			return "0A0B";
		for(int i=0;i<secret.length();i++){
			if(secret.charAt(i) == guess.charAt(i))
				bull++;
			else{
				if(numbers[secret.charAt(i) - '0']++ < 0) cow++;
				if(numbers[guess.charAt(i) - '0']-- > 0) cow++;
			}
		}
		return bull + "A" + cow + "B";
	}
	
}
