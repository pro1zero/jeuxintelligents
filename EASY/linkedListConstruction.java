package EASY;

public class linkedListConstruction {
	
	static class doublyLinkedList{
		public Node head;
		public Node tail;
	
		public boolean containsNodeWithValue(int value) {
			Node node = head;
			while(node != null && node.value != value) {
				node = node.next;
			}
			return node != null;
		}
		
		public void remove(Node node) {
			if(node == head)
				head = node.next;
			if(node == tail){
				tail = node.prev;
			removeNodeBindings(node);
			}
		}
		
		public void removeNodeBindings(Node node) {
			if(node.prev != null)
				node.prev.next = node.next;
			if(node.next != null)
				node.next.prev = node.prev;
			
			node.prev = null;
			node.next = null;
		}
		
		
		public void removeNodeWithValue(int value) {
			Node node = head;
			while(node != null) {
				Node nodeToRemove = node;
				node = node.next;
				if(nodeToRemove.value == value)
					remove(nodeToRemove);
			}
		}
		
		public void insertBefore(Node node, Node nodeToInsert) {
			if(nodeToInsert == head && nodeToInsert == tail)
				return;
			remove(nodeToInsert);
			nodeToInsert.prev = node.prev;
			nodeToInsert.next = node;
			if(node.prev == null) {
				head = nodeToInsert;
			}else {
				node.prev.next = nodeToInsert;
			}
			node.prev = nodeToInsert;
		}
		
		public void insertAfter(Node node, Node nodeToInsert) {
			if(nodeToInsert == head && nodeToInsert == tail) {
				return;
			}
			remove(nodeToInsert);
			nodeToInsert.prev = node;
			nodeToInsert.next = node.next;
			if(node.next == null) {
				tail = nodeToInsert;
			}else {
				node.next.prev = nodeToInsert;
			}
			node.next = nodeToInsert;
		}
		
		public void setHead(Node node) {
			if(head == null) {
				head = node;
				tail = node;
				return;
			}
			insertBefore(head, node);
		}
		
		public void setTail(Node node) {
			if(tail == null) {
				setHead(node);
				return;
			}
			insertAfter(tail, node);
		}
		
		public void insertAtPosition(int position, Node nodeToInsert) {
			if(position == 1) {
				setHead(nodeToInsert);
				return;
			}
			
			Node node = head;
			int currentPosition = 1;
			while(node != null && currentPosition++ != position) {
				node = node.next;
			}
			if(node != null) {
				insertBefore(node, nodeToInsert);
			}else {
				setTail(nodeToInsert);
			}
		}
	}
	static class Node{
		public int value;
		public Node prev;
		public Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
}
