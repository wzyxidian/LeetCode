package cn.edu.xidian.sselab.hashtable;

/**
 * 
 * @author zhiyong wang
 * title: Single Number
 * content:
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory? 
 * 
 *
 */
public class SingleNumber {

	//利用异或操作，相同为0，相异为1，这样一次循环就能找到不同的那个数
	public int singleNumber(int[] nums){
		int length = nums.length;
		int result = 0;
		for(int i=0;i<length;i++){
			result = result ^ nums[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		SingleNumber single = new SingleNumber();
		System.out.println(single.singleNumber(new int[]{1,2,1}));;
	}
}
