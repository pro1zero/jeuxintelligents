package EASY;
import java.util.*;
public class ceasarcipherEncryption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "jenish";
		System.out.println(ceasar(s, 27));
		System.out.println(recursion(s,1));
		
	}
	public static String ceasar(String s, int key) {
		key %= 26;
		if(key == 0)
			return s;
		char[] chars = new char[26];
		int count = 0;
		for(char c = 'a'; c <='z';c++) {
			chars[count++] = c;
		}
		
		String result = "";
		for(int i = 0; i<s.length();i++) {
			char c = s.charAt(i);
			int pin = (c - 'a' + key) % 26;
			result += chars[pin];
		}
		return result;
	}
	
	public static String recursion(String s, int key) {
		String alphabets = "abcdefghijklmnopqrstuvwxyz";
		key %= 26;
		char[] result = new char[s.length()];
		for(int i = 0; i<s.length();i++) {
			result[i] = helper(s.charAt(i), key, alphabets);
		}
		return new String(result);
	}
	
	public static char helper(char letter, int key, String alphabets) {
		int newCode = alphabets.indexOf(letter) + key;
		newCode %= 26;
		return alphabets.charAt(newCode);
	}
}
