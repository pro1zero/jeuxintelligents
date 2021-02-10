package EASY;

public class closestValueinBST {
	static class BST{
		public int value;
		public BST left;
		public BST right;
		
		public BST(int value) {
			this.value = value;
		}
		
		public static int recursion(BST tree, int target) {
			return helper(tree, target, Integer.MAX_VALUE);
		}
		
		public static int helper(BST tree, int target, int closest) {
			if(tree == null)
				return closest;
			
			if(Math.abs(closest - target) > Math.abs(target - tree.value))
				closest = tree.value;
			if(target>tree.value) 
				return helper(tree.right, target, closest);
			if(target<tree.value)
				return helper(tree.left, target, closest);
			else
				return closest;
		}
		
		
		public static int iterative(BST tree, int target) {
			return iterativehelper(tree, target, Integer.MAX_VALUE);
		}
		
		public static int iterativehelper(BST tree, int target, int closest) {
			BST currentNode = tree;
			while(currentNode != null) {
				if(Math.abs(closest - target) > Math.abs(target - tree.value))
					closest = currentNode.value;
				if(target < currentNode.value)
					currentNode = currentNode.right;
				if(target > currentNode.value)
					currentNode = currentNode.left;
				else
					break;
			}
			return closest;
		}
	}
	
	public static void main(String[] args) {
		
	}
	
	
}

