package cn.edu.xidian.sselab;
/**
 * title:Multiply Strings
 * content:
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 读已知条件可以，两个String转换后的数字是任意大的，所以不能用简单的直接转换方法，而是要一个字符一个字符的转换成相应的数字，然后进行计算
 * 计算分为两种：（1）从结果的最后一个开始，依次向前求出每一位，（2）用乘数依次乘以被乘数的每一位，然后相加，用前一位的结果，加上乘以后一位的结果，注意结果位前移问题
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
	
	//自己最后做出来的，提交了至少五次才把错误都排除完了，注意的地方是：两个数字相乘，结果的最大长度等于两个数各自长度之后，
	//忽视的地方有三个
	//(1)从字符串取值的时候，用charAt(i)取出这个字符串的字符之后，不能直接往int类型转换，中间要先转换成String类型，才能转换成int型
	//即：Character-->String-->Integer,这样才能将字符串中的数字转换成int类型的数字,例子：Integer.valueOf(String.valueOf(num1.charAt(i)))
	//还有另外一种方法，求出char类型后减去'0'，同样可以求出最后的值
	//(2)数字相乘的时候是从最后一位开始的，而且参考的规律是：两个乘数的每个数字都有一个位置，位置之和相等的，结果在同一个位置，所以结果的最后一位应该是两个乘数位置之和减去2
	//(3)漏掉了结果是0的情况,这里采取的方法，是首先判断进位是否为0，如果不为0则什么都不考虑；如果为0，则需要从第一位开始轮询判断是否为0，知道遇到第一个不为0的数字为止
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
	
	//参考的discuss里面的一个时间复杂度为O(n^2),他是用乘法那种方式，用第二个因子的一个数乘以第一个因子
	public static String multiplys(String num1,String num2){
		int len1 = num1.length();
		int len2 = num2.length();
		int len = len1 + len2;
		int[] mul = new int[len];
		for(int i=len1-1;i>=0;i--){
			int a = num1.charAt(i) - '0';
			int k = len2 + i;//这一步我认为是最难想的//	
			for(int j=len2-1;j>=0;j--){
				int b = num2.charAt(j) - '0';
				int temp = mul[k] + a * b;
				mul[k] = temp % 10;
				mul[k - 1] = mul[k - 1] + temp / 10;
				k--;//结果也要前移
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
