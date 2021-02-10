package MEDIUM;
import java.util.*;
public class sunsetViews {

	public static void main(String[] args) {
		int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};
		System.out.println(getList(buildings, "WEST"));
	}

	public static ArrayList<Integer> getList(int[] buildings, String direction){
		ArrayList<Integer> result = new ArrayList<>();
		boolean traverseBackward = (direction.equals("EAST")) ? true : false;
		if(traverseBackward)
			result = reverse(buildings);
		else
			result = forward(buildings);
		return result;
	}
	
	public static ArrayList<Integer> reverse(int[] buildings){
		ArrayList<Integer> result = new ArrayList<>();
		int pivot = Integer.MIN_VALUE;
		int i = buildings.length - 1;
		while(i >= 0) {
			if(buildings[i] > pivot) {
				result.add(i);
				pivot = buildings[i];
			}
			i -= 1;
		}
		Collections.sort(result);
		return result;
	}
	
	public static ArrayList<Integer> forward(int[] buildings){
		ArrayList<Integer> result = new ArrayList<>();
		int pivot = Integer.MIN_VALUE;
		int i = 0;
		while(i < buildings.length) {
			if(buildings[i] > pivot) {
				result.add(i);
				pivot = buildings[i];
			}
			i += 1;
		}
		return result;
	}
}
