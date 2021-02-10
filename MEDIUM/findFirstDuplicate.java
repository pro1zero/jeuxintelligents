package MEDIUM;

public class findFirstDuplicate {

	public static void main(String[] args) {
		int[] nums = {2, 1, 5, 2, 3, 3, 4};
		System.out.println(findFirst(nums));
	}
	
	public static int findFirst(int[] nums) {
		for(int num: nums) {
			int absValue = Math.abs(num);
			if(nums[absValue - 1] < 0) return absValue;
			nums[absValue - 1] *= -1;
		}
		return -1;
	}

}
