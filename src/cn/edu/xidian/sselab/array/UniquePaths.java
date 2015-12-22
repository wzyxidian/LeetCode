package cn.edu.xidian.sselab.array;

/**
 * 
 * @author zhiyong wang
 * title: Unique Paths
 * content:
 * 	 	robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 		The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 		How many possible unique paths are there?
 * �����������Ľ���������ո�Ļ�����Ľ����б��PascalTriangle
 * 
 * 1 1 1 1
 * 1 2 3 4
 * 1 3 6 10
 * 1 4 10 20
 * ��4*4�ı������20��·��	 
 *
 */
public class UniquePaths {

	//��һ��ӦӦ���ǵݹ�,
	//�ݹ�Ҫ��Լ�����������Դ��յ���ǰ�����ߣ���1,1������m,n����·���͵��ڣ�1,1������m-1,n���루m��n-1��·��֮��
	//�ܽ��������Լ��ݹ����ʶ���ǲ���ǿ
	//��������˼·��ʱ��
	public int uniquePaths(int m,int n){
		if(m==1 || n==1)
			return 1;
		else{
			return uniquePaths(m-1,n) + uniquePaths(m,n-1);
		}
	}
	
	//�������ѧ����ⷽ�����ӣ�1��1������m,n�����ܲ�����һ����m + n - 2;
	//��Ϊֻ�����ң��������ߣ����������ߵĲ���Ҳ��ȷ����n-1,�����ߵĲ���Ҳ��ȷ����m-1;
	//·������Ϊ��C(m+n-2) (m-1)����m+n-2��!/(m-1)!(n-1)!
	public int uniquePath(int m,int n){
		int all = n + m - 2;
		int down = m - 1;
		double total = 1;//ע������ط�һ��ʼ������int������м����������أ����½������ȷ
		for(int i=1;i<=down;i++){
			total = total * (all-down+i) / i;
		}
		return (int)total;
	}
}
