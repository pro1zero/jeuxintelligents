package EASY;

import java.util.Arrays;

public class insertionSort {
	public static void main(String[] args) {
		int[] a = {1222,222,352,44,15};
		insertion(a);
		insertionvariant(a);
	}
	
	public static void insertion(int[] a) {
		if(a.length == 0)
			System.out.println("empty array");
		for(int i = 1; i<a.length;i++) {
			int j = i;
			while(j>0 && a[j]<a[j-1]) {
				a[j] = a[j] + a[j-1];
				a[j-1] = a[j] - a[j-1];
				a[j] = a[j] - a[j-1];
				j--;
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	public static void insertionvariant(int[] a) {
		for(int i = 1; i<a.length; i++) {
			for(int j = i; j>0; j--) {
				if(a[j]<a[j-1]) {
					a[j] = a[j] + a[j-1];
					a[j-1] = a[j] - a[j-1];
					a[j] = a[j] - a[j-1];
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
