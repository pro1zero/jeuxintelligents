package HARD;
import java.util.*;
public class underscorifyString {

	public static void main(String[] args) {
		System.out.println(underScore("abcabcabcabcabcabcabcabcabcabcabcabcabcabc", "abc"));
	}
	
	public static String underScore(String s, String sub) {
		if(sub.length() > s.length()) return s;
		List<int[]> indices = new ArrayList<>();
		for(int i = 0; i < s.length() - sub.length() + 1; i++) {
			if(s.substring(i, i + sub.length()).equals(sub)){
				indices.add(new int[] {i, i + sub.length()});
			}
		}
		if(indices.size() == 0) return s;
		List<int[]> collapsed = new ArrayList<>();
		collapsed.add(indices.get(0));
		int[] previous = collapsed.get(0);
		for(int i = 1; i < indices.size(); i++) {
			if(previous[1] >= indices.get(i)[0]) {
				previous[1] = indices.get(i)[1];
			}else {
				collapsed.add(indices.get(i));
				previous = indices.get(i);
			}
		}
		String result = "";
		int[] finalIndices = new int[collapsed.size() * 2];
		int j = 0;
		for(int i = 0; i < collapsed.size(); i++) {
			finalIndices[j] = collapsed.get(i)[0];
			finalIndices[j+1] = collapsed.get(i)[1];
			j += 2;
		}
		j = 0;
		for(int i = 0; i < finalIndices.length; i++) {
			int current = finalIndices[i];
			while(j < current) {
				result += s.charAt(j++);
			}
			result += "_";
		}
		while(j < s.length()) result += s.charAt(j++);
		return result;
	}

}
