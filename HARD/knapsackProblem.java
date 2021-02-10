package HARD;
import java.util.*;
public class knapsackProblem {

	public static void main(String[] args) {
		int[][] items = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
		System.out.println(knapsack(items, 10));
	}
	
	public static List<List<Integer>> knapsack(int[][] items, int capacity){
		int[][] dp = new int[items.length + 1][capacity + 1];
		for(int i = 1; i < items.length + 1; i++) {
			int currentWeight = items[i - 1][1];
			int currentValue = items[i - 1][0];
			for(int c = 0; c < capacity + 1; c++) {
				if(currentWeight > c) {
					dp[i][c] = dp[i - 1][c];
				}else {
					dp[i][c] = Math.max(dp[i - 1][c], dp[i-1][c - currentWeight] + currentValue);
				}
			}
		}
		return getKnapSackItems(dp, items, dp[items.length][capacity]);
	}

	public static List<List<Integer>> getKnapSackItems(int[][] dp, int[][] items, int max){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> totalWeight = new ArrayList<>();
		totalWeight.add(max);
		result.add(totalWeight);
		result.add(new ArrayList<>());
		int i = dp.length - 1;
		int c = dp[0].length - 1;
		while(i > 0) {
			if(dp[i][c] == dp[i - 1][c]) {
				i -= 1;
			}else {
				result.get(1).add(0, i - 1);
				c -= items[i - 1][1];
				i -= 1;
			}
			if(c == 0) break;
		}
		return result;
	}
}
