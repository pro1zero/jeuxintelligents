package MEDIUM;

public class monotonicArray {

	public static void main(String[] args) {
		int[] a = {-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -8, -9, -10, -11};
		//System.out.println(monotonic(a));
		System.out.println(optimal(a));
	}
	
	public static boolean monotonic(int[] a) {
		if(a.length == 1 || a.length == 0)
			return true;
		
		if(a[0] > a[a.length - 1]) {
			for(int i = 1; i<a.length;i++) {
				if(!(a[i-1] >= a[i])) {
					return false;
				}
			}
		}
		else {
			for(int i = 1; i<a.length;i++) {
				if(!(a[i-1] <= a[i])) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean optimal(int[] a) {
		if(a.length <= 2)
			return true;
		
		boolean inc = true;
		boolean dec = true;
		
		for(int i = 0; i<a.length - 1;i++) {
			if(a[i] > a[i+1])
				inc = false;
			if(a[i] < a[i+1])
				dec = false;
		}
		return inc || dec;
	}

}
