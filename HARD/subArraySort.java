package HARD;
import java.util.*;

//this algorithm requires to sort the array in-place. Also, the time complexity should not exceed O(n).
public class subArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,1};
		//System.out.println(naive(a));
		System.out.println(optimal(a));
	}
	
	public static String naive(int[] a) {
		int[] copy = a.clone();
		int start = Integer.MIN_VALUE;
		int end = Integer.MAX_VALUE;
		Arrays.sort(a);
		for(int i = 0; i<a.length;i++) {
			if(a[i] != copy[i]) {
				start = i;
				break;
			}
		}
		for(int i = a.length - 1; i>=0;i--) {
			if(a[i] != copy[i]) {
				end = i;
				break;
			}
		}
		
		if(start != Integer.MIN_VALUE)
			return Arrays.toString(new int[] {start, end});
		else
			return Arrays.toString(new int[] {-1, -1});
	}
	
	public static String optimal(int[] a) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i<a.length;i++) {
			if(isOutOfOrder(i, a)) {
				min = Math.min(min, a[i]);
				max = Math.max(max, a[i]);
			}
		}
		
		if(min == Integer.MAX_VALUE)
			return Arrays.toString(new int[] {-1, -1});
		
		int left = 0;
		int right = a.length - 1;
		
		while(min >= a[left]) {
			left++;
		}
		while(max <= a[right]) {
			right--;
		}
		return Arrays.toString(new int[] {left, right});
	}
	
	public static boolean isOutOfOrder(int index, int[] a) {
		if(index == 0)
			return a[index] > a[index + 1];
			
		if(index == a.length - 1)
			return a[index] < a[index - 1];
		
		return a[index] > a[index + 1] || a[index] < a[index - 1];
	}
}
