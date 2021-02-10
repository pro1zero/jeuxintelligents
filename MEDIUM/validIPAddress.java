package MEDIUM;
import java.util.*;
public class validIPAddress {

	public static void main(String[] args) {	
		System.out.println(getAllValid("1921680"));
	}
	
	public static ArrayList<String> getAllValid(String s){
		ArrayList<String> result = new ArrayList<String>();
		if(s.length() < 4) return result;
		for(int i = 0; i < s.length() - 3; i++) {
			String one = s.substring(0, i + 1);
			for(int j = i + 1; j < s.length() - 2; j++) {
				String two = s.substring(i + 1, j + 1);
				for(int k = j + 1; k < s.length() - 1; k++) {
					String three = s.substring(j + 1, k + 1);
					String four = s.substring(k + 1, s.length());
					boolean flag = checkForValidIP(one, two, three, four);
					if(flag) result.add(construct(one, two, three, four));
				}
			}
		}
		return result;
	}
	
	public static boolean checkForValidIP(String one, String two, String three, String four) {
		int first = Integer.parseInt(one);
		int second = Integer.parseInt(two);
		int third = Integer.parseInt(three);
		int fourth = Integer.parseInt(four);
		if(first > 255 || second > 255 || third > 255 || fourth > 255) {
			return false;
		}
		if(one.length() != Integer.toString(first).length()) {
			return false;
		}
		if(two.length() != Integer.toString(second).length()) {
			return false;
		}
		if(three.length() != Integer.toString(third).length()) {
			return false;
		}
		if(four.length() != Integer.toString(fourth).length()) {
			return false;
		}
		return true;
	}
	
	public static String construct(String one, String two, String three, String four) {
		return one + "." + two + "." + three + "." + four;
	}
}
