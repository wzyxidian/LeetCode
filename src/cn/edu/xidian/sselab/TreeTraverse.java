package cn.edu.xidian.sselab;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Stack;

public class TreeTraverse {

	private final static int[] array = new int[]{1,2,3,4,5,6,7,8,9};
	public static LinkedList<TreeNode> nodeList;
	/**
	 * @author wzy
	 * @param args
	 * @see 要对二叉树进行遍历，首先第一步就是要构建二叉树，（1）定义节点（2）将给定的数组全部转换成节点
	 * （3）建立节点之间的父子关系（4）先用一种方式进行遍历
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeTraverse bh = new TreeTraverse();
		bh.createBinTree();
		System.out.println("先序遍历结果：");
		bh.preOrderTraverse(nodeList.get(0));
		System.out.println("中序遍历结果：");
		bh.inOrderTraverse(nodeList.get(0));
		System.out.println("后序遍历结果:");
		bh.postOrderTraverse(nodeList.get(0));
		System.out.println("先序遍历结果：");
		bh.preOrderTraverse2(nodeList.get(0));
		System.out.println("中序遍历结果：");
		bh.inOrderTraverse2(nodeList.get(0));
		System.out.println("后序遍历结果:");
		bh.postOrderTraverse(nodeList.get(0));
		
	}
	
	//定义节点
	private static class TreeNode{
		int val;
		TreeNode leftChild;
		TreeNode rightChild;
		TreeNode(int data){
			leftChild = null;
			rightChild = null;
			val = data;
		}
	}
	
	//建二叉树
	public void createBinTree(){
		nodeList = new LinkedList<TreeNode>();
		int arrayLen = array.length;
		//将一个数组的值一次转换为TreeNode节点
		for(int i=0;i<arrayLen;i++){
			nodeList.add(new TreeNode(array[i]));
		}		
		int MaxFatherIndex = arrayLen / 2 - 1;//父节点的个数，但是记住节点下标是从0开始标记的
		//对最后一个父节点之前的所有的父节点按照父节点与孩子节点之间的数字关系建立二叉树
		for(int parentIndex = 0;parentIndex < MaxFatherIndex; parentIndex++){
			nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
			nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
		}
		//对最后一个父节点单独处理
		nodeList.get(MaxFatherIndex).leftChild = nodeList.get(MaxFatherIndex * 2 + 1);
		if(arrayLen % 2 == 1){
			nodeList.get(MaxFatherIndex).rightChild = nodeList.get(MaxFatherIndex * 2 + 2);		
		}			
	}

	//先序遍历
	public static void preOrderTraverse(TreeNode node){
		if(node == null){
			return ;
		}
		System.out.println(node.val + " ");
		preOrderTraverse(node.leftChild);
		preOrderTraverse(node.rightChild);
	}
	
	//中序遍历
	public static void inOrderTraverse(TreeNode node){
		if(node == null){
			return ;
		}
		inOrderTraverse(node.leftChild);
		System.out.println(node.val + " ");
		inOrderTraverse(node.rightChild);
	}
	
	//后序遍历
	public static void postOrderTraverse(TreeNode node){
		if(node == null){
			return ;
		}
		postOrderTraverse(node.leftChild);
		postOrderTraverse(node.rightChild);
		System.out.println(node.val + " ");
	}
	
	//非递归先序遍历
	//用栈的思想，保存最新访问的节点
	public static void preOrderTraverse2(TreeNode node){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(node != null || !stack.empty()){
			while(node != null){
				System.out.println(node.val + " ");
				stack.push(node);
				node = node.leftChild;				
			}
			if(!stack.empty()){
				node = stack.pop();
				node = node.rightChild;
			}
		}
	}
	
	//非递归中序遍历
	public static void inOrderTraverse2(TreeNode node){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(node != null || !stack.empty()){
			while(node != null){
				stack.push(node);
				node = node.leftChild;
			}
			if(!stack.empty()){
				node = stack.pop();
				System.out.println(node.val + " ");
				node = node.rightChild;
			}
		}
	}
	
	//非递归实现后序遍历,
	//这里用了两个栈，一个用来标记，一个用来存节点
	public static void postOrderTraverse2(TreeNode node){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> stack1 = new Stack<Integer>();
		
		while(node != null || !stack.empty()){
			while(node != null){
				stack.push(node);
				stack1.push(0);
				node = node.leftChild;
			}
			while(!stack.empty() && stack1.peek() == 1){
				stack1.pop();
				System.out.println(stack.pop().val);
				
			}
			if(!stack.empty()){
				stack1.pop();
				stack1.push(1);
				node = stack.peek();
				node = node.rightChild;
			}
		}
	}
}
