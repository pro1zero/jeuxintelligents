package VERYHARD;

public class longestBalancedPalindrome {

	public static void main(String[] args) {
		String s = "))())(())((())(())((";
		System.out.println(findLongest(s));
	}
	
	public static int findLongest(String s) {
		int left = 0; int right = 0;
		int maxLength = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(')
				left++;
			else
				right++;
			if(left == right) {
				maxLength = Math.max(maxLength, left + right);
			}
			else if(right >= left) {
				left = right = 0;
			}		
		}
		left = 0;
		right = 0;
		int rightLength = 0;
		for(int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if(c == ')')
				right++;
			else
				left++;
			if(left == right) {
				rightLength = Math.max(rightLength, left + right);
			}
			else if(left >= right) {
				left = right = 0;
			}
		}
		return Math.max(maxLength, rightLength);
	}
}
