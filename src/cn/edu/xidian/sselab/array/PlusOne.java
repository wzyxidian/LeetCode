package cn.edu.xidian.sselab.array;

/**
 * title:Plus One
 * content:
 * iven a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {

	//自己想的 办法，期间犯了致命的三个错误
	//（1）while循环的时候，i>=0要放到前面，因为他是主要只有通过他了，&&后面的条件才会判断，不然就会报越界错误
	//(2)考虑了不是所有位都是9的情况与所有位都是9的情况，但是拉下了第一位不是9的情况
	//(3)当数组空间不够的时候，没有给新建空间
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
	
	//参考的比较好的方法，方法很简单，
	//巧妙的地方是，利用新建的数组，初始化了所有的元素都为0，这样省去了一个每个值赋值为0的时间
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
