package EASY;

public class palindrome {

	public static void main(String[] args) {
		//System.out.println(naive(""));
		//System.out.println(twoPointers("anaaabna"));
		//System.out.println(recursion("jenish"));
		System.out.println(usingStringBuilder("racecar"));
	}
	public static boolean usingStringBuilder(String s) {
		StringBuilder reverse = new StringBuilder();
		for(int i = s.length() - 1; i>=0; i--) {
			reverse.append(s.charAt(i));
		}
		return s.equals(reverse.toString());
	}
	public static boolean naive(String s) {
		if(s == null || s.isEmpty())
			return true;
		String reverse = "";
		for(int i = s.length() - 1; i>=0;i--) {
			char c = s.charAt(i);
			reverse += c;
		}
		return (reverse == s || reverse.equals(s));
	}
	
	public static boolean twoPointers(String s) {
		if(s == null || s.isEmpty())
			return true;
		int start = 0;
		int end = s.length() - 1;
		
		while(start<=end) {
			if(s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}
	
	public static boolean recursion(String s) {
		return helper(s, 0);
	}
	public static boolean helper(String s, int start) {
		int j = s.length() - 1 -start;
		return start>=j ? true: s.charAt(j) == s.charAt(start) && helper(s, start + 1);
	}

}
