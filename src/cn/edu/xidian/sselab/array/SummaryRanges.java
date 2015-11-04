package cn.edu.xidian.sselab.array;

import java.util.ArrayList;
import java.util.List;
/**
 * title: Summary Ranges
 * content:
 *  Given a sorted integer array without duplicates, return the summary of its ranges.
 *  For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"]. 
 */
public class SummaryRanges {
	
	//自己花了一个多小时做的，终于成功了，知道自己没有采用最好的方法，不过思考的过程很值得借鉴
	//自己漏掉的问题很多（1）当len是0的情况没有考虑（2）切换初始值的时候，然后就把这个值给漏掉了
	//
	public static List<String> summaryRanges(int[] nums){
		ArrayList<String> arr = new ArrayList<String>();
		int len = nums.length;
		if(len == 0){
			return arr;
		}
		int temp = nums[0];
		boolean start = true;
		int i = 0;
		int point = 0;
		while(i < len-1){
			if(start){
				if(nums[i]+1 == nums[i+1]){
					i++;
				}else if(nums[i]+1 != nums[i+1]){
					if((nums[i] - temp > 1 && i - point >1)||(nums[i] - temp == 1 && i - point ==1)){
						arr.add(temp + "->" +nums[i]);
					}else{
						arr.add("" + nums[i]);
					}
					start = false;
					i++;
				}
				
			}else{
				temp = nums[i];
				point = i;
				start = true;
			}
			
		}
		if(nums[len-1]-temp == len-1-point && len !=1 ){
			arr.add(temp + "->" +nums[len-1]);
		}else if(len ==1){
			arr.add("" + nums[0]);
		}else if(point == len-2 && len != 2){
			//arr.add("" + nums[len-2]);
			arr.add("" + nums[len-1]);
		}else if(point == len-2 && len == 2){
			arr.add("" + nums[len-1]);
		}else{
			if(!start){
		
			arr.add("" + nums[len-1]);
			}else{
				arr.add(temp + "->" +nums[len-2]);
				arr.add("" + nums[len-1]);
			}
		}
		return arr;
	}
	
	//参考了比较优秀的解法，而且特别好理解，首先判断len为0或者len为1的情况
	//然后使用共同的i作为自变量来进行判断是否相邻
	public static List<String> summaryRange(int[] nums){
		int len = nums.length;
		ArrayList<String> arr = new ArrayList<String>();
		if(len == 0)
			return arr;
		if(len == 1){
			arr.add(""+nums[0]);
			return arr;
		}		
		for(int i=0;i<len;i++){
			int a = nums[i];
			while(i + 1 < len && nums[i+1] -nums[i] == 1)
				i++;
			if(a != nums[i]){
				arr.add(a + "->" + nums[i]);
			}else{
				arr.add("" + a);
			}
			
		}
		return arr;
	}
}
