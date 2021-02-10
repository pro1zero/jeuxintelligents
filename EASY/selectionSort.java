package EASY;
import java.util.*;
public class selectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {8, 5, 2, 9, 5, 6, 3};
		//selection(a);
		selectionVariant(a);
	}
	
	public static void selection(int[] a) {
		int currentposition = 0;
		
		while(currentposition < a.length - 1) {
			int smallestIndex = currentposition;
			for(int i = currentposition + 1; i<a.length;i++) {
				if(a[smallestIndex] > a[i]) {
					smallestIndex = i;
				}
			}
			swap(currentposition, smallestIndex, a);
			currentposition++;
		}
		System.out.println(Arrays.toString(a));
	}
	
	public static void swap(int i, int j, int[] a) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	
	public static void selectionVariant(int[] a) {
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
	}
}
