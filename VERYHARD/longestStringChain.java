package VERYHARD;
import java.util.*;
public class longestStringChain {

	public static void main(String[] args) {
		List<String> input = new ArrayList<>();
		input.add("abde");
		input.add("abc");
		input.add("abd");
		input.add("abcde");
		input.add("ade");
		input.add("ae");
		input.add("1abde");
		input.add("abcdef");
		input.add("sdsdfsdfsdf");
		System.out.println(lsc(input));
	}
	
	public static List<String> lsc(List<String> input){
		Collections.sort(input, (a, b) -> a.length() - b.length());
		Map<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		for(int i = 0; i < input.size(); i++) {
			map.put(input.get(i), 1);
			set.add(input.get(i));
		}
		String head = "";
		int headIndex = 0;
		int longestChain = Integer.MIN_VALUE;
		for(int i = 1; i < input.size(); i++) {
			String s = input.get(i);
			for(int j = 0; j < s.length(); j++) {
				String newS = s.substring(0,j) + s.substring(j+1, s.length());
				if(set.contains(newS)) {
					map.put(s, Math.max(map.get(s), map.get(newS) + 1));
					set.add(newS);
					int getMaxSoFar = Math.max(map.get(s), map.get(newS) + 1);
					if(longestChain < getMaxSoFar) {
						longestChain = getMaxSoFar;
						head = s;
						headIndex = i;
					}
				}
			}
		}
		List<String> result = new ArrayList<>();
		int previous = map.get(head);
		int index = headIndex;
		while(index >= 2) {
			if(index != headIndex && map.get(input.get(previous)) == (map.get(input.get(previous + 1))) - 1) {
				result.add(input.get(index));
			}
			previous -= 1;
			index--;
		}
		return result;
	}

}

