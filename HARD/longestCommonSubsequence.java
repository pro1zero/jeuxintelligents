package HARD;
import java.util.*;
public class longestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLCS("ZXVVYZW", "XKYKZPW"));
	}
	
	public static List<Character> findLCS(String s1, String s2) {
		String[][] lcs = new String[s1.length() + 1][s2.length() + 1];
		for(int i = 0; i < s1.length() + 1; i++) {
			for(int j = 0; j < s2.length() + 1; j++) {
				lcs[i][j] = "";
			}
		}
		for(int i = 1; i < s1.length() + 1; i++) {
			for(int j = 1; j < s2.length() + 1; j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lcs[i][j] = lcs[i-1][j-1] + s2.charAt(j - 1);
				}
				else {
					lcs[i][j] = lcs[i-1][j].length() >= lcs[i][j-1].length()?lcs[i-1][j]: lcs[i][j-1]; 
				}
			}
		}
		//System.out.println(lcs[s1.length()][s2.length()]);
		List<Character> result = new ArrayList<>();
		for(int i = 0; i < lcs[s1.length()][s2.length()].length(); i++) {
			result.add(lcs[s1.length()][s2.length()].charAt(i));
		}
		return result;
	}

}
