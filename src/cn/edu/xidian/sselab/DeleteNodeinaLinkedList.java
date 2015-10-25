package cn.edu.xidian.sselab;

import java.util.LinkedList;
/**
 * title: Delete Node in a Linked List
 * content:
 *  Write a function to delete a node (except the tail) in a singly linked list, 
 *  given only access to that node.
 *  Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 *  the linked list should become 1 -> 2 -> 4 after calling your function. 
 */
public class DeleteNodeinaLinkedList {

	/**
	 * @author wzy
	 * @param args
	 * @see ������Ǹ���һ������������Ҫɾ���Ľڵ㣬Ȼ��Ŀ����ɾ������ڵ㣬ά�ֵ����������������
	 * ������ֻ������Ҫɾ���Ľڵ㣬�������ɾ����������Ϊ��������ǰһ���ڵ��ǲ�֪���ģ�
	 * ��������ǰһ���ڵ�ͻ��Ҳ�����һ���ڵ㣬�������ʱ������ġ�
	 * ���ﻻһ��˼·����Ҫɾ���Ľڵ�A����һ���ڵ�B��ֵ����A��Ȼ����Aָ��B����һ���ڵ㣬������Ȼɾ�����ǹ涨�ڵ����һ���ڵ�
	 * ����ɾ����ȷʵ�涨�ڵ��ֵ����������Ҫ��
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<ListNode> list = new LinkedList<ListNode>();
		DeleteNodeinaLinkedList d = new DeleteNodeinaLinkedList();
		list.add(d.new ListNode(1));
		list.add(d.new ListNode(2));
		list.add(d.new ListNode(3));
		list.add(d.new ListNode(4));
		list.add(d.new ListNode(5));
		for(int i=0;i<4;i++){
			list.get(i).next = list.get(i + 1);
		}
		list.get(4).next = null;
		d.deleteNode(list.get(3));
		list.remove(3);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).val);
	}
	
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	
	public void deleteNode(ListNode node){
		if(node != null || node.next != null){
			node.val = node.next.val;
			node.next = node.next.next;
		}
	}

}
