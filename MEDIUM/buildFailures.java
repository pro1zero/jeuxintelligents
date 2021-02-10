package MEDIUM;
import java.util.*;
public class buildFailures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] buildRuns = {
		                         {true, false, false, false, false, false},
		                         {true, false},
		                         {true, true, true, false, false},
		                         {true, true, true, true, false, false},
		                         {true, true, true, true, true, true, false, false, false},
		                         {true, true, true, true, false},
		                         {
		                           true,
		                           true,
		                           true,
		                           true,
		                           true,
		                           true,
		                           true,
		                           true,
		                           true,
		                           true,
		                           true,
		                           true,
		                           false
		                         }
		                       };
		System.out.println(makeRuns(buildRuns));
		}
	
	public static int makeRuns(boolean[][] buildRuns) {
		if(buildRuns.length == 0)
			return 0;
		float[] trues = new float[buildRuns.length];
		for(int i = 0; i < buildRuns.length; i++) {
			for(int j = 0; j < buildRuns[i].length; j++) {
				if(buildRuns[i][j])
					trues[i]++;
				else
					break;
			}
			trues[i] /= buildRuns[i].length;
			trues[i] *= 100;
			
		}
		System.out.println(Arrays.toString(trues));
		int longest = 1;
		int running = 1;
		for(int i = 1; i < trues.length; i++) {
			if(trues[i] < trues[i-1]) {
				running += 1;
			}
			else {
				running = 1;
			}
			longest = Math.max(longest, running);
		}
		return longest == 1?-1:longest;
	}
}
