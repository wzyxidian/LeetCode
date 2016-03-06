package cn.edu.xidian.sselab.string;

/**
 * 
 * @author zhiyong wang
 * title: ZigZag Conversion
 * content:
 *  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 *P   A   H   N
 *A P L S I I G
 *Y   I   R
 *
 *And then read line by line: "PAHNAPLSIIGYIR"
 *
 *Write the code that will take a string and make this conversion given a number of rows:
 *
 *string convert(string text, int nRows);
 *
 *convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
 *
 */
public class ZigZagConversion {

	//自己没有 想到好的办法，参考大牛的做法
	//为每一行创建一个StringBuilder，然后把每行的内容添加到各自的StringBuilder中，最后合并到第一个中
	//遍历的时候先正向遍历第一列，然后倒序遍历斜边即可，斜边中不管数据存放的位置如何，都是下一个数据，并且都会放到对应的buffer中
	public String convert(String s, int numRows) {
		char[] c = s.toCharArray();
		int len = c.length;
		StringBuilder[] sb = new StringBuilder[numRows];
		for(int i=0;i<numRows;i++) sb[i] = new StringBuilder();
		int i = 0;
		while(i<len){
			for(int j=0;j<numRows&&i<len;j++) sb[j].append(c[i++]);
			for(int j=numRows-2;j>=1&&i<len;j--) sb[j].append(c[i++]);
		}
		for(int j=1;j<numRows;j++){
			sb[0].append(sb[j]);
		}
	   return sb[0].toString();
	}
}
