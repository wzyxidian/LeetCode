package cn.edu.xidian.sselab.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author zhiyong wang
 * title: simplify Path
 * content:
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 */
public class SimplifyPath {

	//弹出，匹配问题，想到用栈来实现，同时遇到分割问题想到split函数
	//看了Deque源码才发现，只有push() 与pop()方法是stack方法。所以这里可以用做栈
	public String simplifyPath(String path){	
			//下面这两行是等价的
//			Deque<String> stack = new LinkedList<String>();
			Stack<String> stack = new Stack();
			Set set = new HashSet<>(Arrays.asList("..",".",""));//这行代码学习一下
			for(String str : path.split("/")){
				if(str.equals("..") && !stack.isEmpty()) stack.pop();
				else if(!set.contains(str)) stack.push(str);
			}
			String res = "";
			
			while(!stack.isEmpty()){
				res = "/" + stack.pop() + res;
			}
			return res.isEmpty() ? "/" : res;
	}
}
