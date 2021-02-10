package MEDIUM;
import java.util.*;
public class powerSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3};
		System.out.println(powerS(nums));
		System.out.println(recursion(nums));
	}
	
	public static List<List<Integer>> powerS(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		
		if(nums.length == 0)
			return result;
		
		for(Integer num: nums) {
			int length = result.size();
			for(int i = 0; i<length;i++) {
				List<Integer> temp = new ArrayList<>(result.get(i));
				temp.add(num);
				result.add(temp);
			}
		}
		return result;
	}
	
	public static List<List<Integer>> recursion(int[] nums){
		List<List<Integer>> subsets = new ArrayList<>();
		helper(0, nums, new ArrayList<Integer>(), subsets);
		
		return subsets;
	}
	
	public static void helper(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets){
		subsets.add(new ArrayList<>(current));
		for(int i = index; i<nums.length;i++) {
			current.add(nums[i]);
			helper(i + 1, nums, current, subsets);
			current.remove(current.size() - 1);
		}
	}
}
