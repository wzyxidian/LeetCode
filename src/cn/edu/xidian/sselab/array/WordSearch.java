package cn.edu.xidian.sselab.array;
/**
 * title: Word Search
 * content:
 *Given a 2D board and a word, find if the word exists in the grid.
 *The word can be constructed from letters of sequentially adjacent cell, 
 *where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * 
 * [
 *   ['A','B','C','E'],
 *  ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]

 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class WordSearch {

	//������������̰���ߵ���Ϸ��ץס�ص㣬�ؼ��������ι���ݹ麯�����Լ�ʲôʱ�򷵻�ֵ
	//�����Ŀ����һ���ѵ��ǣ�ÿ���㲻���ظ�ʹ�ã�Ҳ����˵ÿ���жϹ���ȷ�ĵ㣬�ж���һ���ڵ��ʱ�����ֵ�����ã�������㸳��ֵ
	//ֻҪ��֤�����жϷ�����false�Ϳ���
	public boolean exist(char[][] board, String word) {
	    int totalLen = board.length;
	    int sigleLen = board[0].length;
	    for(int i=0;i<totalLen;i++){
	    	for(int j=0;j<sigleLen;j++){
	    		if(exists(board,i,j,word,0)){
	    			return true;
	    		}
	    	}
	    }
		return false;
   }
	
	private boolean exists(char[][]board,int i,int j,String word,int temp){
		if(temp == word.length())
			return true;
		if(i<0 || j<0 || i == board.length|| j == board[0].length || board[i][j] != word.charAt(temp))
			return false;
		board[i][j] = '*';
		boolean result = exists(board,i-1,j,word,temp+1)||
				 exists(board,i+1,j,word,temp+1)||
				 exists(board,i,j-1,word,temp+1)||
				 exists(board,i,j+1,word,temp+1);
		board[i][j] = word.charAt(temp);
		return result;
	}

}
