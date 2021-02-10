package MEDIUM;

import java.util.Arrays;

public class maximumSubsetNoAdjacent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {75, 105, 120, 75, 90, 135};
		//System.out.println(dynamic(a));
		System.out.println(optimal(a));
		
	}
	//time: O(n) | Space: O(n)
	public static int dynamic(int[] a) {
		if(a.length == 0)
			return 0;
		if(a.length == 1)
			return a[0];
		if(a.length == 2)
			return Math.max(a[0],  a[1]);
		
		int[] dp = a;
		dp[1] = Math.max(a[0],  a[1]);
		for(int i = 2; i<a.length;i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + a[i]);
		}
		return dp[dp.length - 1];
	}
	//time: O(n) | Space: O(1)
	
	public static int optimal(int[] a) {
		if(a.length == 0)
			return 0;
		if(a.length == 1)
			return a[0];
		
		int first = a[0];
		int second = Math.max(a[0], a[1]);
		//System.out.println("fs" + first + " " + second);
		System.out.println(Arrays.toString(a));
		for(int i = 2; i<a.length;i++) {
			int temp = first + a[i];
			int current = Math.max(second, temp);
			
			//System.out.println(first + " " + second + " " + a[i] + " "	+ temp);
			first = second;
			second = current;
			
		}
		System.out.println(Arrays.toString(a));
		return second;
	}
}
