package HARD;
import java.util.*;
import java.util.stream.IntStream;
public class minRewards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {8, 4, 2, 1, 3, 6, 7, 9, 5};
		//System.out.println(bruteForce(nums));
		System.out.println(optimal(nums));
	}
	
	public static int bruteForce(int[] nums) {
		int[] rewards = new int[nums.length];
		Arrays.fill(rewards, 1);
		
		for(int i = 1; i<nums.length;i++) {
			int j = i - 1;
			if(nums[i] > nums[j]) {
				rewards[i] = rewards[j] + 1;
			}
			else {
				while(j >= 0 && nums[j] > nums[j + 1]) {
					rewards[j] = Math.max(rewards[j], rewards[j+1] + 1);
					j--;
				}
			}
		}
		return IntStream.of(rewards).sum();
	}
	
	
	public static int optimal(int[] nums) {
		int[] rewards = new int[nums.length];
		Arrays.fill(rewards, 1);
		
		for(int i = 1;i<nums.length;i++) {
			if(nums[i] > nums[i-1]) {
				rewards[i] = rewards[i-1] + 1;
			}
		}
		
		for(int i = nums.length - 2;i >= 0; i--) {
			if(nums[i] > nums[i+1]) {
				rewards[i] = Math.max(rewards[i], rewards[i+1] + 1);
			}
		}
		return IntStream.of(rewards).sum();
	}
}
