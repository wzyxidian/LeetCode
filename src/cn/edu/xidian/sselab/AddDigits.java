package cn.edu.xidian.sselab;

import java.util.ArrayList;
/**
 * title:Add Digits
 * contents:
 *  Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *  For example:
 *  Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 *  Follow up:
 *  Could you do it without any loop/recursion in O(1) runtime? 
 */
public class AddDigits {

	/**
	 * @author wzy
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddDigits ad = new AddDigits();
		int result1 = ad.addDigits(59);
		int result2 = ad.addDigitAnotherWay(59);
		System.out.println(result1 + " " + result1);
	}
	//没有看清题目，不允许使用循环与递归，时间复杂度为O(1)，错误的解法
	//而且这个地方也不用这么麻烦，用取余操作就可以求和
	public int addDigit(int num){		
		while(num >=10){
			String strNum = String.valueOf(num);
			int length = strNum.length();
			int result = 0;
			for(int i=0;i<length;i++){
				result += Integer.valueOf(strNum.charAt(i) - 48);
			}
			num = result;
		}		
		return num;
	}
	
	//这也是一种求各位数之后的方法
	public int addDigitAnotherWay(int num){
		while(num >= 10){
			num = (num / 10) + num % 10;
		}
		return num;
	}
	//分析得出来的规律，自己没有的出来，从网上得到的思路，看到了公式result = (num -1) % 9 + 1，也可以是其他公式
	public int addDigits(int num){		
		int result = 0;
		result = (num -1) % 9 + 1;
		return result;
	}

}
