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

	
	//�Լ���ģ����ַ�����Ȼ�ԣ����Ǵ������Ƚ϶࣬����ȥ�Ƚ��鷳
	//�����������������ǵģ���1��26����������2������26�ı���
	//��1������26����������ʱ�򣬻�Ҫ��������1�����������λ���̴���1ʱ�Ž��н�λ����
	//(2)������26����������ʱ��
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

	
	//�ο��ıȽϺõķ���,Ψһ�������ǣ�����26�ı�����������λ������26�ı��������ͼ�һ
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
