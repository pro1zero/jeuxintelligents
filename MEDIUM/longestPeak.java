package MEDIUM;

public class longestPeak {
	public static void main(String[] args) {
		int[] a = {5, 4, 3, 2, 1, 2, 10, 12, -3, 5, 6, 7, 10};
		System.out.println(longest(a));
	}
	
	public static int longest(int[] a) {
		int result = 0;
		int i = 1;
		while(i < a.length - 1) {
			boolean flag = a[i] > a[i-1] && a[i] > a[i+1];
			if(!flag) {
				i += 1;
				continue;
			}
			int leftIndex = i - 2;
			while(leftIndex >=0 && a[leftIndex] < a[leftIndex + 1]) {
				leftIndex -= 1;
			}
			
			int rightIndex = i + 2;
			while(rightIndex < a.length && a[rightIndex] < a[rightIndex - 1]) {
				rightIndex += 1;
			}
			int currentLength = rightIndex - leftIndex - 1;
			if(currentLength > result)
				result = currentLength;
			i = rightIndex;
		}
		return result;
	}
}
