package cn.edu.xidian.sselab;

import java.util.LinkedList;
import java.util.Stack;

public class TreeTraverse {

	private final static int[] array = new int[]{1,2,3,4,5,6,7,8,9};
	public static LinkedList<TreeNode> nodeList;
	/**
	 * @author wzy
	 * @param args
	 * @see Ҫ�Զ��������б������ȵ�һ������Ҫ��������������1������ڵ㣨2�����������ȫ��ת���ɽڵ�
	 * ��3�������ڵ�֮��ĸ��ӹ�ϵ��4������һ�ַ�ʽ���б���
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeTraverse bh = new TreeTraverse();
		bh.createBinTree();
		System.out.println("���������");
		bh.preOrderTraverse(nodeList.get(0));
		System.out.println("���������");
		bh.inOrderTraverse(nodeList.get(0));
		System.out.println("���������:");
		bh.postOrderTraverse(nodeList.get(0));
		System.out.println("���������");
		bh.preOrderTraverse2(nodeList.get(0));
		System.out.println("���������");
		bh.inOrderTraverse2(nodeList.get(0));
		System.out.println("���������:");
		bh.postOrderTraverse(nodeList.get(0));
		
	}
	
	//����ڵ�
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
	
	//��������
	public void createBinTree(){
		nodeList = new LinkedList<TreeNode>();
		int arrayLen = array.length;
		//��һ�������ֵһ��ת��ΪTreeNode�ڵ�
		for(int i=0;i<arrayLen;i++){
			nodeList.add(new TreeNode(array[i]));
		}		
		int MaxFatherIndex = arrayLen / 2 - 1;//���ڵ�ĸ����Ǽ�ס�ڵ��±��Ǵ�0��ʼ��ǵ�
		//�����һ�����ڵ�֮ǰ�����еĸ��ڵ㰴�ո��ڵ��뺢�ӽڵ�֮������ֹ�ϵ����������
		for(int parentIndex = 0;parentIndex < MaxFatherIndex; parentIndex++){
			nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
			nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
		}
		//�����һ�����ڵ㵥������
		nodeList.get(MaxFatherIndex).leftChild = nodeList.get(MaxFatherIndex * 2 + 1);
		if(arrayLen % 2 == 1){
			nodeList.get(MaxFatherIndex).rightChild = nodeList.get(MaxFatherIndex * 2 + 2);		
		}			
	}

	//�������
	public static void preOrderTraverse(TreeNode node){
		if(node == null){
			return ;
		}
		System.out.println(node.val + " ");
		preOrderTraverse(node.leftChild);
		preOrderTraverse(node.rightChild);
	}
	
	//�������
	public static void inOrderTraverse(TreeNode node){
		if(node == null){
			return ;
		}
		inOrderTraverse(node.leftChild);
		System.out.println(node.val + " ");
		inOrderTraverse(node.rightChild);
	}
	
	//�������
	public static void postOrderTraverse(TreeNode node){
		if(node == null){
			return ;
		}
		postOrderTraverse(node.leftChild);
		postOrderTraverse(node.rightChild);
		System.out.println(node.val + " ");
	}
	
	//�ǵݹ��������
	//��ջ��˼�룬�������·��ʵĽڵ�
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
	
	//�ǵݹ��������
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
	
	//�ǵݹ�ʵ�ֺ������,
	//������������ջ��һ��������ǣ�һ��������ڵ�
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
