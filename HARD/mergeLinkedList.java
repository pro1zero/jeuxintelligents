package HARD;

public class mergeLinkedList {

	public static void main(String[] args) {
		mergeLL(new LinkedList(1), new LinkedList(0));
	}
	
	public static LinkedList mergeLL(LinkedList headOne, LinkedList headTwo) {
		LinkedList p1 = headOne;
		LinkedList prev = null;
		LinkedList p2 = headTwo;
		while(p1 != null && p2 != null) {
			if(p1.value < p2.value) {
				prev = p1;
				p1 = p1.next;
			}else {
				if(prev != null) {
					prev.next = p2;
				}
				prev = p2;
				p2 = p2.next;
				prev.next = p1;
			}
		}
		if(p1 == null) prev.next = p2;
		return headOne.value < headTwo.value ? headOne : headTwo;
	}

	
	static class LinkedList{
		int value;
		LinkedList next;
		
		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}
}
