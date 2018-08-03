package greedy;

public class Solution {
	public static int solution(int[] A, int[] B) {
		if (A.length < 2) {
			return A.length;
		}
		int cnt = 1;
		int prevEnd = B[0];
		int N = A.length;

		for (int i = 1; i < N; i++) {
			if (prevEnd < A[i]) {
				cnt++;
				prevEnd = B[i];
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		int[] A = new int[5];
		int[] B = new int[5];

		A[0] = 1;
		B[0] = 1;
		A[1] = 2;
		B[1] = 2;
		A[2] = 1;
		B[2] = 1;
		A[3] = 3;
		B[3] = 3;
		A[4] = 1;
		B[4] = 1;
		System.out.println(solution(A, B));
	}
}
