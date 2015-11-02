package cn.edu.xidian.sselab;

import java.util.HashMap;

/**
 * title:String to Integer (atoi)
 * content:
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, 
 * please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 *  You are responsible to gather all the input requirements up front. 
 */
public class StringToInteger {

	
	//错误的解法，自己没有想明白这个问题，以为任意的字符都可以转换成整型，想的太天真，其实这个问题，自己看Java源码的时候看过Integer.parseInt(String str)
	public static int myAtoi(String str){
		StringBuffer sb = new StringBuffer();
		if(str == null){
			return Integer.MIN_VALUE;
		}else if(str.equals("")){
			return 0;
		}
		else{
			int len = str.length();
			int j = 0;
			if(str.startsWith("-")||str.startsWith("+")){
				sb.append(str.charAt(0));
				j++;
			}				
			for(int i=j;i<len;i++){
				char temp = str.charAt(i);
				if(temp >= '0' && temp <= '9'){
					sb.append(temp);
				}else if(temp >= 'A' && temp <= 'Z'){
					sb.append(65 + temp - 'A');
				}else if((temp >= 'a' && temp <= 'z')){
					sb.append(97 + temp - 'a');
				}else {
					sb.append("0");
				}
			}
		}
		
		System.out.println(sb);
		int num = Integer.valueOf(sb.toString());
		if(num > Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}else if(num < Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}else{
			return num;
		}
		
	}
	
	//正确的解法
	//这个问题要注意几个方面（1）输入是“”,null这种字符串的时候，返回0
	//（2）判断转换的值是否大于Integer的最大值，是否小于Integer的最小值，及超过int的范围，返回int最大值或最小值
	//(3)里面会有“+”“-”的影响
	//学到了一个API方法Character.isWhitespace()判断是否为“”
	public static int myAtois(String str){
		int p = 0 ;
		int ret = 0;
		int digit = 0;
		int len =  str.length();
		if(str ==null || len == 0)
			return 0;
		while(p < len && Character.isWhitespace(str.charAt(p)))
			p++;
		if(p == len)
			return 0;
		boolean flag = (str.charAt(p) == '-');
		if(str.charAt(p) == '-' || str.charAt(p) == '+'){
			p++;
		}
		for(;p<len;p++){
			if(str.charAt(p) > '9'||str.charAt(p) < '0'){
				break;
			}else{
				digit = str.charAt(p) - '0';
				if(!flag && ((Integer.MAX_VALUE - digit) / 10 < ret))
					return Integer.MAX_VALUE;
				if(flag && ((Integer.MIN_VALUE + digit) / 10 > ret))
					return Integer.MIN_VALUE;
				ret = ret * 10 + (flag? -digit : digit);
			}
		}
		return ret;
	}
}
