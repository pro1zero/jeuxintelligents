package MEDIUM;
import java.util.*;
public class suffixTrieConstruction {
	static class TrieNode{
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	}
	
	static class SuffixTrie{
		TrieNode root = new TrieNode();
		char endSymbol = '*';
	
		public SuffixTrie(String s) {
			populateSuffixTrieFrom(s);
		}
	
		public void populateSuffixTrieFrom(String s) {
			for(int i = 0; i < s.length(); i++) {
				insertSubstringStartingAt(i, s);
			}
		}
		
		public void insertSubstringStartingAt(int i, String s) {
			TrieNode node = root;
			for(int j = i; j < s.length(); j++) {
				char c = s.charAt(j);
				if(!node.children.containsKey(c)) {
					TrieNode newNode = new TrieNode();
					node.children.put(c, newNode);
				}
				node = node.children.get(c);
			}
			node.children.put(endSymbol, null);
		}
		
		public boolean contains(String s) {
			TrieNode node = root; 
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(!node.children.containsKey(c)) {
					return false;
				}
				node = node.children.get(c);
			}
			return node.children.containsKey(endSymbol);
		}
	}
}
