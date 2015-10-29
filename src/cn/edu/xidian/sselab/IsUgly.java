package cn.edu.xidian.sselab;
/**
 * title:Ugly Number
 * content:
 * rite a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number. 
 */
public class IsUgly {

	//注意数据要输入大于0的值,
	//思路：因为有1这个特例，所以要进行判断，然后判断大于1的数，首先对2一直取整，然后对3一直取整，最后对5取整，判断最后的结果是否是1，如果是1，则是丑数
	public static boolean isUgly(int num){
		boolean flag = false;
		if(num == 1){
			flag = true;
		}else if(num > 1){
			while(num % 2 == 0){
				num = num / 2;
			}
			while(num % 3 == 0){
				num = num / 3;
			}
			while(num % 5 == 0){
				num = num / 5;
			}
			if(num == 1){
				flag = true;
			}
		}	
		return flag;
	}

}
