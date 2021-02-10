package MEDIUM;

import java.lang.reflect.Array;
import java.util.*;

public class moveElementToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = new ArrayList<>();
		a.add(3);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(3);
		//System.out.println(twoPointers(a, 3));
		//System.out.println(twoArrays(a, 3));
		System.out.println(optimal(a, 3));
	}
	
	public static List<Integer> twoPointers(List<Integer> a, int n){
		if(!a.contains(n)){
			return a;
		}
		int[] num = new int[a.size()];
		int p = 0;
		for(Integer i: a) {
			num[p++] = i;
		}
		
		int i = 0, j = num.length - 1;
		while(i<=j) {
			if(num[i] != n) {
				i++;
				continue;
			}
			
			if(num[i] == n && num[j] != n) {
				int temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				j--;
				i++;
				continue;
			}
			
			if(num[j] == n) {
				j--;
				continue;
			}
		}
		a.clear();
		for(Integer k: num) {
			a.add(k);
		}
		return a;
	}
	
	public static List<Integer> twoArrays(List<Integer> a, int n){
		int[] num = new int[a.size()];
		int p = 0, count = 0;
		for(Integer i: a) {
			if(i == n)
				count++;
			num[p++] = i;
		}
		if(count == 0 || count == a.size()) {
			return a;
		}
		p = 0;
		int[] temp = num;
		for(int i = 0; i<num.length;i++) {
			if(num[i] != n) {
				temp[p++] = num[i];
			}
		}
		for(int i = temp.length - 1;i>temp.length - count; i--) {
			temp[i] = n;
		}
		a.clear();
		for(Integer i: temp) {
			a.add(i);
		}
		return a;
	}
	
	public static List<Integer> optimal(List<Integer> a, int n){
		int start = 0;
		int end = a.size() - 1;
		
		while(start<end) {
			if(a.get(end) == n) {
				end--;
				continue;
			}
			if(a.get(start) == n) {
				swap(start, end, a);
			}
			start++;
		}
		return a;
	}
	
	public static void swap(int i, int j, List<Integer> a) {
		int temp = a.get(j);
		a.set(j, a.get(i));
		a.set(i, temp);
	}

}
