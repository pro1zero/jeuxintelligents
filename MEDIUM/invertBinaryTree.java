package MEDIUM;
import java.util.*;
public class invertBinaryTree {
	static class BinaryTree{
		int value;
		BinaryTree left;
		BinaryTree right;
		
		BinaryTree(int value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
		
		
		public static void invert(BinaryTree tree) {
			ArrayDeque<BinaryTree> queue = new ArrayDeque<>();
			queue.addLast(tree);
			
			while(queue.size() > 0) {
				BinaryTree current = queue.pollFirst();
				if(current == null)
					continue;
				
				swap(current);
				if(current.left != null)
					queue.addLast(current.left);
				if(current.right != null)
					queue.addLast(current.right);
			}
		}
		
		public static void swap(BinaryTree tree) {
			BinaryTree left = tree.left;
			tree.left = tree.right;
			tree.right = left;
		}
		
		
		public static void recursion(BinaryTree tree) {
			if(tree == null) {
				return;
			}
			
			swap(tree);
			recursion(tree.left);
			recursion(tree.right);
		}
	}
}
