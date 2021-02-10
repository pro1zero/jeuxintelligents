package MEDIUM;



import java.util.*;



public class taskAssignment {



	public static void main(String[] args) {
		ArrayList<Integer> tasks = new ArrayList<>();
		tasks.add(1);tasks.add(3);tasks.add(5);
		tasks.add(3);tasks.add(1);tasks.add(4);
		System.out.println(getMin(3, tasks));
	}

	

	public static ArrayList<ArrayList<Integer>> getMin(int k, ArrayList<Integer> tasks){

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();

		for(int i = 0; i < tasks.size(); i++) {

			if(map.containsKey(tasks.get(i))) {

				ArrayList<Integer> temp = map.get(tasks.get(i));

				temp.add(i);

				map.put(tasks.get(i), temp);

			}else {

				ArrayList<Integer> temp = new ArrayList<>();

				temp.add(i);

				map.put(tasks.get(i), temp);

			}

		}

		System.out.println(map);

		Collections.sort(tasks);

		int left = 0, right = tasks.size() - 1;

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		while(left < right) {

			ArrayList<Integer> currentResult = new ArrayList<>();

			currentResult.add(map.get(tasks.get(left)).get(0));

			ArrayList<Integer> temp = map.get(tasks.get(left));

			temp.remove(0);

			map.put(tasks.get(left), temp);

			currentResult.add(map.get(tasks.get(right)).get(0));

			temp = map.get(tasks.get(right));

			temp.remove(0);

			map.put(tasks.get(right), temp);

			result.add(currentResult);
			left += 1;
			right -= 1;

		}

		return result;
	}
}