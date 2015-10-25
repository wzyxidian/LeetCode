package cn.edu.xidian.sselab;
/**
 * title:Same Tree
 * content:
 *  Given two binary trees, write a function to check if they are equal or not.
 *  Two binary trees are considered equal if they are structurally identical and the nodes have the same value. 
 */
public class SameTree {

	/**
	 * @author wzy
	 * @param args
	 * @see 判断两棵树是否相同，不仅要看结构，同时也要看每个节点对应的值
	 * 首先想到的是对树分别进行遍历，遍历想到了递归
	 * 遍历采用的是后序遍历的方式，同时遍历都叶子节点之后要考虑四种情况
	 * （1）如果对应的节点都是null，则返回true
	 * （2）如果其中一个节点为null，另外一个节点不为null，则返回false
	 * （3）如果两个节点都不为null，但是数值不相等 ，返回false
	 * （4）如果两个节点都不为null，而且数值相等，则进行递归操作
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		}
	}
	public boolean isSameTree(TreeNode p, TreeNode q){
		boolean flag1 = false;
		boolean flag2 = false;		
		if(p == null && q == null ){
			return true;
		}else if((p == null || q == null)){
			return false;
		}else if(p.val != q.val){
			return false;			
		}else{
			flag1 = isSameTree(p.left,q.left);
			flag2 = isSameTree(p.right,q.right);
		}
		return (flag1 && flag2);
	}
		
}
