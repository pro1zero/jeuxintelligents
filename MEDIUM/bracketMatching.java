package MEDIUM;
import java.util.*;
public class bracketMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{}{[()]}";
		System.out.println(validate(s));
	}
	
	public static boolean validate(String s) {
		
		List<Character> stack = new ArrayList<>();
		Map<Character, Character> maps = new HashMap<>();
		maps.put(']', '[');
		maps.put('}', '{');
		maps.put(')', '(');
		String opening = "([{";
		String closing = ")}]";
		
		for(int i = 0; i<s.length();i++) {
			char c = s.charAt(i);
			if(opening.contains(c + "")) {
				stack.add(c);
			}
			if(closing.contains(c + "")) {
				if(stack.size() == 0)
					return false;
				if(stack.get(stack.size() - 1) == maps.get(c)) {
					stack.remove(stack.size() - 1);
				}
				else {
					return false;
				}
			}
		}
		return stack.size() == 0;
	}
}
