package cn.edu.xidian.sselab.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zhiyong wang
 * title:	Pascal's Triangle II
 * content:
 * 		Given an index k, return the kth row of the Pascal's triangle.
 * 		For example, given k = 3,
 * 		Return [1,3,3,1]. 
 *
 */
public class PascalTriangleII {

	//这是模仿PascalTriangle的做法做的，只不过时间复杂度是O(n^2)
	public List<Integer> getRow(int rowIndex){
		List<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<=rowIndex;i++){
			row.add(0,1);
			for(int j=1;j<row.size()-1;j++){
				row.set(j, row.get(j)+row.get(j+1));
			}
		}
		return row;
	}
	
}
