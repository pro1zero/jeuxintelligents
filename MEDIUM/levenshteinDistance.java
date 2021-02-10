package MEDIUM;

public class levenshteinDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(dynamic("eat", "sea"));
	}
	
	public static int dynamic(String s, String t) {
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		
		for(int i = 0; i<s.length() + 1;i++) {
			for(int j = 0; j<t.length() + 1;j++) {
				dp[i][j] = j;
			}
			dp[i][0] = i;
		}
		
		for(int i = 1; i<s.length() + 1;i++) {
			for(int j = 1; j<t.length() + 1; j++) {
				if(s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
				}
			}
		}
		return dp[s.length()][t.length()];
	}

}
