package cn.edu.xidian.sselab.hashtable;

/**
 * 
 * @author zhiyong wang
 * title: H-Index
 * content:
 *  Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 *  According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 *
 *For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
 *
 *Note: If there are several possible values for h, the maximum one is taken as the h-index. 
 *
 */
public class HIndex {

	//这道题，自己理解错了题意，正确的理解方式是：论文被引用次数大于或者等于h，这样的论文数量也要大于或者等于h，此时的h才是H
	//首先是建立一个数组，用于将论文的引用次数从小到大进行排序，当然引用次数大于总论文个数的都放在数组的最后一位
	//然后从数组最后一个开始，计算论文的个数是否大于或者等于论文引用的次数
	public int hIndex(int[] citations){
		int length = citations.length;
		int result = 0;
		if(length == 0) return 0;
		int[] index = new int[length+1];
		for(int i=0;i<length;i++){
			if(citations[i]>length){
				index[length]++;
			}else{
				index[citations[i]]++;
			}
		}
		for(int i=length;i>=0;i--){
			if(result >= i) return i;
			result +=index[i];
		}
		return 0;
	}
}
