package HARD;
import java.util.*;
public class multiStringSearch {

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
				insertSubStringStartingAt(i, s);
			}
		}
		
		public void insertSubStringStartingAt(int i, String s) {
			TrieNode node = root;
			for(int j = i; j < s.length(); j++) {
				char c = s.charAt(j);
				if(!node.children.containsKey(c)) {
					TrieNode newNode = new TrieNode();
					node.children.put(c, newNode);
				}
				node = node.children.get(c);
			}
		}
		
		public boolean contains(String s) {
			TrieNode node = root;
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(!node.children.containsKey(c)) return false;
				node = node.children.get(c);
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(mss("this is a big string", new String[] {"this", "yo", "is", "a", "bigger", "string", "kappa"}));
		System.out.println(mssOptimal("this is a big string", new String[] {"this", "yo", "is", "a", "bigger", "string", "kappa"}));
	}

	public static List<Boolean> mssOptimal(String big, String[] smallStrings){
		List<Boolean> result = new ArrayList<>();
		SuffixTrie st = new SuffixTrie("this is a big string");
		for(String small : smallStrings) {
			boolean found = st.contains(small);
			result.add(found);
		}
		return result;
	}
	
	public static List<Boolean> mss(String big, String[] smallStrings){
		List<Boolean> result = new ArrayList<>();
		for(String small : smallStrings) {
			char first = small.charAt(0);
			boolean found = false;
			for(int i = 0; i < big.length(); i++) {
				if(first == big.charAt(i) && i + small.length() <= big.length() && big.substring(i, i + small.length()).equals(small)) {
					result.add(true);
					found = true;
					break;
				}
			}
			if(!found) result.add(false);
		}
		return result;
	}
	
	
}
