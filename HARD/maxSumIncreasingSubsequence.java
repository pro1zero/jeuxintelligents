package HARD;
import java.util.*;
public class maxSumIncreasingSubsequence {
	public static void main(String[] args) {
		int[] nums = {8, 12, 2, 3, 15, 5, 7};
		
		System.out.println(maxSeq(nums));
	}
	
	public static List<List<Integer>> maxSeq(int[] nums){
		int[] sums = nums.clone();
		int[] sequence = new int[nums.length];
		Arrays.fill(sequence, Integer.MIN_VALUE);
		int maxSumIndex = 0;
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i] && sums[j] + nums[i] >= sums[i]) {
					sums[i] = nums[i] + sums[j];
					sequence[i] = j;
				}
			}
			if(sums[i] >= sums[maxSumIndex]) {
				 maxSumIndex = i;
			}
		}
		
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> maxx = new ArrayList<>();
		maxx.add(sums[maxSumIndex]);
		result.add(maxx);
		List<Integer> maxSum = buildSeq(nums, sequence, sums, maxSumIndex);
		result.add(maxSum);
		return result;
	}
	
	public static List<Integer> buildSeq(int[] nums, int[] sequence, int[] sums, int maxSumIndex){
		List<Integer> seq = new ArrayList<>();
		while(sequence[maxSumIndex] != Integer.MIN_VALUE) {
			seq.add(nums[maxSumIndex]);
			maxSumIndex = sequence[maxSumIndex];
		}
		seq.add(nums[maxSumIndex]);
		Collections.reverse(seq);
		return seq;
	}
	
	public static List<List<Integer>> maxSequence(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length == 0)
			return result;
		int[] dp = new int[nums.length];
		int index = 0;

		for(int i = 0; i < nums.length; i++) {
			dp[i] = nums[i];
		}
		int max = dp[0];
		for(int i = 1; i < nums.length; i++) {
			int j = i - 1;
			while(j >= 0) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], nums[i] + dp[j]);
				}
				j--;
			}
			if(dp[i] > max) {
				index = i;
				max = Math.max(max, dp[i]);
			}
		}
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(dp));
		List<Integer> maxSum = new ArrayList<>();
		maxSum.add(max);
		result.add(maxSum);
		List<Integer> sequence = new ArrayList<>();
		sequence = buildSequence(max, sequence, dp, nums, index);
		result.add(sequence);
		return result;
	}
	
	public static List<Integer> buildSequence(int max, List<Integer> s, int[] dp, int[] nums, int index){
		int sum = nums[index];
		
		int next = dp[index];
		s.add(nums[index]);
		index -= 1;
		
		while(index >= 0 && sum < max) {
			if(dp[index] < next) {
				s.add(nums[index]);
				sum += nums[index];
				next = dp[index];
			}
			index--;
		}
		Collections.reverse(s);
		return s;
	}
}
