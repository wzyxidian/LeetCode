package cn.edu.xidian.sselab.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zhiyong wang
 * title:	Triangle
 * content:
 * 		Given a triangle, find the minimum path sum from top to bottom. 
 * 		Each step you may move to adjacent numbers on the row below.
 * 		For example, given the following triangle
 * 
 *			[
 *			     [2],
 *			    [3,4],
 *			   [6,5,7],
 *			  [4,1,8,3]
 *			]
 *
 *	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 *	Note:
 *		Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
 *
 */
public class Triangle {

	//�����Լ�û��������⣬��Ϊ���ҵ�ÿһ�е���С���ݣ�Ȼ����ͣ����Եõ�����Ľ����
	//���������Ǵ����
	public int minimumTotal(List<List<Integer>> triangle){
		int length = triangle.size();
//			int[] result = new int[length];
		int result = 0;
		for(int i=0;i<length;i++){
			int width = triangle.get(i).size();
			for(int j=0;j<width-1;j++){
				if(triangle.get(i).get(j) < triangle.get(i).get(j+1)){
					int big = triangle.get(i).get(j+1);
					int small = triangle.get(i).get(j);
					triangle.get(i).set(j, big);
					triangle.get(i).set(j+1, small);
				}
			}
			result += triangle.get(i).get(width-1);
		}
		System.out.println(result);
		return result;
	}
		
	//�ο����ö�̬�滮,ʱ�临�Ӷ���O(n^2)
	//�ӵ�һ��Ԫ�ؿ�ʼ���ǣ�һֱ�����ߣ����ÿ��ÿһ�����ֵ���������һ�н��б������õ���С�Ľ��
	//��Ҫ��Ҫע���һ�У�ֻ��һ�����㣩��ÿһ�еĵ�һ��ֵ�����һ��ֵ�����ý��бȽϣ�ֻ��һ�����
	//���ϵ��£� ��һ�еĽ��������һ�е�·���ۼƺͶ����㡣
	//triangle[i][j] += min(triangle[i -1 [j -1 ],triangle[i -1 ][j ] ) 
	public int minimumTotals(List<List<Integer>> triangle){
		int length = triangle.size();
		List<List<Integer>> result = new ArrayList<List<Integer>>(length);
		for(int i=0;i<length;i++){
			List<Integer> lines = triangle.get(i);
			result.add(new ArrayList<Integer>(lines.size()));//�ؼ�����
			if(i==0){
				//��һ��
				result.get(0).add(lines.get(0));
			}else {
				int size = lines.size();
				for(int j=0;j<size;j++){
					if(j==0){
						//ÿһ�еĵ�һ������
						result.get(i).add(result.get(i-1).get(0) + lines.get(0));
					}else if(j==size-1){
						//ÿһ�е����һ������
						result.get(i).add(result.get(i-1).get(j-1) + lines.get(j));
					}else{
						if(result.get(i-1).get(j-1) + lines.get(j) > result.get(i-1).get(j) + lines.get(j)){
							result.get(i).add(result.get(i-1).get(j) + lines.get(j));
						}else{
							result.get(i).add(result.get(i-1).get(j-1) + lines.get(j));
						}
					}
				}
			}
		}
		int lastLineLength = triangle.get(length-1).size();
		int min = Integer.MAX_VALUE;
		for(int i=0;i<lastLineLength;i++){
			if(min > result.get(length-1).get(i)){
				min =  result.get(length-1).get(i);
			}
		}
		return min;
	}
	
	
	//�ο��˴���Ϊ�˲����Ǳ߽����⣬תΪ�������Ͻ������
   /*��֮����������˼ά�� 
    * �����������Ȼ��Ȼ������϶������Ѱ�����Ž⣬���������²�Ԫ�ر��ϲ�࣬ 
    * �߽紦�ļ���ǳ�����������������¶��ϣ������㵽��ǰ������Ž⣬��ô 
    * �������ʱ�������������Ž⡣ 
    */ 
	public int minimumTotal2(List<List<Integer>> triangle){
		int length = triangle.size();
		//���ȿ����������
		if(triangle == null || length == 0)return 0;
		if(length == 1) return triangle.get(0).get(0);
		int[] below = new int[length];//���ڱ�����һ�е����Ž⣬
		int[] cur = new int[length];//���ڱ��浱ǰ�е����Ž�
		
		//��ʼ��������һ�е�ֵ
		for(int i=0;i<length;i++){
			below[i] = triangle.get(length-1).get(i);
		}
		//�Ե����Ͽ�ʼ�����Ž�
		for(int i=length-2;i>=0;i--){
			List<Integer> row = triangle.get(i);
			for(int j=0;j<row.size();j++){
				if(below[j] < below[j+1]){
					cur[j] = below[j] + row.get(j);
				}else{
					cur[j] = below[j+1] + row.get(j);
				}
			}
			for(int j=0;j<row.size();j++){
				below[j] = cur[j];
			}
		}
		return cur[0];
	}
}
