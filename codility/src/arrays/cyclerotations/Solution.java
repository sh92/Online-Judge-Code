package arrays.cyclerotations;

public class Solution {
	public static int[] solution(int[] A, int K) {
		int[] tmp = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			tmp[(i + K) % A.length] = A[i];
		}
		return tmp;
	}

	public static void main(String[] args) {
		int[] A = { 3, 8, 9, 7, 6 };
		int K = 3;
		int[] ret = solution(A, K);

		for (int r : ret) {
			System.out.print(r + " ");
		}
	}
}
