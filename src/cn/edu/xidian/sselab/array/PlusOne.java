package cn.edu.xidian.sselab.array;

/**
 * title:Plus One
 * content:
 * given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {

	//�Լ���� �취���ڼ䷸����������������
	//��1��whileѭ����ʱ��i>=0Ҫ�ŵ�ǰ�棬��Ϊ������Ҫֻ��ͨ�����ˣ�&&����������Ż��жϣ���Ȼ�ͻᱨԽ�����
	//(2)�����˲�������λ����9�����������λ����9����������������˵�һλ����9�����
	//(3)������ռ䲻����ʱ��û�и��½��ռ�
	public static int[] plusOne(int[] digits){
		int count = 0;
		int len = digits.length;		
		int i = len - 1;
		while(i >= 0 && digits[i] == 9){
			digits[i] = 0;
			count++;
			i--;
		}
		if(count == 0){
			digits[i] += 1;
			return digits;
		}else if(count != len){
			digits[i]++;
			return digits;
		}else{
			int[] digits1 = new int[len + 1];
			for(int k=len-1;k>=0;k--){
				digits[k] = digits1[k+1];
			}
			digits1[0] = 1;
			return digits1;
		}
	}
	
	//�ο��ıȽϺõķ����������ܼ򵥣�
	//����ĵط��ǣ������½������飬��ʼ�������е�Ԫ�ض�Ϊ0������ʡȥ��һ��ÿ��ֵ��ֵΪ0��ʱ��
	public int[] plusOnes(int[] digits){
		int len = digits.length;
		for(int i=len-1;i>=0;i--){
			if(digits[i] < 9){
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		int[] newDigits = new int[len + 1];
		newDigits[0] = 1;
		return newDigits;
	}

}
