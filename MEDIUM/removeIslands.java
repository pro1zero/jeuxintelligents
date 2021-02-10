package MEDIUM;

public class removeIslands {

	public static void main(String[] args) {
		int[][] matrix = 
						{{1, 0, 0, 0, 0, 0},
		                  {0, 1, 0, 1, 1, 1},
		                  {0, 0, 1, 0, 1, 0},
		                  {1, 1, 0, 0, 1, 0},
		                  {1, 0, 1, 1, 0, 0},
		                  {1, 0, 0, 0, 0, 1}};
		System.out.println(remove(matrix));
	}
	
	public static int[][] remove(int[][] matrix){
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i] == 1) {
				dfs(0, i, matrix, visited);
			}
		}
		for(int i = 0; i < matrix[0].length; i++) {
			if(matrix[matrix.length - 1][i] == 1){
				dfs(matrix.length - 1, i, matrix, visited);
			}
		}
		for(int i = 0 ; i < matrix.length; i++) {
			if(matrix[i][0] == 1) {
				dfs(i, 0, matrix, visited);
			}
		}
		for(int i = 0 ; i < matrix.length; i++) {
			if(matrix[i][matrix[0].length - 1] == 1) {
				dfs(i, matrix[0].length - 1, matrix, visited);
			}
		}
		
		for(int i = 1; i < matrix.length - 1; i++) {
			for(int j = 1; j < matrix[i].length - 1; j++) {
				if(visited[i][j]) continue;
				if(matrix[i][j] == 1) matrix[i][j] = 0;
			}
		}
		return matrix;
	}
	
	public static void dfs(int i, int j, int[][] matrix, boolean[][] visited) {
		if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || matrix[i][j] == 0)
			return;
		visited[i][j] = true;
		dfs(i - 1, j, matrix, visited);
		dfs(i + 1, j, matrix, visited);
		dfs(i, j - 1, matrix, visited);
		dfs(i, j + 1, matrix, visited);
	}

}
