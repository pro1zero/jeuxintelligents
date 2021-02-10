package EXTREMELYHARD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class longestIncreasingSubsequence {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};
		System.out.println(LISeq(nums));
	}
	
	
	public static List<Integer> LISeq(int[] nums){
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int maxLength = 0;
		int maxLengthIndex = 0;
		for(int i = 1; i < nums.length; i++) {
			int currentNum = nums[i];
			for(int j = 0; j < i; j++) {
				int otherNum = nums[j];
				if(currentNum > otherNum) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
			maxLengthIndex = i;
		}
		return buildSeq(nums, dp, maxLength, maxLengthIndex);
	}
	
	public static List<Integer> buildSeq(int[] nums, int[] dp, int maxLength, int index){
		List<Integer> result = new ArrayList<>();
		
		while(maxLength > 0 && index >= 0) {
			if(dp[index] == maxLength) {
				result.add(nums[index]);
				maxLength--;
			}
			index--;
		}
		Collections.reverse(result);
		return result;
	}
}
