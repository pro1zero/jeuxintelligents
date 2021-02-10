package VERYHARD;
import java.util.*;
public class squaresOfZero {

	public static void main(String[] args) {
		List<List<Integer>> matrix = new ArrayList<>();
		matrix.add(Arrays.asList(1,1,1,0,1,0));
		matrix.add(Arrays.asList(0,0,0,0,0,1));
		matrix.add(Arrays.asList(0,1,1,1,0,1));
		matrix.add(Arrays.asList(0,0,0,1,0,1));
		matrix.add(Arrays.asList(0,1,1,1,0,1));
		matrix.add(Arrays.asList(0,0,0,0,0,1));
		System.out.println(squareOfZero(matrix));
	}
	
	public static boolean squareOfZero(List<List<Integer>> matrix) {
		for(int i = 0; i < matrix.size(); i++) {
			for(int j = 0; j < matrix.get(i).size(); j++) {
				if(matrix.get(i).get(j) == 0) {
					if(checkForSquare(i, j, matrix)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean checkForSquare(int i, int j, List<List<Integer>> matrix) {
		int fixedRow = i;
		int fixedCol = j;
		int n = 0;
		while(i + 1 < matrix.size() && j + 1 < matrix.get(0).size() && matrix.get(fixedRow).get(j) == 0 && matrix.get(i).get(fixedCol) == 0) {
			i += 1;
			j += 1;
			n += 1;
			if(checkBackwards(i, j, n, matrix)) return true;
		}
		return false;
	}
	
	public static boolean checkBackwards(int i, int j, int n, List<List<Integer>> matrix) {
		int fixedRow = i;
		int fixedCol = j;
		
		while(n > 0 && matrix.get(fixedRow).get(j + n) == 0 && matrix.get(i + n).get(fixedCol) == 0) {
			n -= 1;
		}
		return n == 0;
	
	}
}
