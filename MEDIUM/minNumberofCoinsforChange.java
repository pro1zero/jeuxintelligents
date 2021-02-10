package MEDIUM;

import java.util.Arrays;

public class minNumberofCoinsforChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] denoms = {1,5,10};
		System.out.println(optimal(denoms, 6));
	}
	
	public static int optimal(int[] d, int target) {
		int[]coins = new int[target + 1];
		Arrays.fill(coins, Integer.MAX_VALUE);
		
		coins[0] = 0;
		int toCompare = 0;
		for(int denom: d) {
			for(int amount = 0; amount<coins.length;amount++) {
				if(denom <= amount) {
					if(coins[amount - denom] == Integer.MAX_VALUE) {
						toCompare = coins[amount - denom];
					}
					else {
						toCompare = coins[amount - denom] + 1;
					}
					coins[amount] = Math.min(coins[amount], toCompare);
				}
			}
		}
		return coins[target] == Integer.MAX_VALUE? -1: coins[target]; 
	}
}
