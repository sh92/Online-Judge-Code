package cracking.dfs.connectedcell;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	static int maxRegion(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				visited[i][j] = false;
			}
		}

		int max = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				int cnt = dfs(grid, grid.length, grid[0].length, i, j, visited);
				max = cnt > max ? cnt : max;
			}

		return max;
	}

	private static int dfs(int[][] grid, int maxrows, int maxcols, int cur_row, int cur_col, boolean[][] visited) {
		if (outOfBound(cur_row, cur_col, maxrows, maxcols))
			return 0;
		if (grid[cur_row][cur_col] == 0)
			return 0;
		if (visited[cur_row][cur_col] == true)
			return 0;
		visited[cur_row][cur_col] = true;

		int count = 1;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int neigbor_row = cur_row + i;
				int neigbor_col = cur_col + j;
				count += dfs(grid, maxrows, maxcols, neigbor_row, neigbor_col, visited);
			}
		}
		return count;
	}

	private static boolean outOfBound(int cur_row, int cur_col, int maxrows, int maxcols) {
		return (cur_row < 0 || cur_row >= maxrows) || (cur_col < 0 || cur_col >= maxcols);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("tmp/out"));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int m = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[][] grid = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] gridRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < m; j++) {
				int gridItem = Integer.parseInt(gridRowItems[j]);
				grid[i][j] = gridItem;
			}
		}
		int res = maxRegion(grid);
		System.out.println(res);

		// bufferedWriter.write(String.valueOf(res));
		// bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
