package MEDIUM;
import java.util.*;
public class smallestDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-1,5,10,20,28,3};
		int[] b = {26, 134, 135, 15, 17};
		System.out.println(naive(a, b));
		System.out.println(optimal(a, b));
	}
	
	public static String naive(int[] a, int[] b) {
		int difference  = Integer.MAX_VALUE;
		int[] result = new int[2];
		for(int i = 0; i<a.length;i++) {
			for(int j = 0; j<b.length;j++) {
				if(Math.abs(a[i] - b[j]) < difference) {
					difference = Math.abs(a[i] - b[j]);
					result[0] = a[i];
					result[1] = b[j];
				}
			}
		}
		return new String(result[0] + " " + result[1] + " " + difference);
	}
	
	public static int[] optimal(int[] a, int[] b){
		Arrays.sort(a);
		Arrays.sort(b);
		int indexOne = 0;
		int indexTwo = 0;
		
		int difference = Integer.MAX_VALUE;
		int current = Integer.MAX_VALUE;
		int[] smallestPair = new int[2];
		
		while(indexOne<a.length && indexTwo<b.length) {
			int num1 = a[indexOne];
			int num2 = b[indexTwo];
			if(num1<num2) {
				current = num2 - num1;
				indexOne++;
			}
			else if(num2<num1) {
				current = num1 - num2;
				indexTwo++;
			}
			else {
				return new int[] {num1, num2};
			}
			if(difference>current) {
				difference = current;
				smallestPair = new int[] {num1, num2};
			}
		}
		return smallestPair;
	}
}
