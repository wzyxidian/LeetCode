package cn.edu.xidian.sselab.array;

/**
 * 
 * @author zhiyong wang
 * title:Remove Element
 * content:
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length. 
 *
 */
public class RemoveElement {

	//这个题与MoveZeroes是相同的思路，MoveZeroes是将所有的0移动到数组的最后面，
	//而本题目是将val值全被替换掉，此时的val换成0，就跟MoveZeroes是完全一样的题目了
	public int removeElement(int[] nums, int val){
		int length = nums.length;
		int count = 0;
		for(int i=0;i<length;i++){
			if(nums[i] == val){
				count++;
			}else{
				nums[i-count] = nums[i];
			}
		}
		return length - count;
	}
}
