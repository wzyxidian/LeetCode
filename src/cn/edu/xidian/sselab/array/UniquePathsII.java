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

	//�ݹ�û�������ô�������������������PascalTriangle
	/**
	 * 1 1 1 1
	 * 1 2 3 4
	 * 1 3 6 10
	 * 1 4 10 20
	 * ��4*4�ı������20��·�ߣ�������ϰ��Ļ������ϰ�����0���ѷ��ϰ�����1
	 * �Լ�û���������취����󿴵Ĵ𰸣�˼·�������ģ������жϣ�0��0����ֵ��Ȼ���ʼ����һ�����һ�е�ֵ��
	 * ��һ��ֵ��0��1����1��0�����н��г�ʼ����ʱ�������ǰֵ��1������Ϊ0�������0����ǰһ��ֵ������
	 * ���� ���г�ʼ����ʱ��Ҳ�ǣ���ǰֵ��1������Ϊ0�������0������һ��ֵ������
	 * ��ʼ�����֮�󣬾��Ƕ�ʣ�����е�ֵ��ʼ�����жϣ��������1������Ϊ0���������0����ȥ����ֵ��ǰ��ֵ�ĺ���Ϊ�õ��ֵ
	 */
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid){
		int length = obstacleGrid.length;
		int width = obstacleGrid[0].length;
		//��һ���ȳ�ʼ����һ�����һ��
		obstacleGrid[0][0] ^= 1;
		for(int i=1;i<width;i++)
			obstacleGrid[0][i] = obstacleGrid[0][i]==1?0:obstacleGrid[0][i-1];
		for(int i=1;i<length;i++)
			obstacleGrid[i][0] = obstacleGrid[i][0]==1?0:obstacleGrid[i-1][0];
		//�ڶ�����ʼ�����·���ĺ�
		for(int i=1;i<length;i++){
			for(int j=1;j<width;j++){
				obstacleGrid[i][j] = obstacleGrid[i][j]==1?0:obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
			}
		}
		return obstacleGrid[length-1][width-1];
	}
	
}
