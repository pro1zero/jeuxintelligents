package HARD;

public class reverseLinkedList {
	static class LinkedList{
		int value;
		LinkedList next = null;
		public LinkedList(int value) {
			this.value = value;
		}
	}
	
	public static LinkedList reverseLL(LinkedList head) {
		LinkedList previous = null;
		LinkedList current = head;
		while(current != null) {
			LinkedList next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
}
