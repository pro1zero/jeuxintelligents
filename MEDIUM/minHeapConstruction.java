package MEDIUM;
import java.util.*;
public class minHeapConstruction {
	static class MinHeap{
		List<Integer> heap = new ArrayList<>();
		
		public MinHeap(List<Integer> nums) {
			heap = buildHeap(nums);
		}
		
		public List<Integer> buildHeap(List<Integer> nums){
			int firstParentIndex = (nums.size() - 2) / 2;
			for(int currentIndex = firstParentIndex; currentIndex > 0; currentIndex--) {
				siftDown(currentIndex, nums.size() - 1, nums);
			}
			return nums;
		}
		
		public void siftDown(int currentIndex, int endIndex, List<Integer> nums) {
			int childOneIndex = currentIndex * 2 + 1;
			while(childOneIndex <= endIndex) {
				int childTwoIndex = currentIndex * 2 + 2 <= endIndex ? currentIndex * 2 + 2 : -1;
				int indexToSwap;
				if(childTwoIndex != -1 && heap.get(childTwoIndex) < heap.get(childOneIndex)) {
					indexToSwap = childTwoIndex;
				}else {
					indexToSwap = childOneIndex;
				}
				if(heap.get(indexToSwap) < heap.get(currentIndex)) {
					swap(currentIndex, indexToSwap, heap);
					currentIndex = indexToSwap;
					childOneIndex = currentIndex * 2 + 1;
				}else {
					return;
				}
			}
		}
		
		public void swap(int i, int j, List<Integer> heap) {
			Integer temp = heap.get(j);
			heap.set(j, heap.get(i));
			heap.set(i, temp);
		}
		
		public void siftUp(int currentIndex, List<Integer> heap) {
			int parentIndex = (currentIndex - 1) / 2;
			while(currentIndex > 0 && heap.get(currentIndex) < heap.get(parentIndex)) {
				swap(currentIndex, parentIndex, heap);
				currentIndex = parentIndex;
				parentIndex = (currentIndex - 1) / 2;
			}
		}
		
		public int peek() {
			return heap.get(0);
		}
		
		public int remove() {
			swap(0, heap.size() - 1, heap);
			int valueToRemove = heap.get(heap.size() - 1);
			heap.remove(heap.size() - 1);
			siftDown(0, heap.size() - 1, heap);
			return valueToRemove;
		}
		
		public void insert(int value) {
			heap.add(value);
			siftUp(heap.size() - 1, heap);
		}
	}

}
