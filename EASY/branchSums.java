package EASY;
import java.util.*;
public class branchSums {
	static class BinaryTree{
		int value;
		BinaryTree left;
		BinaryTree right;
		
		BinaryTree(int value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public static List<Integer> calculation(BinaryTree root){
		List<Integer> sums = new ArrayList<>();
		helper(root, 0, sums);
		return sums;
	}
	
	public static void helper(BinaryTree node, int runningSum, List<Integer> sums) {
		if(node == null)
			return;
		
		int newRunningSum = runningSum + node.value;
		if(node.left == null && node.right == null) {
			sums.add(newRunningSum);
			return;
		}
		
		helper(node.left, newRunningSum, sums);
		helper(node.right, newRunningSum, sums);
		
	}
}
