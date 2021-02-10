package EASY;

public class binarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,2,6,33,67,90};
		System.out.print(binarySearch(a, 9));
		//System.out.print(binarySearchRecursion(a, 9));
	}
	public static int binarySearch(int[] a, int target) {
		int low = 0;
		int high = a.length - 1;
		int count = 0;
		while(low<=high) {
			count++;
			int mid = (low + high)/2;
			if(a[mid] == target) {
				System.out.println(count);
				return mid;
			}
			else if(target<a[mid]) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
			
		}
		System.out.println(count);
		return -1;
	}
	
	public static int binarySearchRecursion(int[] a, int target) {
		return helperMethod(a, target, 0, a.length-1,0);
	}
	public static int helperMethod(int[] a, int target, int low, int high, int count) {
		count++;
		if(low > high) {
			System.out.println(count);
			return -1;
		}
		
		int mid = (low + high)/2;
		if(target == a[mid]) {
			return mid;
		}
		else if(target>a[mid]) {
			return helperMethod(a, target,  mid + 1, high, count);
		}
		else {
			return helperMethod(a, target, low, mid - 1, count);
		}
	}

}
