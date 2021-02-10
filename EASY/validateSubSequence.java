package EASY;
import java.util.*;
public class validateSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = new ArrayList<>();
		nums.add(5);nums.add(1);nums.add(22);nums.add(25);
		nums.add(6);nums.add(-1);nums.add(8);nums.add(10);
		List<Integer> seq = new ArrayList<>();
		seq.add(1);seq.add(6);seq.add(-1);seq.add(10);
		System.out.println(validateSub(nums, seq));
	}
	
	public static boolean validateSub(List<Integer> nums, List<Integer> seq) {
		if(nums.equals(seq) || seq.isEmpty())
			return true;
		if(seq.size() > nums.size())
			return false;
		
		int i = 0;
		while(i < nums.size()) {
			if(seq.isEmpty())
				break;
			if(nums.get(i) == seq.get(0)) {
				seq.remove(0);
			}
			i++;
		}
		return seq.size() == 0;
	}
}
