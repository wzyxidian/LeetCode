package cn.edu.xidian.sselab.array;

/**
 * 
 */
public class RotateArray {

	//自己做出来的，不过一开始没有读懂题目的意思，后来又忽视了几个问题
	//(1)k可以大于数组长度，这个时候对数组长度取模就可以
	//(2)对三次对换数组求中间数迷糊了，这个要想清楚
	//这个题的思路是先将取模之后的k之前的数字逆序交换，然后将之后的数逆序交换，最后对整个数组进行逆序交换，刚好求得结果
	//当然，先交换所有的数字，然后交换k个数字，然后把其余的数字交换得到相同的结果
	//这个可以将三个转换操作写成一个方法
	public void rotate(int[] nums,int k){
		int len = nums.length;
        if(k==0){
            return;
        }
        k = k % len;
		int mid = (len -k) / 2;
		int mid1 = len- (k / 2);
		int mid2 = len / 2;
		for(int i=0;i<mid;i++){
			int temp = nums[i];
			nums[i] = nums[len-k-i-1];
			nums[len-k-i-1] = temp;
		}
		int count = 0;
		for(int i=len-k;i<mid1;i++){
			int temp = nums[i];
			nums[i] = nums[len-1-count];
			nums[len-1-count] = temp;
			count++;
		}
		for(int i=0;i< mid2;i++){
			int temp = nums[i];
			nums[i] = nums[len-i-1];
			nums[len-i-1]= temp;
		}
	}
	
	//还有一种比较好想的方法，是我百度出来的，取出最后一个数字，然后每个数字后移一位，直到移动k次为止
	//不过这种方法出现了时间超时问题，容易理解，但不提倡
	public void rotate1(int[] nums,int k){
		int len = nums.length;
		if(len == 1 || len == 0){
			return ;
		}
		for(int i=0;i<k;i++){
			int temp = nums[len-1];
			for(int j=len-1;j>0;j--){
				nums[j] = nums[j-1];
			}
			nums[0]= temp;
		}
	}
	
	//这个是第一个方法的改进,这个地方学到了一个新的方法，start<end
	public void rotate2(int[] nums,int k){
		int len = nums.length;
		if(len == 0 || len == 1){
			return;
		}
		k = k % len;
		reverse(nums,0,len-1);
		reverse(nums,0,k-1);
		reverse(nums,k,len-1);
	}
	private void reverse(int[] nums,int start,int end){
		int temp;
		while(start < end){
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

}
