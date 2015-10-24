package cn.edu.xidian.sselab;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * �����������Ȼ��ǱȽ��ʺ��ú�������ķ�ʽ���ֱ������Һ��ӵ������ȣ�Ȼ�������󸸽ڵ����ȣ��ⷨ��
 * 		��Ȼ����һ�ֱȽϺ���ķ�ʽ�Ƿ�����������ֱ���������ȣ��ⷨһ
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
		
		int result1 = m.maxDepth(root);
		int result2 = m.maxDepth2(root);
		int result3 = m.maxDepth3(root);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}
	
	/**
	 * �ⷨһ��
	 */
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

	/**
	 * �ⷨ����
	 */
	public int maxDepth2(TreeNode root){
		int maxDepth = 0;
		if(root != null){
			int leftDepth = maxDepth2(root.left);
			int rightDepth = maxDepth2(root.right);
			maxDepth++;
			if(leftDepth < rightDepth){
				maxDepth = maxDepth + rightDepth;
			}else{
				maxDepth = maxDepth + leftDepth;
			}
		}
		return maxDepth;
	}
	
	/**
	 * �ⷨ����
	 */
	public int maxDepth3(TreeNode root){
		if(root == null){
			return 0;
		}
		int left = maxDepth3(root.left);
		int right = maxDepth3(root.right);
		return Math.max(left, right) + 1;
	}
}
