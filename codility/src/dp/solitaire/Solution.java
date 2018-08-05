package dp.solitaire;

public class Solution {
	public static int solution(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int[] maxDp = new int[A.length];
		maxDp[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			int max = Integer.MIN_VALUE;
			if (i < 6) {
				for (int k = 1; k <= i; k++) {
					max = Math.max(max, maxDp[i - k]);
				}
			} else {
				for (int k = 1; k <= 6; k++) {
					max = Math.max(max, maxDp[i - k]);
				}
			}
			maxDp[i] = max + A[i];
		}
		return maxDp[A.length - 1];
	}

	public static void main(String[] args) {
		int[] A = new int[6];
		A[0] = 1;
		A[1] = -2;
		A[2] = 0;
		A[3] = 9;
		A[4] = -1;
		A[5] = -2;
		System.out.println(solution(A));
	}
}
