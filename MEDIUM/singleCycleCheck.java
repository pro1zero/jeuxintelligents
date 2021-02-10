package MEDIUM;
import java.util.*;
public class singleCycleCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,-2,3,7,8,-26};
		//System.out.println(cyclecheck(a));
		//System.out.println(Cycle(a));
		System.out.println(optimal(a));
	}
	//works for 90% test cases
	public static boolean cyclecheck(int[] a) {
		if(a.length == 0 || a.length == 1)
			return true;
		boolean[] flags = new boolean[a.length];
		
		//flags[0] = true;
		
		for(int i = 0; i<a.length;i++) {
			int round = i + a[i];
			if(round<0) {
				round = (a.length + round)%a.length;
				flags[round] =! flags[round];
			}
			else if(round>=a.length) {
				round %= a.length;
				flags[round] =! flags[round];
			}
			else {
				flags[round] =! flags[round];
			}
			
		}
		System.out.println(Arrays.toString(flags));
		for(int i = 0; i<flags.length;i++) {
			if(flags[i] == false) {
				return false;
			}
		}
		return true;
	}
	//works for 90% test cases
	public static boolean Cycle(int[] a) {
		if(a.length == 0 || a.length == 1)
			return true;
		int count = a.length;
		boolean[] flags = new boolean[a.length];
		int pin = 0;
		
		while(count>0) {
			System.out.println(pin);
			System.out.println(Arrays.toString(flags));
			count--;
			int round = pin + a[pin];
			if(round>=a.length)
				round %= a.length;
			if(round<0)
				round = round + a.length;
			flags[round] =!flags[round];
			pin = round;
			if(pin>=a.length)
				pin = pin % a.length;
			if(pin<0) {
				pin = pin + a.length;
			}
		}
		System.out.println(Arrays.toString(flags));
		for(int i = 0; i<flags.length;i++) {
			if(flags[i] == false) {
				return false;
			}
		}
		if(pin == 0)
			return true;
		else
			return false;
	}
	
	public static boolean optimal(int[] a) {
		int visited = 0;
		int current = 0;
		
		while(visited < a.length) {
			if(visited > 0 && current == 0) {
				return false;
			}
			visited++;
			current = helper(current, a);
		}
		return current == 0;
	}
	
	public static int helper(int current, int[] a) {
		int jump = a[current];
		int next = (current + jump)% a.length;
		
		return next >= 0? next: next + a.length;
	}
}
