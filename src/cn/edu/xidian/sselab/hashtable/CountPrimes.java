package cn.edu.xidian.sselab.hashtable;

/**
 * 
 * @author zhiyong wang
 * title: Count Primes
 * content:
 * Description:
 * 
 * Count the number of prime numbers less than a non-negative number, n.
 *
 */
public class CountPrimes {

	//自己想出来的，不过有几个地方一开始出错了：（1）是比n小的质数不包括n
	//（2）判断是否是质数，n%i==0说明正好整除，这样的数不是质数
	public int countPrimes(int n){
		if(n<=2) return 0;
		int count = 1;
		for(int i=3;i<n;i=i+2){
			if(isPrime(i))
				count++;
		}		
		return count;
	}
	
	private boolean isPrime(int n){
		int divide =  (int) Math.sqrt(n);
		for(int i=3;i<=divide;i=i+2){
			if(n%i == 0)
				return false;
		}
		return true;
	}
}
