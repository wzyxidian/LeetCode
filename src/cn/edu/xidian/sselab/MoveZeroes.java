package cn.edu.xidian.sselab;

/**
 * titile:Move Zeroes
 * content:
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * You must do this in-place without making a copy of the array.
 *  Minimize the total number of operations.
 */
public class MoveZeroes {

	/**
	 * @author wzy
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= new int[]{1,2,3,0,0,1,3,0};
		MoveZeroes mz = new MoveZeroes();
		mz.moveZeroes(nums);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
	}
	//给定一个数组，将所有的0值都移动到数组的最后，同时不改变非零数的位置。不能使用数组复制操作，还要使操作数最小
	//这里最开始想法是设置两个标签，一个用来表示数组中循环到数值的位置，第二个标签从上一个标签的下一个标签开始，这样时间复杂度为O(n2)
	//换种思路，时间复杂度为O(n)，对数组进行一次遍历，记录下0的个数，同时将后面非零值往前移动，移动的位数为他前面的0的个数，最后根据0的个数在数组最后一次插入0
	//这样操作个数为0个数的2倍。
	public void moveZeroes(int[] nums){
		int len = nums.length;
		int count = 0;
		for(int i=0;i<len;i++){
			if(nums[i] == 0){
				count++;
			}else{
				nums[i-count] = nums[i];
			}
		}
		for(int i=0;i<count;i++){
			nums[len-1-i] = 0;
		}
	}
}
