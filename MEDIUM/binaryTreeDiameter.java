package MEDIUM;

public class binaryTreeDiameter {

	public static void main(String[] args) {
		
	}
	
	public static int bTDiameter(BinaryTree root) {
		return getTreeInfo(root).diameter;
	}
	
	public static TreeInfo getTreeInfo(BinaryTree tree) {
		if(tree == null) {
			return new TreeInfo(0,0);
		}
		TreeInfo leftTreeInfo = getTreeInfo(tree.left);
		TreeInfo rightTreeInfo = getTreeInfo(tree.right);
		int longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height;
		int maxDiameterSoFar = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);
		int currentDiameter = Math.max(longestPathThroughRoot, maxDiameterSoFar);
		int currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);
		return new TreeInfo(currentDiameter, currentHeight);
	}
	
	static class TreeInfo{
		public int diameter;
		public int height;
		
		public TreeInfo(int diameter, int height) {
			this.diameter = diameter;
			this.height = height;
		}
	}
	
	static class BinaryTree{
		public int value;
		public BinaryTree left;
		public BinaryTree right;
		
		public BinaryTree(int value) {
			this.value = value;
		}
	}
}
