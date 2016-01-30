package cn.edu.xidian.sselab.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author zhiyong wang
 * title: Fraction to Recurring Decimal
 * content:
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * 
 * For example,
 * 
 *     Given numerator = 1, denominator = 2, return "0.5".
 *     Given numerator = 2, denominator = 1, return "2".
 *     Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 *
 */
public class FractiontoRecurringDecimal {

	//I cannot solve this problem by myself
	//这个题首先要考虑特殊情况（1）numerator是0的情况（2）denominator是0的情况（3）正负值问题
	//然后因为返回的是字符串，而这个结果是拼凑的结果，所以要用StringBuilder的append方法来拼凑结果
	//拼凑方式首先是取正负号(用异或的方式获取正负号)，(注意开始之前，两个数都要进行取绝对值操作)然后是整数部分，再然后是一个一个添加余数*10之后，除以分母的结果
	//此时用HashMap来保存余数，与结果的长度，余数用来判断什么时候开始出现循环，长度用来记录添加括号的起始位置
	public String fractionToDecimal(int numerator, int denominator){
		if(numerator == 0) return "0";
		if(denominator == 0) return null;
		StringBuilder strb = new StringBuilder();
		 // "+" or "-"
		strb.append(((numerator>0)^(denominator>0))?"-":"");
		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);
		// integral part
		strb.append(num/den);
		num %= den;
		if(num == 0) return strb.toString();
		 // fractional part
		strb.append(".");
		Map map = new HashMap();
		while(num != 0){
			if(!map.containsKey(num)){
				map.put(num, strb.length());
				num *= 10;
				strb.append(num/den);
				num %= den;
			}else{
				int index =  (int) map.get(num);
				strb.insert(index, "(");
				strb.append(")");
				break;
			}
			
		}
		return strb.toString();
	}
}
