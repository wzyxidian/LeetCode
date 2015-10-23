package cn.edu.xidian.sselab;

/**
 * title：Nim Game
 * You are playing the following Nim Game with your friend: 
 * There is a heap of stones on the table, 
 * each time one of you take turns to remove 1 to 3 stones.
 * The one who removes the last stone will be the winner.
 * You will take the first turn to remove the stones.
 * Both of you are very clever and have optimal strategies for the game.
 * 
 * Write a function to determine whether you can win the game given the number of stones in the heap.
 * For example, if there are 4 stones in the heap,
 * then you will never win the game: no matter 1, 2, or 3 stones you remove, 
 * the last stone will always be removed by your friend.
 */
public class NimGame {

	/**
	 * @author wzy
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NimGame ng = new NimGame();
		boolean f = ng.canWinNim(11);
		System.out.println(f);
	}
	//思路：逆序考虑，因为一次可以取一到三个，所以总量只要为4的倍数，你就肯定会输
	public boolean canWinNim(int n){
		boolean flag = false;
		if(n % 4 == 0){
			flag = false;
		}else{
			flag = true;
		}
		return flag;
	}

}
