package VERYHARD;

import java.util.Arrays;

public class knuthPrattMorrisAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(knp("aefoaefcdaefcdaed", "aefcdaed"));
	}
	
	public static boolean knp(String s, String t) {
		int[] pattern = buildPattern(t);
		return doesMatch(s, t, pattern);
	}
	
	public static int[] buildPattern(String t){
		int[] pattern = new int[t.length()];
		Arrays.fill(pattern, -1);
		int j = 0;
		int i = 1;
		while(i < t.length()) {
			if(t.charAt(i) == t.charAt(j)) {
				pattern[i] = j;
				i += 1;
				j += 1;
			}
			else if(j > 0) {
				j = pattern[j - 1] + 1;
			}
			else {
				i += 1;
			}
		}
		return pattern;
	}
	
	public static boolean doesMatch(String s, String t, int[] pattern) {
		int i = 0;
		int j = 0;
		while(i + t.length() - j <= s.length()) {
			if(s.charAt(i) == t.charAt(j)) {
				if(j == t.length() - 1) return true;
				i += 1;
				j += 1;
			}
			else if(j > 0) {
				j = pattern[j - 1] + 1;
			}
			else {
				i++;
			}
		}
		return false;
	}
}
