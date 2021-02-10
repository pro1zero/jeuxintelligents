package VERYHARD;

import java.util.Arrays;

public class palindromePartitionMinCuts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minCuts("noonabbad"));
	}
	
	public static int minCuts(String s) {
		if(s.isEmpty())
			return 0;
		boolean[][] palindromes = new boolean[s.length()][s.length()];
		for(int i = 0; i < s.length(); i++) {
			for(int j = i; j < s.length() 	; j++) {
				palindromes[i][j] = isPalindrome(s.substring(i,j + 1));
			}
		}
		int[] cuts = new int[s.length()];
		Arrays.fill(cuts, Integer.MAX_VALUE);
		for(int i = 1; i < s.length(); i++) {
			if(palindromes[0][i]) {
				cuts[i] = 0;
			}else {
				cuts[i] = cuts[i-1] + 1;
				for(int j = 1; j < i; j++) {
					if(palindromes[j][i] && cuts[j-1] + 1 < cuts[i]) {
						cuts[i] = cuts[j-1] + 1;
					}
				}
			}
		}
		return cuts[s.length() - 1];
	}
	
	public static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		
		while(left < right) {
			if(s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
