package EASY;

import java.util.*;

public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(recursion(8));
		System.out.println(iterative(8));
		System.out.println(usinghashtable(8));
		System.out.println(optimal(8));
	}
	
	public static int optimal(int n) {
		int[] firsttwonums = {0,1};
		int counter = 3;
		
		while(counter <= n) {
			int next = firsttwonums[0] + firsttwonums[1];
			firsttwonums[0] = firsttwonums[1];
			firsttwonums[1] = next;
			counter++;
		}
		return n>1 ? firsttwonums[1]: firsttwonums[0];
	}
	public static int recursion(int n) {
		if(n == 2)
			return 1;
		else if(n == 1)
			return 0;
		else {
			return recursion(n-1) + recursion(n-2);
		}
	}
	
	public static int iterative(int n) {
		int a = 0;
		int b = 1;
		int c = 0;
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else {
			for(int i = 3; i<=n;i++) {
				c = a + b;
				a = b;
				b = c;
			}
		}
		return c;
	}
	
	public static int usinghashtable(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 0);
		map.put(2, 1);
		return usinghashtable(n, map);
	}
	
	public static int usinghashtable(int n, Map<Integer, Integer> map) {
		if(map.containsKey(n))
			return map.get(n);
		else {
			map.put(n, usinghashtable(n-1, map) + usinghashtable(n-2, map));
			return map.get(n);
		}
	}

}
