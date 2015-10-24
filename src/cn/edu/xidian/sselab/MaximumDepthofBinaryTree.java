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
	
	//求最大的深度的主方法，分两种情况，根节点存在，根节点不存在	
	public int maxDepth(TreeNode root){
		if(root == null)
			return 0;
		int maxDepth = 1;
		return maxDepthPart(root,maxDepth);
	}
	
	//当根节点存在时，又分四种情况：（1）左右节点都为空（2）左节点为空（3）右节点为空（4）左右节点都不为空
	//采用递归的方式求得每种情况下的最大深度
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