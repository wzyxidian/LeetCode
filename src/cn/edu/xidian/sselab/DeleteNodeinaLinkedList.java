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
	 * @see 这个题是给定一个单链表，给你要删除的节点，然后目标是删除这个节点，维持单链表的其它都不变
	 * 变量中只给定了要删除的节点，如果对其删除操作，因为单链表其前一个节点是不知道的，
	 * 所以他的前一个节点就会找不到下一个节点，这种情况时不允许的。
	 * 这里换一种思路，把要删除的节点A的下一个节点B的值赋给A，然后让A指向B的下一个节点，这样虽然删除的是规定节点的下一个节点
	 * 但是删除的确实规定节点的值，所以满足要求
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
