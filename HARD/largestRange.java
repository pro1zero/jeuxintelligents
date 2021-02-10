package HARD;
import java.util.*;
public class largestRange {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,10};
		System.out.println(optimal(nums));
	}
	
	public static String optimal(int[] nums) {
		int[] bestRange = new int[2];
		int longestRange = 0;
		
		Map<Integer, Boolean> map = new HashMap<>();
		for(int num: nums) {
			map.put(num, true);
		}
		
		for(int num: nums) {
			if(!map.get(num)) {
				continue;
			}
			
			map.put(num, false);
			int currentLength = 1;
			int left = num - 1;
			int right = num + 1;
			
			while(map.containsKey(left)) {
				map.put(left, false);
				left--;
				currentLength++;
			}
			
			while(map.containsKey(right)) {
				map.put(right, false);
				right++;
				currentLength++;
			}
			
			if(currentLength > longestRange) {
				longestRange = currentLength;
				bestRange = new int[] {left + 1, right - 1};
			}
		}
		return Arrays.toString(bestRange);
	}
}
