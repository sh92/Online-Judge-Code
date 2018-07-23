package cracking.bfs.shortestreach;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int queries = scanner.nextInt();
		for (int i = 0; i < queries; i++) {
			int numOfVerticies = scanner.nextInt();
			int numOfEdges = scanner.nextInt();
			int[][] adj = new int[numOfVerticies + 1][numOfVerticies + 1];
			for (int j = 0; j < numOfEdges; j++) {
				int from = scanner.nextInt();
				int to = scanner.nextInt();
				adj[from][to] = 6;
				adj[to][from] = 6;
			}

			int start = scanner.nextInt();
			Queue<Integer> bfs = new LinkedList<Integer>();
			bfs.add(start);

			boolean[] visited = new boolean[numOfVerticies + 1];
			int[] distance = new int[numOfVerticies + 1];
			visited[start] = true;
			while (!bfs.isEmpty()) {
				int cur = bfs.poll();
				for (int vertice = 1; vertice <= numOfVerticies; vertice++) {
					if (adj[cur][vertice] != 0) {
						if (!visited[vertice]) {
							bfs.add(vertice);
							visited[vertice] = true;
							distance[vertice] = distance[cur] + adj[cur][vertice];
						}
					}
				}
			}

			for (int j = 1; j <= numOfVerticies; j++) {
				if (j == start)
					continue;
				if (distance[j] == 0) {
					System.out.print("-1 ");
				} else {
					System.out.print(distance[j] + " ");
				}
			}
			System.out.println();

		}
		scanner.close();
	}
}
