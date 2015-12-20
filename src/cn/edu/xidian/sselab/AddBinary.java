package cn.edu.xidian.sselab;
/**
 * title:Add Binary
 * content:
 *  Given two binary strings, return their sum (also a binary string).
 *  For example;
 *  a = "11"
 *  b = "1"
 *  Return "100". 
 */
public class AddBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(AddBinary.addBinary("11111000", "10010001"));
	}
	
	//自己做的，一次提交成功，第一次上来一次提交成功
	//这个题的思路主要是针对AddTwoNumbers受到的启发，然后用了一个while循环解决了问题，用StringBuffer来进行逆向存储，
	//最后调用他的reverse方法，反向得到结果
	public static String addBinary(String a, String b){
		int sum = 0;
		int len1 = a.length();
		int len2 = b.length();
		StringBuffer sb = new StringBuffer();
		int i = len1 -1;
		int j = len2 - 1;
		while(i >= 0 || j >= 0){
			sum /= 2;
			if(i >= 0){
				sum += a.charAt(i) - '0';
				i--;
			}
			if(j >= 0){
				sum += b.charAt(j) - '0';
				j--;
			}
			sb.append(sum % 2);
		}
		if(sum / 2 == 1){
			sb.append(1);
		}
		return sb.reverse().toString();
	}

}
