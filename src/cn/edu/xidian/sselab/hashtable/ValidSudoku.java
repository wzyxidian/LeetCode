package cn.edu.xidian.sselab.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author zhiyong wang
 * title: Valid Sudoku
 * content:
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, 
 * where empty cells are filled with the character '.'.
 * A partially filled sudoku which is valid.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. 
 * Only the filled cells need to be validated. 
 *
 */
public class ValidSudoku {

	//参考了大牛的解法，自己拉下了每个小九方格也要进行比较，最大时间复杂度O(n^4)
	public boolean isValidSudoku(char[][] board){
		//先比较一横行或者一竖列
		for(int i=0;i<9;i++){
			if(!isValidSudokus(board, 0, i, 8, i)) return false;
			if(!isValidSudokus(board, i, 0, i, 8)) return false;
		}
		//然后比较每个小九方格
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(!isValidSudokus(board, i*3, j*3, i*3+2, j*3+2))
					return false;
			}
		}
		return true;
	}
	
	//将比较的过程提炼了出来
	//这里有个index.add，如果存在返回false，不存在返回true
	public boolean isValidSudokus(char[][] board, int x1, int y1, int x2, int y2){		
		Set index = new HashSet();
		for(int i=x1;i<=x2;i++){
			for (int j=y1;j<=y2;j++){
				if(board[i][j] != '.'){
					if(!index.add(board[i][j]))
						return false;
				}
			}
		}
		return true;
	}
	
}
