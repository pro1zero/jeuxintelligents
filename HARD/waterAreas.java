package HARD;

public class waterAreas {

	public static void main(String[] args) { 
		// TODO Auto-generated method stub
	int[] heights = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
	System.out.println(waterAreass(heights));
	}
	
	public static int waterAreass(int[] heights) {
		if(heights.length < 3)
			return 0;
		
		int[] maxSoFar = new int[heights.length + 1];
		for(int i = 0; i < heights.length; i++) {
			maxSoFar[i+1] = Math.max(maxSoFar[i], heights[i]);
		}
		
		int rightMax = 0;
		int totalVol = 0;
		for(int i = heights.length - 1;i >= 0; i--) {
			rightMax = Math.max(rightMax, heights[i]);
			if(Math.min(maxSoFar[i+1], rightMax) > heights[i]) {
				totalVol += Math.min(maxSoFar[i+1], rightMax) - heights[i];
			}
		}
		return totalVol;
	}
}
