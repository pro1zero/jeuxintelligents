package MEDIUM;
import java.util.*;
public class minHeightBSTs {
	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
			left = null;
			right = null;
		}

		public void insert(int value) {
			if (value < this.value) {
				if (left == null) {
					left = new BST(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new BST(value);
				} else {
					right.insert(value);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		minHeight(nums);
	}
	 
	public static BST minHeight(List<Integer> nums) {
		return construct(nums, null, 0, nums.size() - 1);
	}
	
	public static BST construct(List<Integer> nums, BST root, int start, int end) {
		if(end < start) return null;
		int mid = (start + end) / 2;
		BST newNode = new BST(nums.get(mid));
		if(root == null) {
			root = newNode;
		}else {
			if(nums.get(mid) < root.value) {
				root.left = newNode;
				root = root.left;
			}else {
				root.right = newNode;
				root = root.right;
			}
		}
		construct(nums, root, start, mid - 1);
		construct(nums, root, mid + 1, end);
		return root;
	}
}
