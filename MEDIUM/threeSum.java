package MEDIUM;
import java.util.*;
public class threeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {12,3,1,2,-6,5,-8,6};
		int target = 0;
	//	System.out.println(naive(a, target));
		System.out.println(optimal(a, target));
	}
	
	public static List<List<Integer>> naive(int[] a, int t){
		Arrays.sort(a);
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0; i<a.length;i++) {
			List<Integer> temp = new ArrayList<>();
			boolean flag = true;
			for(int j = 0; j<a.length;j++) {
				for(int k = 0; k<a.length;k++) {
					if(a[i] + a[j] + a[k] == t && i!=j && j!=k && k!=i) {
						temp.add(a[i]);
						temp.add(a[j]);
						temp.add(a[k]);
						list.add(temp);
						flag = false;
						break;
					}
				}
				if(!flag)
					break;
			}
		}
		return list;
	}
	
	public static List<Integer[]> optimal(int[] a, int t){
		Arrays.sort(a);
		List<Integer[]> result = new ArrayList<Integer[]>();
		for(int i = 0; i<a.length - 2;i++) {
			int num = a[i];
			int left = i + 1;
			int right = a.length - 1;
			while(left < right) {
				if(a[left] + a[right] + num == t) {
					Integer[] triplets = {num, a[left], a[right]};
					result.add(triplets);
					left++;
					right--;
				}
				else if(a[left] + a[right] + num < t) {
					left++;
				}
				else if(a[left] + a[right] + num > t) {
					right--;
				}
			}
		}
		return result;
	}

}
