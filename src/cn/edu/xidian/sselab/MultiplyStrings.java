package cn.edu.xidian.sselab;
/**
 * title:Multiply Strings
 * content:
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * ����֪�������ԣ�����Stringת����������������ģ����Բ����ü򵥵�ֱ��ת������������Ҫһ���ַ�һ���ַ���ת������Ӧ�����֣�Ȼ����м���
 * �����Ϊ���֣���1���ӽ�������һ����ʼ��������ǰ���ÿһλ����2���ó������γ��Ա�������ÿһλ��Ȼ����ӣ���ǰһλ�Ľ�������ϳ��Ժ�һλ�Ľ����ע����λǰ������
 */
public class MultiplyStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = MultiplyStrings.multiplys("0","0");
		System.out.println(res);
	}
	
	//�Լ�����������ģ��ύ��������βŰѴ����ų����ˣ�ע��ĵط��ǣ�����������ˣ��������󳤶ȵ������������Գ���֮��
	//���ӵĵط�������
	//(1)���ַ���ȡֵ��ʱ����charAt(i)ȡ������ַ������ַ�֮�󣬲���ֱ����int����ת�����м�Ҫ��ת����String���ͣ�����ת����int��
	//����Character-->String-->Integer,�������ܽ��ַ����е�����ת����int���͵�����,���ӣ�Integer.valueOf(String.valueOf(num1.charAt(i)))
	//��������һ�ַ��������char���ͺ��ȥ'0'��ͬ�������������ֵ
	//(2)������˵�ʱ���Ǵ����һλ��ʼ�ģ����Ҳο��Ĺ����ǣ�����������ÿ�����ֶ���һ��λ�ã�λ��֮����ȵģ������ͬһ��λ�ã����Խ�������һλӦ������������λ��֮�ͼ�ȥ2
	//(3)©���˽����0�����,�����ȡ�ķ������������жϽ�λ�Ƿ�Ϊ0�������Ϊ0��ʲô�������ǣ����Ϊ0������Ҫ�ӵ�һλ��ʼ��ѯ�ж��Ƿ�Ϊ0��֪��������һ����Ϊ0������Ϊֹ
	public static String multiply(String num1,String num2){		
		String result = "";
		int len1 = num1.length();
		int len2 = num2.length();
		int len = len1 + len2;
		int[] num = new int[len];	
		int trade = 0;
		for(int k=len-2;k>=0;k--){
			int res = 0;
			for(int i=len1-1;i>=0;i--){
				for(int j=len2-1;j>=0;j--){				
					if(i + j == k){
						res += Integer.valueOf(num1.charAt(i) - '0') * Integer.valueOf(num2.charAt(j) - '0');
					}
					if(i == 0 && j == 0){
						res += trade;
						trade = res / 10;
						num[k+1] = res % 10;
					}
				}				 
			}
		}
		if(trade != 0){
			result = trade + result;
			for(int j=1;j<len;j++){
				result += num[j];			
			}
		}else{
			int i = 1;
			while(i<len && num[i] == 0){
				i++;
			}
			if(i == len){
				result = "0";
			}
			for(int j=i;j<len;j++){
				result += num[j];			
			}
		}		
		return result;
	}
	
	//�ο���discuss�����һ��ʱ�临�Ӷ�ΪO(n^2),�����ó˷����ַ�ʽ���õڶ������ӵ�һ�������Ե�һ������
	public static String multiplys(String num1,String num2){
		int len1 = num1.length();
		int len2 = num2.length();
		int len = len1 + len2;
		int[] mul = new int[len];
		for(int i=len1-1;i>=0;i--){
			int a = num1.charAt(i) - '0';
			int k = len2 + i;//��һ������Ϊ���������//	
			for(int j=len2-1;j>=0;j--){
				int b = num2.charAt(j) - '0';
				int temp = mul[k] + a * b;
				mul[k] = temp % 10;
				mul[k - 1] = mul[k - 1] + temp / 10;
				k--;//���ҲҪǰ��
			}
		}
		int i = 0;
		while(i<len-1 && mul[i] == 0){
			i++;
		}
		StringBuffer sb = new StringBuffer();
		for(;i<len;i++){
			sb.append(mul[i]);
		}
		return sb.toString();
	}
	

}
