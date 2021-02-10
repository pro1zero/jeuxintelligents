package MEDIUM;

public class replaceOneZeroInAdjacentOnes {

	public static void main(String[] args) {
		int[] nums = {0};
		System.out.println(getIndex(nums));
	}
	
	public static int getIndex(int[] nums) {
		int longest = 0;
		int current = 0;
		int removed = -1;
		int longestRemoved = -1;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 1) {
				current += 1;
			}
			else {
				current = i - removed;
				removed = i;
			}
			if(current > longest) {
				longest = current;
				longestRemoved = removed;
			}
		}
		return longestRemoved;
	}

}
