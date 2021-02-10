package HARD;

public class shiftLinkedList {
	static class LinkedList{
		int value;
		LinkedList next;
		public LinkedList(int value) {
			this.value = value;
		}
	}
	
	public static LinkedList shiftLL(LinkedList head, int k) {
		int length = 1;
		LinkedList tail = head;
		while(tail.next != null) {
			tail = tail.next;
			length += 1;
		}
		int offset = Math.abs(k) % length;
		if(offset == 0) return head;
		int newTailPosition = (k > 0) ? length - offset : offset;
		LinkedList newTail = head;
		for(int i = 1; i < newTailPosition; i++) {
			newTail = newTail.next;
		}
		LinkedList newHead = newTail.next;
		newTail.next = null;
		tail.next = head;
		return newHead;
	}
}
