import java.util.*;
public class grouping {

	public static void main(String[] args) {
		List<String> nums = new ArrayList<>();
		String input = "";
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine();
		while(!input.equals("bye")) {
			nums.add(input);
			input = scan.nextLine();
		}
		helper(nums);
		scan.close();
	}
	
	public static void helper(List<String> nums) {
		for(int i = 0; i < nums.size(); i++) {
			Integer[][] dp = new Integer[25][226];
			System.out.println((i+1) + "." + countGroupings(0, 0, nums.get(i).length(), nums.get(i), dp));
		}
	}
	
	public static int countGroupings(int position, int previousSum, int length, String num, Integer[][] dp) {
		if(position == length) return 1;
		if(dp[position][previousSum] != null) {
			return dp[position][previousSum];
		}
		dp[position][previousSum] = 0;
		int result = 0;
		int sum = 0;
		for(int i = position; i < length; i++) {
			sum += num.charAt(i) - '0';
			if(sum >= previousSum)
				result += countGroupings(i + 1, sum, length, num, dp);
		}
		dp[position][previousSum] = result;
		return result;
	}

}