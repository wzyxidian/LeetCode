package cn.edu.xidian.sselab.string;

/**
 * 
 * @author zhiyong wang
 * title: Compare Version Numbers
 * content:
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 *
 */
public class CompareVersionNumbers {

	//参考大牛的做法，这个题首先分裂，然后求出两个数组长度的最大值，用这个大的值进行遍历，如果当前值小于自己的长度，就用自己的值，否则是0，这样进行判断
	public int compareVersion(String version1, String version2){
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int max = v1.length <= v2.length ? v2.length : v1.length;
		for(int i=0;i<max;i++){
			Integer vv1 = i < v1.length ? Integer.valueOf(v1[i]) : 0;
			Integer vv2 = i < v2.length ? Integer.valueOf(v2[i]) : 0;
			if(vv1 > vv2) return 1;
			else if(vv1 < vv2) return -1;
		}
		return 0;				
	}
}
