package cn.edu.xidian.sselab.array;

/**
 * 
 * @author zhiyong wang
 * title: Unique Paths
 * content:
 * 	 	robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 		The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 		How many possible unique paths are there?
 * 发现了这个题的结果如果是填空格的话，填的结果是斜的PascalTriangle
 * 
 * 1 1 1 1
 * 1 2 3 4
 * 1 3 6 10
 * 1 4 10 20
 * 即4*4的表，最多有20条路线	 
 *
 */
public class UniquePaths {

	//第一反应应该是递归,
	//递归要有约束条件，所以从终点向前进行走，（1,1）到（m,n）的路径和等于（1,1）到（m-1,n）与（m，n-1）路径之和
	//总结起来，自己递归的意识还是不够强
	//但是这种思路超时了
	public int uniquePaths(int m,int n){
		if(m==1 || n==1)
			return 1;
		else{
			return uniquePaths(m-1,n) + uniquePaths(m,n-1);
		}
	}
	
	//用组合数学的求解方法，从（1，1）到（m,n）的总步数是一定的m + n - 2;
	//因为只能向右，与向下走，所以向右走的步数也是确定的n-1,向下走的步数也是确定的m-1;
	//路径总数为：C(m+n-2) (m-1)即（m+n-2）!/(m-1)!(n-1)!
	public int uniquePath(int m,int n){
		int all = n + m - 2;
		int down = m - 1;
		double total = 1;//注意这个地方一开始定义是int，会把中间结果处理严重，导致结果不正确
		for(int i=1;i<=down;i++){
			total = total * (all-down+i) / i;
		}
		return (int)total;
	}
}
