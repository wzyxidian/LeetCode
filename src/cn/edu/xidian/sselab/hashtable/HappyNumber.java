package cn.edu.xidian.sselab.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author zhiyong wang
 * title： Happy Number
 * content:
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: 
 * 			Starting with any positive integer, 
 * 			replace the number by the sum of the squares of its digits, 
 * 			and repeat the process until the number equals 1 (where it will stay), 
 * 			or it loops endlessly in a cycle which does not include 1. 
 * 			Those numbers for which this process ends in 1 are happy numbers.
 *
 *	Example: 19 is a happy number
 *
 *	    1^2 + 9^2 = 82
 *	    8^2 + 2^2 = 68
 *	    6^2 + 8^2 = 100
 *	    1^2 + 0^2 + 0^2 = 1
 *
 *
 */
public class HappyNumber {

	//自己改了三次才改正确的方法,出现了两个错误：（1）忘记如果不等于1，会一直循环的情况给排除掉,这里用一个Set保存出现的值来排除这种情况
	//（2）求平方的时候没有用Math.pow(a,b)这种方法
	public boolean isHappy(int n){
		if(n < 1) 
			return false;
		Set set = new HashSet();
		while(n > 1){
			if(!set.add(n))
				return false;
			n = calculate(n);
		}
		if(n == 1)
			return true;
		else 
			return false;
	}
	
	private int calculate(int n){
		int result = 0;
		while(n > 0){
			result += Math.pow(n%10, 2); 
			n = n/10;
		}
		return result;
	}

}
