package MEDIUM;
import java.util.*;
public class searchInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,4,7,12,15,1000}, {2,5,19,31,32,1001}, {3,8,24,33,35,1002}, {40,41,42,44,45,1003}, {99,100,103,106,128,1004}};
		System.out.println(mostnaive(matrix, 44));
	}
	
	public static String mostnaive(int[][] m, int target) {
		for(int i = 0; i<m.length;i++) {
			for(int j = 0; j<m[i].length;j++) {
				if(m[i][j] == target) {
					return Arrays.toString(new int[] {i, j});
				}
			}
		}
		return Arrays.toString(new int[] {-1, -1});
	}
	
	public static String optimal(int[][] m, int target) {
		int row = 0;
		int col = m[row].length - 1;
		
		while(row<m.length && col>=0) {
			if(m[row][col] > target) {
				col--;
			}
			else if(m[row][col] < target) {
				row++;
			}
			else {
				return Arrays.toString(new int[] {row, col});
			}
		}
		return Arrays.toString(new int[] {-1, -1});
	}
}
