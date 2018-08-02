package maximumSlice.maxProfit;

public class Solution {

	public static int solution(int[] A) {
		if (A.length <= 1) {
			return 0;
		}
		int max = -Integer.MAX_VALUE;
		int maxIdx = -1;
		int min = Integer.MAX_VALUE;
		int minIdx = -2;
		int maxdiff = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] < min) {
				if (minIdx < 0 || minIdx <= maxIdx) {
					min = A[i];
					minIdx = i;
				}
			}
			if (minIdx > maxIdx) {
				maxIdx = minIdx;
				max = min;
			}
			if (A[i] > max) {
				max = A[i];
				maxIdx = i;
				int tmp = max - min;
				if (tmp > maxdiff) {
					maxdiff = tmp;
				}
			}
			// System.out.println(minIdx + " " + maxIdx);
		}

		return maxdiff;
	}

	public static void main(String[] args) {
		int[] A = new int[6];
		A[0] = 23171;
		A[1] = 21011;
		A[2] = 21123;
		A[3] = 21366;
		A[4] = 21013;
		A[5] = 21367;
		System.out.println(solution(A));
	}
}
