package cn.edu.xidian.sselab.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author zhiyong wang
 * title: Roman to Integer
 * content:
 *
 *Given a roman numeral, convert it to an integer.
 *
 *Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomantoInteger {

	//这个题只要明白好了规则就可以，遍历的时候注意：IV表示4，IX表示9，XL表示40，XC表示90，CD表示400，CM表示900就可以了
	public int romanToInteger(String s){
		char[] standard = {'I','V','X','L','C','D','M'};
		int[] standardNum = {1,5,10,50,100,500,1000};
		char[] arr = s.toCharArray();
		int len = arr.length;
		int result =  0;
		for(int i=0;i<len;i++){
			switch(arr[i]){
			case 'M': result += 1000;break;
			case 'D': result += 500;break;
			case 'C': 
				if(i < len-1 && arr[i+1] == 'D'){
					result += 400;
					i++;
					break;
				}
				if(i < len-1 && arr[i+1] == 'M'){
					result += 900;
					i++;
					break;
				}
				result += 100;
				break;
			case 'L': result += 50;break;
			case 'X': 
				if(i < len-1 && arr[i+1] == 'L'){
					result += 40;
					i++;
					break;
				}
				if(i < len-1 && arr[i+1] == 'C'){
					result += 90;
					i++;
					break;
				}
				result += 10;
				break;
			case 'V': result += 5;break;
			case 'I': 
				if(i < len-1 && arr[i+1] == 'X'){
					result += 9;
					i++;
					break;
				}
				if(i < len-1 && arr[i+1] == 'V'){
					result += 4;
					i++;
					break;
				}
				result += 1;
				break;			
			}
		}
		return result;	
	}
	
	//参考的另外一种思路，即从右往左来进行遍历，计算结果，如果右边的数值大于左边的，就将其减去，如果小于，就加上作为最后结果
	public int romanToIntegers(String s){
		Map map = new HashMap();
		map.put('I',1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int len = s.length();
		int result = (int) map.get(s.charAt(len-1));
		int pivot = result;
		for(int i=len-2;i>=0;i--){
			int cur = (int) map.get(s.charAt(i));
			if(cur >= pivot){
				result += cur;
			}else{
				result -= cur;
			}
			pivot = cur;
		}
		return result;
	}
}
