package MEDIUM;
import java.util.*;
public class spiralTraverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3,4}, {12,13,14,5}, {11,16,15,6}, {10,9,8,7}};
		System.out.println(spiralT(matrix));
	}
	
	public static List<Integer> spiralT(int[][] matrix){
		List<Integer> result = new ArrayList<>();
		int startRow = 0;
		int startCol = 0;
		
		int endRow = matrix.length - 1;
		int endCol = matrix[0].length - 1;
		
		while(startRow <= endRow && startCol <= endCol) {
			for(int col = startCol; col <= endCol; col++) {
				result.add(matrix[startRow][col]);
			}
			for(int row = startRow + 1; row <= endRow; row++) {
				result.add(matrix[row][endCol]);
			}
			for(int col = endCol - 1; col >= startCol; col--) {
				if(endCol == startCol)
					break;
				result.add(matrix[endRow][col]);
			}
			for(int row = endRow - 1; row > startRow; row--) {
				if(endRow == startRow)
					break;
				result.add(matrix[row][startCol]);
			}
			startRow += 1;
			endRow -= 1;
			startCol += 1;
			endCol -= 1;
		}
		return result;
	}

}
