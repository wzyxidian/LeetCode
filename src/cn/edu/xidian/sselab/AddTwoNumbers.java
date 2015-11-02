package cn.edu.xidian.sselab;

import java.util.ArrayList;
/**
 * title:Add Two Numbers
 * content:
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 *  Add the two numbers and return it as a linked list.
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbers atn = new AddTwoNumbers();
		
		ListNode l1 = atn.new ListNode(5);
		ListNode l2 = atn.new ListNode(5);
		ListNode ls = AddTwoNumbers.addTwoNumbers(l1, l2);
		System.out.println(ls.val);
		System.out.println(ls.next.val);
	}

	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){
			val = x;
		}
	}
	
	//自己的思路，一开始：定义一个ListNode对象，让他指向l1，结果发现l1在不断的变化，这个对象也跟着一起到了队尾，然后就发现通过这种
	//这种指向方法而不创建对象来做是不可行的
	//接下来换了第二种思路，没加一次就创建一个保存和的对象，然后把这些对象都放到List容器里面，最后建立对象之间的链表关系，拿出第一个对象
	//作为返回值就可以了。
	//这里用到了数据结构里面最基本的方法，三个while循环，加一个判断最后一个节点根据进位值要不要新建
	public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
		int temp = 0;
		int trade = 0;
		int tail = 0;
		ArrayList<ListNode> arr = new ArrayList<ListNode>();
		while(l1 != null && l2 != null){
			temp = l1.val + l2.val + trade;
			tail = temp % 10;
			trade = temp / 10;
			AddTwoNumbers atn = new AddTwoNumbers();
			ListNode ll = atn.new ListNode(tail);
			arr.add(ll);
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1 != null){
			temp = l1.val + trade;
			tail = temp % 10;
			trade = temp / 10;
			AddTwoNumbers atn = new AddTwoNumbers();
			ListNode ll = atn.new ListNode(tail);
			arr.add(ll);
			l1 = l1.next;
		}
		while(l2 != null){
			temp = l2.val + trade;
			l1 = l2;
			tail = temp % 10;
			trade = temp / 10;
			AddTwoNumbers atn = new AddTwoNumbers();
			ListNode ll = atn.new ListNode(tail);
			arr.add(ll);
			l2 = l1.next;
		}
		if(trade != 0){
			AddTwoNumbers atn = new AddTwoNumbers();
			ListNode last = atn.new ListNode(trade);
			arr.add(last);
			l1 = last;
		}
		int len = arr.size();
		for(int i=0;i<len-1;i++){
			arr.get(i).next = arr.get(i+1);
		}
		return arr.get(0);
		
	}
	
	//参考别人的思路，通过直接新建一个链，思路非常明确，而且很巧妙,将我原来的三个while循环合并成一个循环了。
	public ListNode addTwoNumber(ListNode l1,ListNode l2){
		ListNode result = new ListNode(0);
		ListNode temp = result;
		int sum = 0;
		while(l1 != null || l2 != null){
			sum /= 10;
			if(l1 != null){
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				sum += l2.val;
				l2 = l2.next;
			}
			temp.next = new ListNode(sum % 10);
			temp = temp.next;
		}
		if(sum / 10 == 1){
			temp.next = new ListNode(1);
		}
		return result.next;
	}
	
}
