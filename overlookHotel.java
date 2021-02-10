import java.util.*;
public class overlookHotel {
	public static void main(String[] args) {
		List<Long> limits = new ArrayList<>();
		List<List<Long>> firstDishes = new ArrayList<>();
		List<List<Long>> mainDishes = new ArrayList<>();
		List<List<Long>> drinks = new ArrayList<>();
		List<List<Long>> candies = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		while(true) {
			long l = scan.nextLong();
			long f = scan.nextLong();
			long m = scan.nextLong();
			long d = scan.nextLong();
			long c = scan.nextLong();
			if(l == 0) {
				break;
			}
			limits.add(l);
			List<Long> temp = new ArrayList<>();
			for(int i = 0; i < (int) f; i++) {
				temp.add(scan.nextLong());
			}
			firstDishes.add(temp);
			temp = new ArrayList<>();
			for(int i = 0; i < (int) m; i++) {
				temp.add(scan.nextLong());
			}
			mainDishes.add(temp);
			temp = new ArrayList<>();
			for(int i = 0; i < (int) d; i++) {
				temp.add(scan.nextLong());
			}
			drinks.add(temp);
			temp = new ArrayList<>();
			for(int i = 0; i < (int) c; i++) {
				temp.add(scan.nextLong());
			}
			candies.add(temp);
			scan.nextLine();
		}
		helper(limits, firstDishes, mainDishes, drinks, candies);
		scan.close();
	}
	
	public static void helper(List<Long> l, List<List<Long>> f, List<List<Long>> m, List<List<Long>> d, List<List<Long>> c) {
		for(int i = 0; i < l.size(); i++) {
			long currentResult = 0;
			long currentLimit = l.get(i);
			List<Long> currentF = f.get(i);
			List<Long> currentM = m.get(i);
			List<Long> currentD = d.get(i);
			List<Long> currentC = c.get(i);
			Collections.sort(currentF);
			Collections.sort(currentM);
			Collections.sort(currentD);
			Collections.sort(currentC);
			List<Long> sumOne = new ArrayList<>();
			for(int j = 0; j < currentF.size(); j++) {
				for(int k = 0; k < currentM.size(); k++) {
					long sum = currentF.get(j) + currentM.get(k);
					if(sum <= currentLimit) {
						sumOne.add(sum);
						continue;
					}
					break;
				}
			}
			List<Long> sumTwo = new ArrayList<>();
			for(int j = 0; j < currentD.size(); j++) {
				for(int k = 0; k < currentC.size(); k++) {
					long sum = currentD.get(j) + currentC.get(k);
					if(sum <= currentLimit) {
						sumTwo.add(sum);
						continue;
					}
					break;
				}
			}
			Map<Long, Long> map = new HashMap<>();
			for(int j = 0; j < sumOne.size(); j++) {
				long currentKey = sumOne.get(j);
				long value = 0;
				for(int k = 0; k < sumTwo.size(); k++) {
					if(map.containsKey(currentKey)) {
						currentResult += map.get(currentKey);
						break;
					}
					long currentNum = sumTwo.get(k);
					if(currentKey + currentNum <= currentLimit) {
						currentResult += 1;
						value += 1;
					}
				}
				map.putIfAbsent(currentKey, value);
			}
			System.out.println(currentResult);
  		}
	}
}