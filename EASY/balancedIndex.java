package EASY;

public class balancedIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0, 9, -8, 2, 7, 1, 11, -2, 1, 1, -22};
		System.out.println(balanced(nums));
		System.out.println(optimal(nums));
	}
	
	public static int balanced(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			int j = i-1;
			int leftSum = 0;
			while(j >= 0) {
				leftSum += nums[j--];
			}
			int k = i+1;
			int rightSum = 0;
			while(k < nums.length) {
				rightSum += nums[k++];
			}
			if(rightSum == leftSum)
				return i;
		}
		return -1;
	}
	
	public static int optimal(int[] nums) {
		int sum = 0;
		for(int num: nums) {
			sum += num;
		}
		int runningSum = 0;
		for(int i = 0; i < nums.length; i++) {
			if(runningSum == sum - runningSum - nums[i])
				return i;
			runningSum += nums[i];
		}
		return -1;
	}
}
