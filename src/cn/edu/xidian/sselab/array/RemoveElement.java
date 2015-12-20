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

	//�������MoveZeroes����ͬ��˼·��MoveZeroes�ǽ����е�0�ƶ������������棬
	//������Ŀ�ǽ�valֵȫ���滻������ʱ��val����0���͸�MoveZeroes����ȫһ������Ŀ��
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
