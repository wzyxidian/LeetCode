package cn.edu.xidian.sselab.string;

import java.util.Stack;

/**
 * 
 * @author zhiyong wang
 * title: Valid Parentheses
 * content:
 * 	Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 */
public class ValidParentheses {

	//这个题既然是成对出现的，第一个想到的就应该是栈，成对用栈的出入来表示，只要是匹配成功就弹栈，这样栈最后就为空，弹的元素一定是与之匹配的元素
	public boolean isValid(String s){
		int len = s.length();
		if(s == null || len < 2) return false;
		Stack stack = new Stack();
		char temp;
		for(int i=0;i<len;i++){
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
				stack.push(s.charAt(i));
			if(s.charAt(i) == ')'){
				if(stack.isEmpty() || (char) stack.pop() != '(') return false;
			}
			if(s.charAt(i) == ']'){
				if(stack.isEmpty() || (char) stack.pop() != '[') return false;
			}
			if(s.charAt(i) == '}'){
				if(stack.isEmpty() || (char) stack.pop() != '{') return false;
			}
		}
		return stack.isEmpty();
	}
}
