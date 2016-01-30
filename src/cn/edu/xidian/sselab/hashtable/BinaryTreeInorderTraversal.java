package cn.edu.xidian.sselab.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author zhiyong wang
 * title: Binary Tree Inorder Traversal
 * content:
 * Given a binary tree, return the inorder(中序) traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 * 
 *    1
 *     \
 *      2
 *     /
 *    3
 * 
 * return [1,3,2]
 *
 */
public class BinaryTreeInorderTraversal {

	//with stack to solve this question
	public List<Integer> inorderTraversal(TreeNode root){
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		while(node != null || !stack.isEmpty()){
			while(node != null){
				stack.push(node);
				node = node.left;
			}
			if(!stack.isEmpty()){
				node = stack.pop();
				list.add(node.val);
				node = node.right;
			}
		}
		return list;
	}
	
	//with recursive to solve this question
	//这个地方注意三个地方：（1）if(node == null)的时候，返回的是list，而不是null
	//			       (2) 题目中定义的是left与right，而不是leftNode,rightNode
	//					(3)递归返回的结果要加到list中，所以用list.addAll();
	public List<Integer> inorderTraversals(TreeNode root){
		TreeNode node = root;
		List<Integer> list = new ArrayList<Integer>();
		if(node == null) return list;
		list.addAll(inorderTraversals(node.left));
		list.add(node.val);
		list.addAll(inorderTraversals(node.right)) ;
		return list;
	}
	
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
}