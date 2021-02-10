package MEDIUM;

public class validateBST {

	static class BST{
		public int value;
		public BST left;
		public BST right;
		
		public BST(int value) {
			this.value = value;
		}
	}
	public static boolean validate(BST tree) {
		return helper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean helper(BST tree, int min, int max) {
		if(tree.value >= max || tree.value < min) {
			return false;
		}
		
		if(tree.left != null && !helper(tree.left, min, tree.value)){
			return false;
		}
		if(tree.right != null && !helper(tree.right, tree.value, max)){
			return false;
		}
		return true;
	}

}
