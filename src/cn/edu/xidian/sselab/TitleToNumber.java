package cn.edu.xidian.sselab;
/**
 * title:Excel Sheet Column Number
 * content:
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:

 *   A -> 1
 *  B -> 2
 *  C -> 3
 *  ...
 *  Z -> 26
 *  AA -> 27
 *  AB -> 28 
 */
public class TitleToNumber {

	//����һ��ʧ�ܵİ�������Ϊ����switch case�ķ�ʽ����⣬����������ǳ���
	//��ʵ������֪��A��Ӧ1��B��Ӧ2�����Ľ������ȫ�����õõ����ַ���ȥA����1�Ϳ��Եõ�ֵ
	public int titleToNumbers(String s){
		int len = s.length();
		int result = 0;
		int position = 0;
		for(int i=0;i<len;i++){
			char temp = s.charAt(i);
			position = position(temp);
			result += Math.pow(26, len - i - 1) * position;
		}
		return result;
	}
	public int position(char temp){
		int position = 0;
		switch(temp){
			case 'A': position = 1;break;
			case 'B': position = 2;break;
			case 'C': position = 3;break;
			case 'D': position = 4;break;
			case 'E': position = 5;break;
			case 'F': position = 6;break;
			case 'G': position = 7;break;
			case 'H': position = 8;break;
			case 'I': position = 9;break;
			case 'J': position = 10;break;
			case 'K': position = 11;break;
			case 'L': position = 12;break;
			case 'M': position = 13;break;
			case 'N': position = 14;break;
			case 'O': position = 15;break;
			case 'P': position = 16;break;
			case 'Q': position = 17;break;
			case 'R': position = 18;break;
			case 'S': position = 19;break;
			case 'T': position = 20;break;
			case 'U': position = 21;break;
			case 'V': position = 22;break;
			case 'W': position = 23;break;
			case 'X': position = 24;break;
			case 'Y': position = 25;break;
			case 'Z': position = 26;break;
		}
		return position;
	}
	
	//��ȷ�Ľⷨ��
	//������ʡȥ�������鷳��switch case������Ӧ��ϵ�Ĵ��룬�ǳ������
	//����ʵ�Ϳ��Խ���Ŀת����һ�����ַ�ת����һ��26���ƵĹ��̣�ע�ⲻҪ���Ϳ�����
	public int titleToNumber(String s){
		int len = s.length();
		int result = 0;
		for(int i=0;i<len;i++){
			char temp = s.charAt(i);
			result += Math.pow(26, len - i - 1) * (temp - 'A' + 1);
		}
		return result;
	}
	
}
