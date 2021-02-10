package HARD;
import java.util.*;
public class shiftedBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(shiftedBinarySearchMethod(nums, 0));
	}
	public static int binSearch(int[] nums, int target) {
		Arrays.sort(nums);
		
		int left = 0;
		int right = nums.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			if(target == nums[mid]) {
				return mid;
			}
			
			else if(target > nums[mid]) {
				left = mid + 1;
				continue;
			}
			
			else {
				right = mid - 1;
				continue;
			}
		}
		return -1;
	}
	public static int shiftedBinarySearchMethod(int[] nums, int target) {
		return shiftedBinarySearchHelper(nums, target, 0, nums.length - 1);
	}
	
	public static int shiftedBinarySearchHelper(int[] nums, int target, int left, int right) {
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(target == nums[mid]) {
				return mid;
			}
			else if(nums[left] <= nums[mid]) {
				if(target < nums[mid] && target >= nums[left]) {
					right = mid - 1;
				}
				else {
					left = mid + 1;
				}
			}
			else {
				if(target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

}
