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
	//û�п�����Ŀ��������ʹ��ѭ����ݹ飬ʱ�临�Ӷ�ΪO(1)������Ľⷨ
	//��������ط�Ҳ������ô�鷳����ȡ������Ϳ������
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
	
	//��Ҳ��һ�����λ��֮��ķ���
	public int addDigitAnotherWay(int num){
		while(num >= 10){
			num = (num / 10) + num % 10;
		}
		return num;
	}
	//�����ó����Ĺ��ɣ��Լ�û�еĳ����������ϵõ���˼·�������˹�ʽresult = (num -1) % 9 + 1��Ҳ������������ʽ
	public int addDigits(int num){		
		int result = 0;
		result = (num -1) % 9 + 1;
		return result;
	}

}
