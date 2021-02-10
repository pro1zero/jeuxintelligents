package MEDIUM;
import java.util.*;
public class permutations {

	public static void main(String[] args) {
		List<List<Integer>> result = new ArrayList<>();
		int[] nums = {1, 2, 3};
		List<Integer> converted = new ArrayList<>();
	
		System.out.println(helper(0, converted, result));
	}
	
	public static List<List<Integer>> helper(int i, List<Integer> array, List<List<Integer>> result){
		if(i == array.size() - 1) {
			result.add(new ArrayList<Integer>(array));
		}
		else {
			for(int j = i;j<array.size();j++) {
				swap(i, j, array);
				helper(i+1, array, result);
				swap(i, j, array);
			}
		}
		return result;
	}
	
	public static void swap(int i, int j, List<Integer> array) {
		Integer temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
	}
}
