package MEDIUM;

public class longestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(naive("abaxyzzyxf"));
		System.out.println(optimal("abccccdd"));
	}
	
	public static String naive(String s) {
		int longest = 0;
		String result = "";
		for(int i = 0; i<s.length();i++) {
			String temp = "";
			for(int j = i; j<s.length();j++) {
				temp += s.charAt(j);
				if(helper(temp)){
					longest = Math.max(longest, temp.length());
					if(temp.length() >= longest)
						result = temp;
				}
			}
		} 	
		return result;
	}
	
	public static boolean helper(String s) {
		int start = 0;
		int end = s.length() - 1;
		while(start <= end) {
			if(s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public static String optimal(String s) {
		if(s.length() < 1 || s == null) {
			return "";
		}
		
		int start = 0;
		int end = 0;
		
		for(int i = 0; i<s.length();i++) {
			int len1 = expandFromMiddle(s, i, i);
			int len2 = expandFromMiddle(s, i, i+1);
			int len = Math.max(len1, len2);
			
			if(len > end - start) {
				start = i - ((len - 1) /2);
				end = i + (len/2);
			}
		}
		return s.substring(start, end + 1);
	}
	
	public static int expandFromMiddle(String s, int left, int right) {
		while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

}
