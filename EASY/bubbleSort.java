package EASY;
import java.util.*;
public class bubbleSort {
	public static void main(String[] args) {
		int[] a = {1,3,2};
		bubblesort(a);
		bubblesortnew(a);
	}
	
	public static void bubblesort(int[] a) {
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
	}
	
	public static void bubblesortnew(int[] a) {
		for(int i = 0; i<a.length;i++) {
			for(int j = 1;j<a.length - i;j++) {
				if(a[j]<a[j-1]) {
					swap(a[j], a[j-1]);
				}
			}
		}
		System.out.println("bubble sort new: " + Arrays.toString(a));
	}
	
	public static void swap(int a, int b) {
		int temp = b;
		b = a;
		a = temp;
	}
}
