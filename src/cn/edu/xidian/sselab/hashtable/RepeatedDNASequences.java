package cn.edu.xidian.sselab.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author zhiyong wang
 * title: Repeated DNA Sequences
 * content:
 *  All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
 *  for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *  Write a function to find all the 10-letter-long sequences (substrings) 
 *  that occur more than once in a DNA molecule.
 *
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 */
public class RepeatedDNASequences {

	//自己很不细心，错了好几个地方（1）自己没有把思路想好，就开始动笔写代码
	//（2）上来第一步没有考虑特殊情况
	//(3)每次取值范围是（i,i+10）,这两个值都没有注意，直接写的（0,10）
	//(4)只考虑了set是否包含，没有考虑set的写入情况
	//（5）没有考虑如果存在多个重复，是否要多次插入情况
	public List<String> findRepeatedDNASequences(String s){
		int length = s.length();
		List list = new ArrayList();
		if(s == null || length < 10) return list;
		Set set = new HashSet();
		for(int i=0;i<length-9;i++){
			String temp = s.substring(i, i+10);
			if(set.contains(temp) && !list.contains(temp)){
				list.add(temp);
			}else{
				set.add(temp);
			}
			
		}
		return list;
	}
	public static void main(String[] args) {
		RepeatedDNASequences r = new RepeatedDNASequences();
		r.findRepeatedDNASequences("CAAAAAAAAAC");
	}
}
