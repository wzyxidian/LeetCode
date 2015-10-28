package cn.edu.xidian.sselab;
/**
 * title:Lowest Common Ancestor of a Binary Search Tree
 * content:
 * Given a binary search tree (BST), 
 * find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia:
 * ��The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).��
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
	  * �����������ֽж����������Ӣ�������ǣ�Binary Sort Tree. Binary Search Tree
	  * BST�Ķ���Ͳ���ϸ˵�ˣ�����һ�仰�������� < �� < �ҡ� �������ԭ�����ǿ����ƶϣ�BST����������ض����ϸ�����ġ�
	  * ������������������������������α�������ʵ�ϣ�֪���������ַ�ʽ��������Ψһ��ȷ�����Ľṹ��
	  * ���ǣ�ֻҪ֪�������������������һ�ֱ�����ʽ����һ������Ψһ��ȷ��һ����
	  * 
	  * ����Ŀ���������ӽڵ����С�������ڵ㣬������������ķ�ʽ����Ϊ�Ƕ��������������������и���һ����֪������
	  * ������С�ڸ��ڵ㣬С��������
	  * ������p,q ��rootС, ��LCA�ض���������, ���p,q��root��, ��LCA�ض���������. ���һ��һС, ��root��ΪLCA.
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
