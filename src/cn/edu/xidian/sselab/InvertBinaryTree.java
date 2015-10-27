package cn.edu.xidian.sselab;

/**
 * title:Invert Binary Tree
 * content:
 * nvert a binary tree. 
 *     4
 *   /   \
 *  2     7
 * / \   / \
 *1   3 6   9
 *to
 *     4
 *   /   \
 *  7     2
 * / \   / \
 *9   6 3   1
 */
public class InvertBinaryTree {

	/**
	 * @author wzy
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int x){
			val = x;
		}
	}
	//˼·�������һ��ʼ��������ͷ�����Ե�ʱ����⣬��ʱ�����ر��鷳����û�������������ڻ���û�������������˽��������һ��
	//�Ժ�����������Ŀ����һ��Ӧһ��Ҫ�У��ݹ顢�ݹ顢�ݹ飬���õݹ���б���
	//�����һ��ʼ�����ˣ���������ǿ��һ�£��ݹ���ֹ�������ǵ������սڵ����Ҷ�ӽڵ�ʱ�����ٽ��н�����ֱ�ӷ��ظýڵ㣬���������ڵ�
	//�ֱ𽻻���������������������Ȼ�󽫽�������������������ҽڵ㣬������������ڵ㣬�����������нڵ㣬
	//�����õ����Ǻ�����������¶��ϵĽ������������������Ļ���Ҫ���϶��½��н�����
	public TreeNode invertTree(TreeNode root){
		if(root == null || (root.left == null && root.right == null))
			return root;
		TreeNode newLeft = invertTree(root.right);
		TreeNode newRight = invertTree(root.left);
		root.left = newLeft;
		root.right = newRight;
		return root;
	}

}
