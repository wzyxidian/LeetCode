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

	
	//����Ľⷨ���Լ�û��������������⣬��Ϊ������ַ�������ת�������ͣ����̫���棬��ʵ������⣬�Լ���JavaԴ���ʱ�򿴹�Integer.parseInt(String str)
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
	
	//��ȷ�Ľⷨ
	//�������Ҫע�⼸�����棨1�������ǡ���,null�����ַ�����ʱ�򣬷���0
	//��2���ж�ת����ֵ�Ƿ����Integer�����ֵ���Ƿ�С��Integer����Сֵ��������int�ķ�Χ������int���ֵ����Сֵ
	//(3)������С�+����-����Ӱ��
	//ѧ����һ��API����Character.isWhitespace()�ж��Ƿ�Ϊ����
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
