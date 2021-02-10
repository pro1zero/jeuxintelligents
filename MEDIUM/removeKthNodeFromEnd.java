package MEDIUM;

public class removeKthNodeFromEnd {
	static class LinkedList{
		int value;
		LinkedList next = null;
		public LinkedList(int value) {
			this.value = value;
		}
	}
	
	public static void removeKthNode(LinkedList head, int k) {
		int counter = 1;
		LinkedList first = head;
		LinkedList second = head;
		while(counter <= k) {
			second = second.next;
			counter += 1;
		}
		if(second == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return; 
		}
		//we use the second.next as the node before the kth node to remove.
		while(second.next != null) {
			second = second.next;
			first = first.next;
		}
		first.next = first.next.next;
	}
}
