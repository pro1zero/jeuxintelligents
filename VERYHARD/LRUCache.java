package VERYHARD;
import java.util.*;
class Program {
	  static class LRUCache{
			Map<String, Node> cache = new HashMap<String, Node>();
			int maxSize;
			int currentSize = 0;
			LinkedList listOfMostRecent = new LinkedList();
			
			public LRUCache(int maxSize) {
				this.maxSize = maxSize > 1 ? maxSize : 1;
			}
			
			public void insertKeyValuePair(String key, int value) {
				if(!cache.containsKey(key)) {
					if(currentSize == maxSize) {
						evictLeastUsed();
					}
					else {
						currentSize += 1;
					}
					cache.put(key, new Node(key, value));
				}
				else {
					if(!cache.containsKey(key)) {
						return;
					}
					this.cache.get(key).value = value;
				}
				updateMostRecent(cache.get(key));
				
			}
			
			public LRUResult getValueFromKey(String key) {
				if(!cache.containsKey(key)) {
					return new LRUResult(false, -1);
				}
				updateMostRecent(cache.get(key));
				return new LRUResult(true, cache.get(key).value);
			}
			
			public void updateMostRecent(Node node) {
				listOfMostRecent.setHeadTo(node);
			}
			
			public String getMostRecentKey() {
				if(listOfMostRecent.head == null) {
					return "";
				}
				return listOfMostRecent.head.key;
			}
			
			public void evictLeastUsed() {
				String keyToRemove = listOfMostRecent.tail.key;
				listOfMostRecent.removeTail();
				cache.remove(keyToRemove);
			}
			
			
		}
		
		static class LinkedList{
			Node head = null;
			Node tail = null;
			
			public void setHeadTo(Node node) {
				if(head == node) {
					return;
				}
				else if(head == null) {
					head = node;
					tail = node;
				}
				else if(head == tail) {
					tail.prev = node;
					head = node;
					head.next = tail;
				}
				else {
					if(tail == node) {
						removeTail();
					}
					node.removeBindings();
					head.prev = node;
					node.next = head;
					head = node;
				}
			}
			
			public void removeTail() {
				if(tail == null) {
					return;
				}
				if(tail == head) {
					head = null;
					tail = null;
					return;
				}
				tail = tail.prev;
				tail.next = null;
			}
		}
		
		static class Node{
			String key;
			int value;
			Node prev = null;
			Node next = null;
			
			public Node(String key, int value) {
				this.key = key;
				this.value = value;
			}
			
			public void removeBindings() {
				if(prev != null) {
					prev.next = next;
				}
				if(next != null) {
					next.prev = prev;
				}
				prev = null;
				next = null;
			}
		}
		
		static class LRUResult{
			boolean found;
			int value;
			
			public LRUResult(boolean found, int value) {
				this.found = found;
				this.value = value;
			}
		}
	}