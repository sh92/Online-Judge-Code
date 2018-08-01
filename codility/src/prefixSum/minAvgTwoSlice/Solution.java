package prefixSum.minAvgTwoSlice;

public class Solution {
	// public static int solution(int[] A) {
	// int[] sum = new int[A.length];
	// sum[0] = A[0];
	// for (int i = 1; i < A.length; i += 1) {
	// sum[i] = sum[i - 1] + A[i];
	// }
	// double min = Integer.MAX_VALUE;
	// int minPos = 0;
	//
	// for (int slice = 2; slice <= A.length; slice++) {
	//
	// double tmp = sum[slice - 1] / (double) slice;
	// System.out.println(0 + ": " + slice + ": " + tmp);
	// if (tmp < min) {
	// min = tmp;
	// System.out.println("min:" + tmp);
	// minPos = 0;
	// }
	// }
	//
	// for (int i = 0; i < A.length - 1; i++) {
	// for (int slice = 2; slice + i < A.length; slice++) {
	//
	// double tmp = (sum[slice + i] - sum[i]) / (double) slice;
	// System.out.println(i + 1 + ": " + slice + ": " + tmp);
	// if (tmp < min) {
	// min = tmp;
	// System.out.println("min:" + tmp);
	// minPos = i + 1;
	// }
	// }
	// }
	//
	// return minPos;
	// }

	public static int solution(int[] A) {
		int minPos = 0;
		double min = Double.MAX_VALUE;
		for (int i = 0; i + 1 < A.length; i++) {
			double tmp = (double) (A[i + 1] + A[i]) / 2;
			if (tmp < min) {
				min = tmp;
				minPos = i;
			}
		}

		for (int i = 0; i + 2 < A.length; i++) {
			double tmp = (double) (A[i + 2] + A[i + 1] + A[i]) / 3;
			if (tmp < min) {
				min = tmp;
				minPos = i;
			}
		}

		return minPos;
	}

	public static void main(String[] args) {
		int N = 7;
		int[] A = new int[N];
		A[0] = 4;
		A[1] = 2;
		A[2] = 2;
		A[3] = 5;
		A[4] = 1;
		A[5] = 5;
		A[6] = 8;
		System.out.println(solution(A));
	}
}
