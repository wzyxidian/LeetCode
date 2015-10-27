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
	//思路，这个题一开始是做今日头条笔试的时候的题，当时做的特别麻烦，还没有做出来，现在还是没有做出来，看了结果分析了一下
	//以后遇到树的题目，第一反应一定要有：递归、递归、递归，利用递归进行遍历
	//这个题一开始理解错了，现在重新强调一下，递归终止的条件是当遇到空节点或者叶子节点时，不再进行交换，直接返回该节点，对于其他节点
	//分别交换他的左子树和右子树，然后将交换过后的左子树赋给右节点，右子树赋给左节点，左子树赋给有节点，
	//这里用到的是后序遍历，从下而上的交换；如果是先序遍历的话，要从上而下进行交换。
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
