package cracking.bfs.shortestreach;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Graph {
	int vertices;
	LinkedList<Integer>[] edges;

	public Graph(int vertices) {
		this.vertices = vertices;
		this.edges = new LinkedList[vertices + 1];
		for (int i = 1; i <= vertices; ++i)
			this.edges[i] = new LinkedList<Integer>();
	}

	void addEdge(int v, int w) {
		if (!this.edges[v].contains(w)) {
			this.edges[v].add(w);
		}
	}
}

public class Solution2 {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */

		Scanner scaner = new Scanner(System.in);
		int queries = scaner.nextInt();
		for (int query = 0; query < queries; query++) {
			int numOfVertices = scaner.nextInt();
			int NumOfEdges = scaner.nextInt();
			Graph graph = new Graph(numOfVertices);

			int[] dist = new int[numOfVertices + 1];
			int[][] adj = new int[numOfVertices + 1][numOfVertices + 1];

			for (int i = 0; i < NumOfEdges; i++) {
				int from = scaner.nextInt();
				int to = scaner.nextInt();

				graph.addEdge(from, to);
				graph.addEdge(to, from);

				adj[from][to] = 6;
				adj[to][from] = 6;
			}
			int start = scaner.nextInt();
			// printGraph(graph);

			boolean[] visited = new boolean[numOfVertices + 1];
			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.add(start);
			visited[start] = true;
			bfs(graph, visited, queue, dist, adj);
			for (int j = 1; j <= numOfVertices; j++) {
				if (j == start)
					continue;
				if (dist[j] == 0)
					System.out.print("-1 ");
				else
					System.out.print(dist[j] + " ");
			}
			System.out.println();
		}
		scaner.close();
	}

	private static void printGraph(Graph graph) {
		for (int i = 1; i <= graph.vertices; i++) {
			System.out.print(i + ":");
			Iterator<Integer> x = graph.edges[i].listIterator();
			while (x.hasNext()) {
				int n = x.next();
				System.out.print(n + ",");
			}
			System.out.println();
		}
	}

	private static void bfs(Graph graph, boolean[] visited, LinkedList<Integer> queue, int[] dist, int[][] adj) {

		if (queue.isEmpty())
			return;

		int cur_point;

		while (!queue.isEmpty()) {
			cur_point = queue.poll();
			Iterator<Integer> x = graph.edges[cur_point].listIterator();
			while (x.hasNext()) {
				int n = x.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
					dist[n] = dist[cur_point] + adj[cur_point][n];
				}
			}
		}
	}

	private static void printArrays(String[] nums) {
		for (String x : nums) {
			System.out.println(x);
		}
	}

}
