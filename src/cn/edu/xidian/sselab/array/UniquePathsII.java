package cn.edu.xidian.sselab.array;

/**
 * 
 * @author zhiyong wang
 * title:	Unique Paths II
 * content:
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 *		[
 *		  [0,0,0],
 *		  [0,1,0],
 *		  [0,0,0]
 *		]
 *
 *	The total number of unique paths is 2.
 *
 */
public class UniquePathsII {

	//递归没有想出怎么做来，不过这个是类似PascalTriangle
	/**
	 * 1 1 1 1
	 * 1 2 3 4
	 * 1 3 6 10
	 * 1 4 10 20
	 * 即4*4的表，最多有20条路线，如果有障碍的话，把障碍换成0，把非障碍换成1
	 * 自己没有想出解决办法，最后看的答案：思路是这样的，首先判断（0，0）的值，然后初始化第一行与第一列的值，
	 * 第一个值遇0变1，遇1变0，对行进行初始化的时候，如果当前值是1，则置为0，如果是0，则前一个值赋予它
	 * 对列 进行初始化的时候也是，当前值是1，则置为0，如果是0，则将上一个值赋予它
	 * 初始化完成之后，就是对剩余所有的值开始进行判断，如果遇到1，则置为0，如果遇到0，则去上面值与前面值的和作为该点的值
	 */
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid){
		int length = obstacleGrid.length;
		int width = obstacleGrid[0].length;
		//第一步先初始化第一行与第一列
		obstacleGrid[0][0] ^= 1;
		for(int i=1;i<width;i++)
			obstacleGrid[0][i] = obstacleGrid[0][i]==1?0:obstacleGrid[0][i-1];
		for(int i=1;i<length;i++)
			obstacleGrid[i][0] = obstacleGrid[i][0]==1?0:obstacleGrid[i-1][0];
		//第二步开始求最后路径的和
		for(int i=1;i<length;i++){
			for(int j=1;j<width;j++){
				obstacleGrid[i][j] = obstacleGrid[i][j]==1?0:obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
			}
		}
		return obstacleGrid[length-1][width-1];
	}
	
}
