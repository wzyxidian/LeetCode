package cn.edu.xidian.sselab.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zhiyong wang
 * title:Pascal's Triangle
 * content:
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 * 	    [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {

	//这个地方一开始自己没有考虑到每次都要新建一个数组对象来存放数据，
	//调用rows.clear();添加到最终结果里面的数据又被清空了，因为他们指向了相同的地址空间
	//还有一个自己新学习到的地方，rows.add(0,1);每次在数组的第一个位置新添加一个1，而不是替换
	//rows.set(0,1);每次将数组第一个位置的数值替换成1
	//最重要的学到的新内容：new ArrayList<Integer>(Object obj); 可以直接加参数，表示的意义是将obj的内容复制给一个新的对象
	//具体实现过程是，每次循环都在第一个位置插入1，然后对数组后面的数字相邻的两两求和，替换掉对应位置上的数值，从而得到下一个结果
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> allRows = new ArrayList<List<Integer>>();
		List<Integer> rows = new ArrayList<Integer>();
		for(int i=0;i<numRows;i++){
			rows.add(0, 1);
			for(int j=1;j<rows.size()-1;j++){
				rows.set(j, rows.get(j)+rows.get(j+1));
			}
			allRows.add(new ArrayList<Integer>(rows));
		}
		return allRows;
	}
	
}
