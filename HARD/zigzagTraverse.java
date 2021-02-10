package HARD;
import java.util.*;
public class zigzagTraverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,3,4,10}, {2,5,9,11}, {6,8,12,15}, {7,13,14,16}};
		System.out.println(zigzag(matrix));
	}
	
	public static List<Integer> zigzag(int[][] matrix){
		int height = matrix.length - 1;
		int width = matrix[0].length - 1;
		List<Integer> result = new ArrayList<>();
		int row = 0;
		int col = 0;
		boolean goingDown = true;
		while(!isOutOfBounds(row, col, height, width)) {
			result.add(matrix[row][col]);
			if(goingDown) {
				if(row == height || col == 0) {
					goingDown = false;
					if(row == height) {
						col += 1;
					}
					else {
						row += 1;
					}
				}
				else {
					row += 1;
					col -= 1;
				}
			}
			else {
				if(row == 0 || col == width) {
					goingDown = true;
					if(col == width) {
						row += 1;
					}
					else {
						col += 1;
					}
				}
				else {
					row -= 1;
					col += 1;
				}
			}
		}
		return result;
	}
	
	public static boolean isOutOfBounds(int row, int col, int height, int width) {
		return (row < 0 || row > height || col < 0 || col > width);
	}

}
