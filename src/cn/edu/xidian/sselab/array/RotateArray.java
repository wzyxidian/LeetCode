package cn.edu.xidian.sselab.array;

/**
 * title: Rotate Array
 * content:
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Hint:
 * Could you do it in-place with O(1) extra space?  
 */
public class RotateArray {

	//�Լ��������ģ�����һ��ʼû�ж�����Ŀ����˼�������ֺ����˼�������
	//(1)k���Դ������鳤�ȣ����ʱ������鳤��ȡģ�Ϳ���
	//(2)�����ζԻ��������м����Ժ��ˣ����Ҫ�����
	//������˼·���Ƚ�ȡģ֮���k֮ǰ���������򽻻���Ȼ��֮��������򽻻���������������������򽻻����պ���ý��
	//��Ȼ���Ƚ������е����֣�Ȼ�󽻻�k�����֣�Ȼ�����������ֽ����õ���ͬ�Ľ��
	//������Խ�����ת������д��һ������
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
	
	//����һ�ֱȽϺ���ķ��������Ұٶȳ����ģ�ȡ�����һ�����֣�Ȼ��ÿ�����ֺ���һλ��ֱ���ƶ�k��Ϊֹ
	//�������ַ���������ʱ�䳬ʱ���⣬������⣬�����ᳫ
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
	
	//����ǵ�һ�������ĸĽ�,����ط�ѧ����һ���µķ�����start<end
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
