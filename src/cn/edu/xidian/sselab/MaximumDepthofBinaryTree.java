package cn.edu.xidian.sselab;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthofBinaryTree {

	/**
	 * @author wzy
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumDepthofBinaryTree m = new MaximumDepthofBinaryTree();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		TreeNode r1 = root.left;
		TreeNode r2 = root.right;
		r1.left = new TreeNode(3);
		
		int result = m.maxDepth(root);
		System.out.println(result);
	}
	
	//��������ȵ�����������������������ڵ���ڣ����ڵ㲻����	
	public int maxDepth(TreeNode root){
		if(root == null)
			return 0;
		int maxDepth = 1;
		return maxDepthPart(root,maxDepth);
	}
	
	//�����ڵ����ʱ���ַ������������1�����ҽڵ㶼Ϊ�գ�2����ڵ�Ϊ�գ�3���ҽڵ�Ϊ�գ�4�����ҽڵ㶼��Ϊ��
	//���õݹ�ķ�ʽ���ÿ������µ�������
	public int maxDepthPart(TreeNode node, int max){
		if(node.left == null && node.right == null) 
			return max;
		else if(node.left == null && node.right != null)
			return maxDepthPart(node.right,max + 1);
		else if(node.left != null && node.right == null)
			return maxDepthPart(node.left, max + 1);
		return Math.max(maxDepthPart(node.left, max + 1),maxDepthPart(node.right, max + 1));	
	}

}