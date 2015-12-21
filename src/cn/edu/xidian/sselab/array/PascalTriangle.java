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

	//����ط�һ��ʼ�Լ�û�п��ǵ�ÿ�ζ�Ҫ�½�һ�����������������ݣ�
	//����rows.clear();��ӵ����ս������������ֱ�����ˣ���Ϊ����ָ������ͬ�ĵ�ַ�ռ�
	//����һ���Լ���ѧϰ���ĵط���rows.add(0,1);ÿ��������ĵ�һ��λ�������һ��1���������滻
	//rows.set(0,1);ÿ�ν������һ��λ�õ���ֵ�滻��1
	//����Ҫ��ѧ���������ݣ�new ArrayList<Integer>(Object obj); ����ֱ�ӼӲ�������ʾ�������ǽ�obj�����ݸ��Ƹ�һ���µĶ���
	//����ʵ�ֹ����ǣ�ÿ��ѭ�����ڵ�һ��λ�ò���1��Ȼ������������������ڵ�������ͣ��滻����Ӧλ���ϵ���ֵ���Ӷ��õ���һ�����
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
