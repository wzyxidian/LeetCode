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

	//ע������Ҫ�������0��ֵ,
	//˼·����Ϊ��1�������������Ҫ�����жϣ�Ȼ���жϴ���1���������ȶ�2һֱȡ����Ȼ���3һֱȡ��������5ȡ�����ж����Ľ���Ƿ���1�������1�����ǳ���
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
