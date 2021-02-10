package VERYHARD;

import java.util.*;
public class smallestSubStringContaining{
	public static void main(String[] args) {
		System.out.println(smallest("abcdef", "fa"));
	}
	
	public static String smallest(String big, String small) {
		Map<Character, Integer> smallMap = new HashMap<>();
		for(char c: small.toCharArray()) {
			smallMap.put(c, smallMap.getOrDefault(c, 0) + 1);
		}
		String result = "";
		int toCompare = big.length();
		for(int i = 0; i < big.length(); i++) {
			for(int j = i + 1; j < big.length() + 1; j++) {
				String s = big.substring(i, j);
				Map<Character, Integer> map = getMap(s);
				boolean flag = true;
				for(char c: smallMap.keySet()) {
					if(map.get(c) != null && map.get(c) >= smallMap.get(c)) {
						continue;
					}
					else {
						flag = false;
						break;
					}
				}
				if(s.length() <= toCompare && flag) {
					result = s;
					toCompare = s.length();
				}
			}
		}
		return result;
	}
	
	public static Map<Character, Integer> getMap(String s){
		Map<Character, Integer> smallMap = new HashMap<>();
		for(char c: s.toCharArray()) {
			smallMap.put(c, smallMap.getOrDefault(c, 0) + 1);
		}
		return smallMap;
	}
}