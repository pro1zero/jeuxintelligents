package MEDIUM;
public class threeNumberSort {

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, -1, -1, 1, 1, 1};
		int[] order = {0, 1, -1};
		System.out.println(threeSort(nums, order));
	}
	
	public static int[] threeSort(int[] nums, int[] order) {
		int one = 0;
		int two = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == order[0]) {
				one++;
			}
			else if(nums[i] == order[1]) {
				two++;
			}
		}
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			if(count < one) {
				nums[i] = order[0];
			}
			else if(count < two + one) {
				nums[i] = order[1];
			}
			else {
				nums[i] = order[2];
			}
			count += 1;
		}
		return (nums);
	}

}
