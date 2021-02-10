package VERYHARD;
import java.util.*;
public class apartmentHunting {

	public static void main(String[] args) {
		List<Map<String, Boolean>> blocks = new ArrayList<>();
		Map<String, Boolean> m1 = new HashMap<>();
		m1.put("gym", false);m1.put("school", true);m1.put("store", false);
		Map<String, Boolean> m2 = new HashMap<>();
		m2.put("gym", true);m2.put("school", false);m2.put("store", false);
		Map<String, Boolean> m3 = new HashMap<>();
		m3.put("gym", true);m3.put("school", true);m3.put("store", false);
		Map<String, Boolean> m4 = new HashMap<>();
		m4.put("gym", false);m4.put("school", true);m4.put("store", false);
		Map<String, Boolean> m5 = new HashMap<>();
		m5.put("gym", false);m5.put("school", true);m5.put("store", true);
		blocks.add(m1);
		blocks.add(m2);
		blocks.add(m3);
		blocks.add(m4);
		blocks.add(m5);
		String[] reqs = {"gym", "school", "store"};
//		System.out.println(huntApartment(blocks, reqs));
		System.out.println(optimal(blocks, reqs));
	}
	
	public static int huntApartment(List<Map<String, Boolean>> blocks, String[] reqs) {
		int[] maxDistances = new int[blocks.size()];
		Arrays.fill(maxDistances, Integer.MIN_VALUE);
		for(int i = 0; i < blocks.size(); i++) {
			for(String req: reqs) {
				int closest = Integer.MAX_VALUE;
				for(int j = 0; j < blocks.size(); j++) {
					if(blocks.get(j).get(req))
						closest = Math.min(closest, Math.abs(i - j));
				}
				maxDistances[i] = Math.max(maxDistances[i], closest);
			}
		}
		int minIndex = 0;
		int minValue = Integer.MAX_VALUE;
		for(int i = 0; i < maxDistances.length; i++) {
			if(maxDistances[i] < minValue) {
				minValue = maxDistances[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public static int optimal(List<Map<String, Boolean>> blocks, String[] reqs) {
		long[][] minDistances = new long[reqs.length][blocks.size()];
		for(int i = 0; i < reqs.length; i++) {
			for(int j = 0; j < blocks.size(); j++) {
				minDistances[i][j] = Integer.MAX_VALUE;
				if(blocks.get(j).get(reqs[i])) {
					minDistances[i][j] = 0;
				}
				else if(j != 0) {
					minDistances[i][j] = minDistances[i][j-1] + 1;
				}
			}
			for(int j = blocks.size() - 2; j >= 0; j--) {
				minDistances[i][j] = Math.min(minDistances[i][j], minDistances[i][j+1] + 1);
			}
		}
		for(long[] minDist: minDistances) {
			System.out.println(Arrays.toString(minDist));
		}
		System.out.println();
		int[] maxDistances = new int[blocks.size()];
		for(int i = 0; i < minDistances[0].length; i++) {
			int max = Integer.MIN_VALUE;
			for(int j = 0; j < minDistances.length; j++) {
				max = (int) Math.max(max, minDistances[j][i]);
			}
			maxDistances[i] = max;
		}
		int bestApartment = maxDistances[0];
		int index = 0;
		for(int i = 1; i < maxDistances.length; i++) {
			if(bestApartment > maxDistances[i]) {
				bestApartment = maxDistances[i];
				index = i;
			}
		}
		return index;
	}

}
