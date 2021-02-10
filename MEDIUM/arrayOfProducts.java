package MEDIUM;
import java.util.*;
public class arrayOfProducts {

	public static void main(String[] args) {
		int[] nums = {5,1,4,2};
		System.out.println(better(nums));
	}
	
	public static int[] findProduct(int[] nums) {
		if(nums.length < 3) {
			return (nums);
		}
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int runningProduct = 1;
		for(int i = 0; i < nums.length; i++) {
			if(runningProduct == 0) break;
			runningProduct *= nums[i];
			left[i] = runningProduct;
		}
		runningProduct = 1;
		for(int i = nums.length - 1; i >= 0; i--) {
			if(runningProduct == 0) break;
			runningProduct *= nums[i];
			right[i] = runningProduct;
		}
		int[] products = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			if (i == 0) {
				products[i] = right[i + 1];
			}
			else if(i == nums.length - 1) {
				products[i] = left[nums.length - 2];
			}
			else {
				products[i] = left[i-1] * right[i+1];
			}
		}
		return (products);
	}
	
	
	public static int[] better(int[] nums) {
		if(nums.length < 3) {
			return (nums);
		}
		int left = 1;
		int[] products = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			products[i] = left;
			left *= nums[i];
		}
		int right = 1;
		for(int i = nums.length - 1; i >= 0; i--) {
			products[i] *= right;
			right *= nums[i];
		}
		return (products);
	}
}
