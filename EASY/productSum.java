package EASY;
import java.util.*;
public class productSum {

	public static void main(String[] args) {

	}
	public static int product(List<Object> a) {
		return helper(a, 1);
	}
	public static int helper(List<Object> array, int multiplier) {
		int sum = 0;
		for(Object a: array) {
			if(a instanceof ArrayList) {
				sum += helper((List<Object>) a, multiplier + 1);
			}
			else {
				sum += (int) a;
			}
		}
		return sum * multiplier;
	}

}
