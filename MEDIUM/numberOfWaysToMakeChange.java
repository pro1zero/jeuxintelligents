package MEDIUM;

public class numberOfWaysToMakeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] denoms = {1, 5, 10, 25};
		System.out.println(calculateWays(denoms, 10));
	}
	
	public static int calculateWays(int[] denoms, int target) {
		int[] ways = new int[target + 1];
		ways[0] = 1;
		
		for(int denom: denoms) {
			for(int amount = 1; amount <= target; amount++) {
				if(denom <= amount) {
					ways[amount] += ways[amount - denom];
				}
			}
			
		}
		return ways[target];
	}

}
