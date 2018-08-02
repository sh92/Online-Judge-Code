package maximumSlice.maxSliceSum;

public class Solution {
	public static int solution(int[] A) {
		if (A.length == 1) {
			return A[0];
		}
		long[] sums = new long[A.length];
		long totalSum = 0;
		long[] minSums = new long[A.length];
		long minval = 0;
		for (int i = 0; i < A.length; i++) {
			totalSum += A[i];
			sums[i] = totalSum;
			if (minval > totalSum) {
				minval = totalSum;
			}
			minSums[i] = minval;
		}
		long max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			long tmp;
			if (i == 0) {
				tmp = A[i];
			} else {
				tmp = sums[i] - minSums[i - 1];
			}
			if (tmp > max) {
				max = tmp;
			}
		}
		return (int) max;
	}

	public static void main(String[] args) {
		int[] A = new int[5];
		// A[0] = -5;
		// A[1] = -11;
		A[0] = 3;
		A[1] = 2;
		A[2] = -6;
		A[3] = 4;
		A[4] = 0;
		System.out.println(solution(A));
	}
}
