package HARD;
import java.util.*;
public class longestSubStringWithoutDuplication {
	public static void main(String[] args) {
		String s = "clementisacap";
		//System.out.println(naive(s));
		System.out.println(optimal(s));
	}
	
	public static String naive(String s) {
		if(s.length() == 0)
			return "";
		String res = "";
		for(int i = 0; i<s.length();i++) {
			String temp = "";
			for(int j = i; j<s.length();j++) {
				if(!temp.contains(s.charAt(j) + "")) {
					temp += s.charAt(j);
				}
				else {
					break;
				}
			}
			if(res.length() < temp.length()) {
				res = temp;
			}
		}
		return res;
	}
	
	public static String optimal(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int[] range = {0,1};
		int start = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				start = Math.max(start, map.get(c) + 1);
			}
			if(range[1] - range[0] < i + 1 - start) {
				range[0] = start;
				range[1] = i + 1;
			}
			map.put(c, i);
		}
		return s.substring(range[0], range[1]);
	}
}
