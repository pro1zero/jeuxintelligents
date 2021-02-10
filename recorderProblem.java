import java.util.*;
public class recorderProblem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		long[][] intervals = new long[(int) n][2];
		for(int i = 0; i < n; i++) {
			intervals[i][0] = scan.nextLong();
			intervals[i][1] = scan.nextLong();
		}
		getMax(intervals, k);
		scan.close();
	}
	
	public static void getMax(long[][] intervals, int k) {
		if(k >= intervals.length) {
			System.out.println(k);
			return;
		}
		if(k == 0) {
			System.out.println(0);
			return;
		}
		Arrays.sort(intervals, (a, b) -> Integer.compare((int) a[1], (int) b[1]));
		List<long[]> tapes = new ArrayList<>();
		long result = 0;
		for(int i = 0; i < intervals.length; i++) {
			long currentStart = intervals[i][0];
			if(tapes.size() == 0) {
				tapes.add(intervals[i]);
				result += 1;
			}else {
				int j = tapes.size() - 1;
				List<long[]> toRemove = new ArrayList<>();
				while(j >= 0) {
					if(currentStart >= tapes.get(j)[1]) {
						toRemove.add(tapes.get(j));
					}
					j -= 1;
				}
				for(int p = 0; p < toRemove.size(); p++) {
					tapes.remove(toRemove.get(p));
				}
				if(tapes.size() < k) {
					tapes.add(intervals[i]);
					result += 1;
				}
			}
		}
		System.out.println(result);
	}
}
