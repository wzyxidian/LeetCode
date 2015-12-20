package cn.edu.xidian.sselab;
/**
 * title:Excel sheet Column Title
 * content:
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 *
 *  1 -> A
 *  2 -> B
 *  3 -> C
 *  ...
 *  26 -> Z
 *  27 -> AA
 *  28 -> AB 
 */
public class ConvertToTitle {

	
	//自己想的，这种方法虽然对，但是代码量比较多，看上去比较麻烦
	//这里分两种情况来考虑的，（1）26的整数倍（2）不是26的倍数
	//（1）当是26的整数倍的时候，还要考虑商是1的情况，不进位，商大于1时才进行进位操作
	//(2)当不是26的整数倍的时候
	public static String converToTitle(int n){
		String title = "";
		int remainder;
		if(n % 26 == 0){
			while(n % 26 == 0){		
				title = (char) 'Z' + title;
				n = n / 26;
			}
			if(n > 1){
				title = (char) (n - 2 + 'A') + title;
			}
		}else{
			while(n > 26){		
				remainder = n % 26;
				n = n / 26;
				title = (char) (remainder - 1 + 'A') + title;		
			}
			title = (char) (n - 1 + 'A') + title;
		}
		return title;
	}

	
	//参考的比较好的方法,唯一的问题是：满足26的倍数，发生进位操作，26的倍数个数就减一
	public String convertToTitles(int n){
		StringBuffer sb = new StringBuffer();
		int remainder;
		while(n > 0){
			remainder = n % 26;
			n = n / 26;
			if(remainder != 0){
				sb.append((char)(remainder - 1 + 'A'));
			}else{
				sb.append('Z');
				n--;
			}
		}
		return sb.reverse().toString();		
	}
}
