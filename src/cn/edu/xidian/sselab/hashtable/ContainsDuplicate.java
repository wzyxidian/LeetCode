package cn.edu.xidian.sselab.hashtable;

import java.util.HashSet;
/**
 * title:Contains Duplicate
 * content:
 * Given an array of integers, find if the array contains any duplicates.
 *Your function should return true if any value appears at least twice in the array, 
 *and it should return false if every element is distinct. 
 */
public class ContainsDuplicate {

	/**
	 * @author wzy
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{12,2,3,4};
		ContainsDuplicate cd = new ContainsDuplicate();
		long t1 = System.currentTimeMillis();
		cd.containsDuplicate(nums);
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		
	}

	//������ж�һ���������Ƿ����������ͬ��ֵ
	//Ϊ��ʹʱ�临�ӶȱȽϵͣ����ԴﵽO(n)�ĳ̶ȣ�������Խ�ȡ������ֵ�ŵ�HashSet��Hashtable��ArrayList���У�
	//��Ϊ��Щ����������contains������֮�õ������ǵĽӿھͿ��Խ����ж��Ƿ�����ͬ�Ĵ���
	//��������б����������ֵ�ŵ������У�Ȼ���ж��Ƿ���ͬ��ֵ��Ҫע�����������жϺ���
	public boolean containsDuplicate(int[] nums){	
		int len = nums.length;
		HashSet<Integer> temp = new HashSet<Integer>();
		for(int i=0;i<len;i++){			
			if(temp.contains(nums[i]))
				return true;
			temp.add(nums[i]);
		}
		return false;
	}
}
