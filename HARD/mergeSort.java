package HARD;
import java.util.*;

public class mergeSort {

	public static void main(String[] args) {
		int[] nums = {8, 5, 2, 9, 5, 6, 3};
		System.out.println(mergeSortt(nums));
	}
	
	public static int[] mergeSortt(int[] nums) {
		if(nums.length <= 1) 
			return nums;
		int middle = nums.length / 2;
		int[] left = Arrays.copyOfRange(nums, 0, middle);
		int[] right = Arrays.copyOfRange(nums,middle, nums.length);
		return mergeSortedArrays(mergeSortt(left), mergeSortt(right));
	}

	public static int[] mergeSortedArrays(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int i = 0, j = 0, k = 0;
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j]) {
				result[k++] = left[i++];
			}
			else {
				result[k++] = right[j++];
			}
		}
		while(i < left.length) {
			result[k++] = left[i++];
		}
		while(j < right.length) {
			result[k++] = right[j++];
		}
		return result;
	}	
}
