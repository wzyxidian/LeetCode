package cn.edu.xidian.sselab.stack;

import java.util.Stack;


/**
 * 
 * @author zhiyong wang 
 * title: Min Stack
 * content:
 *  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *  
 *      push(x) -- Push element x onto stack.
 *      pop() -- Removes the element on top of the stack.
 *      top() -- Get the top element.
 *      getMin() -- Retrieve the minimum element in the stack.
 *      一开始没弄懂这个题的意思，现在搞懂了：最小栈相当于一个辅助栈，用来存储另一一个栈的最小元素的集合：
 *      具体可以这样理解，因为push(x),pop(),top()都可以在O(1)时间内完成，但是getMin()获取最小值的这种操作就不能在O(1)时间内完成
 *      所以这里借助了最小栈的概念
 *      （1）push的时候，stack肯定会存放数据，如果最小栈是空的或者最小栈的栈顶元素小于要存放数据元素，最小栈也会存放数据【这样最小栈一直维护着一个从栈顶到栈底是由小到大排序的】，否则最小栈不存放数据
 *      （2）pop的时候，如果stack是空的则不管，如果不是空的，则弹出栈顶元素，如果最小栈不是空的，并且栈顶元素与stack栈弹出的元素相等，那么最小栈也需要弹出栈顶元素
 *      （3）top的时候，观察stack是否为空，如果为空则不管，如果不为空，则查看栈顶元素，与最小栈没有关系
 *      （4）getMin的时候，这个时候跟stack是没有关系的，如果最小栈不为空，在查看栈顶元素
 *  
 *
 */
public class MinStack {
	
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int x){
		stack.push(x);
		if(minStack.isEmpty() || minStack.peek() >= x)
			minStack.push(x);		
	}
	
	public void pop(){
		if(stack.isEmpty())
			return ;
		int temp = stack.pop();
		if(!minStack.isEmpty() && temp == minStack.peek())
			minStack.pop();
	}
	
	public int top(){		
		return stack.peek();
	}
	
	public int getMin(){
		return minStack.peek();		
	}
}
