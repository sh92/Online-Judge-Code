package catapilarMethod.countDistinctSlices;

public class Solution {
	public static int solution(int M, int[] A) {
		int cnt = 0;
		int end = 0;
		boolean[] visited = new boolean[M + 1];
		for (int start = 0; start < A.length; start++) {
			while (visited[A[start]]) {
				visited[A[end]] = false;
				end++;
			}
			visited[A[start]] = true;
			cnt += start - end + 1;
			if (cnt > 1000000000) {
				return 1000000000;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		int M = 6;
		int[] A = new int[5];
		A[0] = 3;
		A[1] = 4;
		A[2] = 5;
		A[3] = 5;
		A[4] = 2;
		System.out.println(solution(M, A));
	}
}
