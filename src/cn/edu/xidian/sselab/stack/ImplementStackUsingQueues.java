package cn.edu.xidian.sselab.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author zhiyong wang
 * title: Implement Stack using Queues
 * content:
 *mplement the following operations of a stack using queues.
 *
 *    push(x) -- Push element x onto stack.
 *    pop() -- Removes the element on top of the stack.
 *    top() -- Get the top element.
 *    empty() -- Return whether the stack is empty.
 *
 *Notes:
 *
 *    You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 *    Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 *    You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 *
 */
public class ImplementStackUsingQueues {

	List queue = new LinkedList<Integer>();
	public void push(int x){
		queue.add(x);
	}
	public void pop(){
		if(queue != null)
			queue.remove(queue.size()-1);
	}
	public int top(){
		return (int) queue.get(queue.size() -1);
	}
	public boolean empty(){
		return queue.isEmpty();
	}
	
}
