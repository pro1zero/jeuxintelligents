package HARD;
import java.util.*;
public class quickSelect {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] nums = {8, 5, 2, 9, 7, 6, 3};
		System.out.println(usingSorting(nums, 3));
		System.out.println(usingHeap(nums, 3));
		System.out.println(quickSelectt(nums, 3));
	}
	
	public static int usingSorting(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[k-1];
	}
	
	public static int usingHeap(int[] nums, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		for(int num: nums) {
			heap.offer(num);
			if(heap.size() > k)
				heap.poll();
		}
		return heap.poll();
	}
	
	public static int quickSelectt(int[] nums, int k) throws Exception {
		int position = k - 1;
		return quickSelectHelper(nums, position, 0, nums.length - 1);
	}
	
	public static int quickSelectHelper(int[] nums, int position, int start, int end) throws Exception {
		while(true) {
			if(start > end) {
				throw new Exception("algo should never reach here.");
			}
			int pivot = start;
			int left = start + 1;
			int right = end;
			while(left <= right) {
				if(nums[left] > nums[pivot] && nums[right] < nums[pivot]) {
					swap(left, right, nums);
				}
				if(nums[left] <= nums[pivot]) {
					left += 1;
				}
				if(nums[right] >= nums[pivot]) {
					right -= 1;
				}
			}
			swap(pivot, right, nums);
			if(right == position) {
				return nums[right];
			}
			else if(right < position) {
				start = right + 1;
			}
			else {
				end = right - 1;
			}
		}
	}
	
	public static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
