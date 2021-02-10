package EASY;
import java.util.*;
public class twoNumbers {

	public static void main(String[] args) {
		int[] nums = {3,5,-4,8,11,1,-1,6};
		System.out.print(twopass(nums, 10));
		System.out.print(naive(nums, 10));
		System.out.print(twopointers(nums, 100));
		System.out.print(onepass(nums, 10));
	}
	public static int[] twopass(int[] nums, int k) {
		Map<Integer, Integer> maps = new HashMap<>();
		
		for(int i = 0; i<nums.length;i++) {
			int difference = k - nums[i];
			maps.put( difference, nums[i]);
		}
		for(int i = 0; i<nums.length;i++) {
			if(maps.containsKey(nums[i]) && nums[i] != maps.get(nums[i])) {
				return new int[] {maps.get(nums[i]), nums[i]};
			}
		}
		return new int[] {};
	}
	public static int[] onepass(int[] nums, int k) {
		Map<Integer, Integer> maps = new HashMap<>();
		for(int i: nums) {
			int diff = k - i;
			if(maps.containsKey(diff)) {
				int[] res = {diff, i};
				System.out.println(Arrays.toString(res));
				return new int[] {diff, i};
			}
			else
				maps.put(i, diff);
		}
		return new int[] {};
	}
	public static String naive(int[] nums, int k) {
		for(int i = 0; i<nums.length;i++) {
			for(int j = 0; j<nums.length;j++) {
				if(nums[i] + nums[j] == k && i!=j) {
					int[] res = {nums[i], nums[j]};
					return Arrays.toString(res);
				}
			}
		}
		return "";
	}
	public static String twopointers(int[] nums, int k) {
		int start = 0;
		int end = nums.length - 1;
		Arrays.sort(nums);
		while(start<=end) {
			if(k == nums[start] + nums[end]) {
				int[] res = {nums[start], nums[end]};
				return Arrays.toString(res);
			}
			else if(k<nums[start] + nums[end]) {
				end--;
			}
			else {
				start++;
			}
		}
		return "{}";
	}

}
