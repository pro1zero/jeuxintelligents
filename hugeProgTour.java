import java.util.*;
public class hugeProgTour {
	public static void main(String[] args) {
		int numberOfStudents = 0;
		Scanner scan = new Scanner(System.in);
		numberOfStudents = scan.nextInt();
		int[] nums = new int[numberOfStudents];
		for(int i = 0; i < numberOfStudents; i++) {
			nums[i] = scan.nextInt();
		}
		System.out.println(getMaxRating(nums));
		scan.close();
	}
	
	public static int getMaxRating(int[] nums) {
		Arrays.sort(nums);
		int maxRating = Integer.MAX_VALUE, right = nums.length - 1, left = 0;
		while(left < right) maxRating = Math.min(maxRating, nums[left++] + nums[right--]);
		return maxRating;
	}
}
