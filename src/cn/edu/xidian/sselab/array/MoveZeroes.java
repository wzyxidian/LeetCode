package cn.edu.xidian.sselab.array;

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
	//����һ�����飬�����е�0ֵ���ƶ�����������ͬʱ���ı��������λ�á�����ʹ�����鸴�Ʋ�������Ҫʹ��������С
	//�����ʼ�뷨������������ǩ��һ��������ʾ������ѭ������ֵ��λ�ã��ڶ�����ǩ����һ����ǩ����һ����ǩ��ʼ������ʱ�临�Ӷ�ΪO(n2)
	//����˼·��ʱ�临�Ӷ�ΪO(n)�����������һ�α�������¼��0�ĸ�����ͬʱ���������ֵ��ǰ�ƶ����ƶ���λ��Ϊ��ǰ���0�ĸ�����������0�ĸ������������һ�β���0
	//������������Ϊ0������2����
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
