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
	
	//�Լ���˼·��һ��ʼ������һ��ListNode��������ָ��l1���������l1�ڲ��ϵı仯���������Ҳ����һ���˶�β��Ȼ��ͷ���ͨ������
	//����ָ�򷽷������������������ǲ����е�
	//���������˵ڶ���˼·��û��һ�ξʹ���һ������͵Ķ���Ȼ�����Щ���󶼷ŵ�List�������棬���������֮��������ϵ���ó���һ������
	//��Ϊ����ֵ�Ϳ����ˡ�
	//�����õ������ݽṹ����������ķ���������whileѭ������һ���ж����һ���ڵ���ݽ�λֵҪ��Ҫ�½�
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
	
	//�ο����˵�˼·��ͨ��ֱ���½�һ������˼·�ǳ���ȷ�����Һ�����,����ԭ��������whileѭ���ϲ���һ��ѭ���ˡ�
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
