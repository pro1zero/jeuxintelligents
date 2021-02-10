package EASY;
import java.util.*;
public class threeLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {7,7,7,7,7,7};
		//System.out.println(mostnaive(a));
		//System.out.println(usingbubblesort(a));
	//	System.out.println(usinginsertionSort(a));
		//System.out.println(usingSelectionSort(a));
		System.out.println(optimal(a));
	}
	
	public static String mostnaive(int[] a) {
		Arrays.sort(a);
		return new String(a[a.length - 3] + " " +  a[a.length - 2] + " " +  a[a.length - 1]);
	}
	
	public static String usingbubblesort(int[] a) {
		for(int i = 0; i<a.length;i++) {
			for(int j = 1;j<a.length - i;j++) {
				if(a[j]<a[j-1]) {
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
		return new String(a[a.length - 3] + " " +  a[a.length - 2] + " " +  a[a.length - 1]);
	}
	
	public static String usinginsertionSort(int[] a) {
		for(int i = 1; i<a.length; i++) {
			for(int j = i; j>0; j--) {
				if(a[j]<a[j-1]) {
					a[j] = a[j] + a[j-1];
					a[j-1] = a[j] - a[j-1];
					a[j] = a[j] - a[j-1];
				}
			}
		}
		return new String(a[a.length - 3] + " " +  a[a.length - 2] + " " +  a[a.length - 1]);
	}
	
	public static String usingSelectionSort(int[] a) {
		for(int i = 0; i<a.length - 1;i++) {
			int smallestIndex = i;
			for(int j = i + 1;j<a.length;j++) {
				if(a[smallestIndex] > a[j]) {
					smallestIndex = j;
				}
			}
			swap(i,smallestIndex, a);
		}
		System.out.println(Arrays.toString(a));
		return new String(a[a.length - 3] + " " +  a[a.length - 2] + " " +  a[a.length - 1]);
	}
	
	public static void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static String optimal(int[] a) {
		int[] result = new int[3];
		Arrays.fill(result, Integer.MIN_VALUE);
		for(int i = 0; i<a.length;i++) {
			if(a[i]>result[2]) {
				shiftall(a[i], result);
				continue;
			}
			if(a[i]<=result[2] && a[i]>result[1]) {
				shifttwo(a[i], result);
				continue;
			}
			if(a[i]<=result[1] && a[i]<=result[2] && a[i]>result[0]) {
				result[0] = a[i];
			}
		}
		return Arrays.toString(result);
	}
	
	public static void shiftall(int a, int[] result) {
		result[0] = result[1];
		result[1] = result[2];
		result[2] = a;
	}
	
	public static void shifttwo(int a, int[] result) {
		result[0] = result[1];
		result[1] = a;
	}
}
