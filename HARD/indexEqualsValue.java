package HARD;

public class indexEqualsValue {

	public static void main(String[] args) {
		System.out.println(iev(new int[] {-5,-3,0,3,4,5,9}));
	}
	
	public static int iev(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			int middleIndex = right + (left - right)/2;
			int middleValue = nums[middleIndex];
			if(middleValue < middleIndex) {
				left = middleIndex + 1;
			}
			else if((middleValue == middleIndex) && (middleIndex == 0)) {
				return middleIndex;
			}
			else if((middleValue == middleIndex) && (nums[middleIndex - 1] < (middleIndex - 1))) {
				return middleIndex;
			}
			else {
				right = middleIndex - 1;
			}
		}
		return -1;
	}

}
