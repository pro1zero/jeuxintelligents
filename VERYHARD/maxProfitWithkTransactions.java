package VERYHARD;

public class maxProfitWithkTransactions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] transactions = {5,11,3,50,60,90};
		System.out.println(staticProfit(transactions));
		System.out.println(staticProfitOptimal(transactions));
		System.out.println(maxProfit(transactions, 2));
	}
	
	public static int staticProfit(int[] trans) {
		
		int maxProfit = 0;
		for(int i = 0; i < trans.length; i++) {
			for(int j = i + 1; j < trans.length; j++) {
				if(trans[j] - trans[i] > 0)
					maxProfit = Math.max(maxProfit, trans[j] - trans[i]);
			}
		}
		return maxProfit;
	}
	
	public static int staticProfitOptimal(int[] trans) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for(int i = 0; i < trans.length; i++) {
			if(trans[i] < minPrice) minPrice = trans[i];
			maxProfit = Math.max(maxProfit, trans[i] - minPrice);
		}
		return maxProfit;
	}
	
	public static int maxProfit(int[] prices, int k) {
		int[][] profits = new int[k+1][prices.length];
		for(int i = 1; i < k+1; i++) {
			int maxThisFar = Integer.MIN_VALUE;
			for(int j = 1; j < prices.length; j++) {
				maxThisFar = Math.max(maxThisFar, profits[i-1][j-1] - prices[j-1]);
				profits[i][j] = Math.max(profits[i][j-1], maxThisFar + prices[j]);
			}
		}
		return profits[k][prices.length - 1];
	}

}
