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

	//上来自己没有理解题意，以为是找到每一行的最小数据，然后求和，所以得到下面的结果，
	//后来发现是错误的
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
		
	//参考答案用动态规划,时间复杂度是O(n^2)
	//从第一个元素开始考虑，一直往下走，求出每行每一个点的值，最后对最后一行进行遍历，得到最小的结果
	//不要需要注意第一行（只有一个顶点），每一行的第一个值与最后一个值，不用进行比较，只有一个结果
	//从上到下， 下一行的结果根据上一行的路径累计和而计算。
	//triangle[i][j] += min(triangle[i -1 [j -1 ],triangle[i -1 ][j ] ) 
	public int minimumTotals(List<List<Integer>> triangle){
		int length = triangle.size();
		List<List<Integer>> result = new ArrayList<List<Integer>>(length);
		for(int i=0;i<length;i++){
			List<Integer> lines = triangle.get(i);
			result.add(new ArrayList<Integer>(lines.size()));//关键所在
			if(i==0){
				//第一行
				result.get(0).add(lines.get(0));
			}else {
				int size = lines.size();
				for(int j=0;j<size;j++){
					if(j==0){
						//每一行的第一个数字
						result.get(i).add(result.get(i-1).get(0) + lines.get(0));
					}else if(j==size-1){
						//每一行的最后一个数字
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
	
	
	//参考了大神为了不考虑边界问题，转为从下往上进行求解
   /*键之处在于逆向思维。 
    * 根据题意会自然而然地想从上而下逐层寻找最优解，但是由于下层元素比上层多， 
    * 边界处的计算非常繁琐。但是如果自下而上，逐层计算到当前层的最优解，那么 
    * 到达最顶端时，就是所求最优解。 
    */ 
	public int minimumTotal2(List<List<Integer>> triangle){
		int length = triangle.size();
		//首先考虑特殊情况
		if(triangle == null || length == 0)return 0;
		if(length == 1) return triangle.get(0).get(0);
		int[] below = new int[length];//用于保存下一行的最优解，
		int[] cur = new int[length];//用于保存当前行的最优解
		
		//初始化最下面一行的值
		for(int i=0;i<length;i++){
			below[i] = triangle.get(length-1).get(i);
		}
		//自底向上开始求最优解
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
