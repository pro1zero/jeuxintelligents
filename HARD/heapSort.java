package HARD;
public class heapSort {

	public static void main(String[] args) {
		int[] nums = {8, 5, 2, 9, 5, 6, 3};
		System.out.println(heapSortt(nums));
	}
	
	public static int[] heapSortt(int[] nums) {
		buildMaxHeap(nums);
		for(int i = nums.length - 1; i > 0; i--) {
			swap(0, i, nums);
			siftDown(0, i - 1, nums);
		}
		return nums;
	}
	
	public static void buildMaxHeap(int[] nums) {
		int firstParentIndex = (nums.length - 2) / 2;
		for(int i = firstParentIndex; i >= 0; i--) {
			siftDown(i, nums.length - 1, nums);
		}
	}
	
	public static void siftDown(int currentIndex, int endIndex, int[] nums) {
		int childOneIndex = currentIndex * 2 + 1;
		while(childOneIndex <= endIndex) {
			int childTwoIndex = currentIndex * 2 + 2 <= endIndex ? currentIndex * 2 + 2 : -1;
			int indexToSwap;
			if(childTwoIndex != -1 && nums[childTwoIndex] > nums[childOneIndex]) {
				indexToSwap = childTwoIndex;
			}
			else {
				indexToSwap = childOneIndex;
			}
			if(nums[indexToSwap] > nums[currentIndex]) {
				swap(currentIndex, indexToSwap, nums);
				currentIndex = indexToSwap;
				childOneIndex = currentIndex * 2 + 1;
			}
			else {
				return;
			}
		}
	}
	
	public static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}





