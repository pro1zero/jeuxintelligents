package EASY;

public class runningLengthEncoding {

	public static void main(String[] args) {
		System.out.println(encode("                          "));
	}
	
	public static String encode(String s) {
		if(s.isEmpty()) return s;
		int current = 1;
		char currentChar = s.charAt(0);
		char nextChar = s.charAt(0);
		String result = "";
		for(int i = 0; i < s.length() - 1; i++) {
			currentChar = s.charAt(i);
			nextChar = s.charAt(i + 1);
			if(currentChar == nextChar) {
				current += 1;
				if(current == 10) {
					result += "9" + currentChar;
					current = 1;
				}
				continue;
			}
			result += Integer.toString(current) + currentChar;
			current = 1;
		}
		result += Integer.toString(current) + nextChar;
		return result;
	}
}
