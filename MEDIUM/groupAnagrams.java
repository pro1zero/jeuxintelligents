package MEDIUM;
import java.util.*;
public class groupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> words = new ArrayList<>();
		words.add("yo");
		words.add("act");
		words.add("flop");
		words.add("tac");
		words.add("cat");
		words.add("oy");
		words.add("oflp");
		
		//System.out.println(naive(words));
		System.out.println(optimal(words));
	}
	public static List<List<String>> optimal(List<String> words){
		Map<String, List<String>> map = new HashMap<>();
		
		for(String s: words) {
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			String sorted = new String(arr);
			
			
			if(map.containsKey(sorted)) {
				map.get(sorted).add(s);
			}
			else {
				map.put(sorted, new ArrayList<String>(Arrays.asList(s)));
			}
		}
		
		List<List<String>> output = new ArrayList<>();
		for(Map.Entry<String, List<String>> entry: map.entrySet()) {
			output.add(entry.getValue());
		}
		return output;
		
	}
	public static List<List<String>> naive(List<String> words){
		String[] temp = new String[words.size()];
		
		int p = 0;
		for(String s: words) {
			temp[p++] = s;
		}
		String[] copy = temp.clone();
		for(int i = 0; i<temp.length;i++) {
			char[] tempstring = temp[i].toCharArray();
			Arrays.sort(tempstring);
			temp[i] = new String(tempstring);
		}
		
		//System.out.println(Arrays.toString(temp));
		
		Set<String> counts = new HashSet<>();
		for(int i = 0; i<temp.length;i++) {
			counts.add(temp[i]);
		}
		p = 0;
		String[] fin = new String[counts.size()];
		List<List<String>> result = new ArrayList<>();
		for(String s: counts) {
			fin[p++] = s;
		}
		System.out.println(Arrays.toString(fin));
		System.out.println(Arrays.toString(copy));
		System.out.println(Arrays.toString(temp));
		for(int i = 0; i<fin.length;i++) {
			List<String> lol = new ArrayList<>();
			for(int j = 0; j<temp.length;j++) {
				if(fin[i].equals(temp[j])) {
					lol.add(copy[j]);
				}
			}
			result.add(lol);
		}
		return result;
	}

}
