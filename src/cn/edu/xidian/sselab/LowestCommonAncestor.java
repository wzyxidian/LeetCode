package cn.edu.xidian.sselab;
/**
 * title:Lowest Common Ancestor of a Binary Search Tree
 * content:
 * Given a binary search tree (BST), 
 * find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *      _______6______
 *     /              \
 *  ___2__          ___8__
 * /      \        /      \
 * 0      _4       7       9
 *       /  \
 *       3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. 
 * Another example is LCA of nodes 2 and 4 is 2, 
 * since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestor {

	 public class TreeNode 
	 {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) 
	      {
	    	val = x; 
	     }
	}
	 
	 /**
	  * 二叉排序树又叫二叉查找树，英文名称是：Binary Sort Tree. Binary Search Tree
	  * BST的定义就不详细说了，我用一句话概括：左 < 中 < 右。 根据这个原理，我们可以推断：BST的中序遍历必定是严格递增的。
	  * 先序遍历；中序遍历；后续遍历；层次遍历。事实上，知道任意两种方式，并不能唯一地确定树的结构，
	  * 但是，只要知道中序遍历和另外任意一种遍历方式，就一定可以唯一地确定一棵树
	  * 
	  * 本题目是求两个子节点的最小公共父节点，采用中序遍历的方式，因为是二叉排序树，所以无形中给了一个已知的条件
	  * 左子树小于父节点，小于右子树
	  */
	 public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
		 TreeNode lowestCommonAncestor = root;
		 if(root == null){
			 return root;
		 }else if(p == null || q == null){
			 return root;
		 }else if((p.val < root.val && q.val > root.val)||(p.val > root.val && q.val < root.val)){
			 return root;
		 }else if(p.val < root.val && q.val < root.val){
			 lowestCommonAncestor = lowestCommonAncestor(root.left, p, q);
		 }else if(p.val > root.val && q.val > root.val){
			 lowestCommonAncestor = lowestCommonAncestor(root.right, p, q);
		 }
		 return lowestCommonAncestor;
	 }
	 
	 
}
