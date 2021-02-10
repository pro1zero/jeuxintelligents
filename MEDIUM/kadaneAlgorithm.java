package MEDIUM;
import java.util.*;
public class kadaneAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-1000, -1000, 2,4,-5, -6,-7, -8 ,-2, -100};
		System.out.println(onepass(a));
		System.out.println(twopass(a));
		System.out.println(naiveKadane(a));
	}
	
	public static int twopass(int[] a) {
		int[] dp = new int[a.length];
		dp[0] = a[0];
		
		for(int i = 1; i<dp.length;i++) {
			dp[i] = Math.max(dp[i-1] + a[i], a[i]);
		}
		int max = dp[0];
		for(int i = 1; i<dp.length;i++) {
			if(dp[i]>max) {
				max = dp[i];
			}
		}
		System.out.println("twopass: " + Arrays.toString(dp));
		return max;
	}
	
	public static int onepass(int[] a) {
		int[] dp = new int[a.length];
		dp[0] = a[0];
		int max = dp[0];
		for(int i = 1; i<dp.length;i++) {
			dp[i] = Math.max(dp[i-1] + a[i], a[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	//doesn't works
	public static int naiveKadane(int[] a) {
		int[] maxsums = new int[a.length];
		int result = a[0];
		for(int i = 0; i<a.length;i++) {
			int sum = 0, max = 0;
			for(int j = i; j<a.length;j++) {
				sum += a[j];
				max = Math.max(a[i], sum);
			}
			maxsums[i] = max;
			result = Math.max(result, maxsums[i]);
		}
		System.out.println(Arrays.toString(maxsums));
		return result;
	}
}
