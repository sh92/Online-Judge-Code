package sort.numberOfDistinctSections;

import java.util.Arrays;

public class Solution3 {

	// 81%
	// public static int solution(int[] A) {
	// int N = A.length;
	// BigInteger[] left = new BigInteger[N];
	// BigInteger[] right = new BigInteger[N];
	// for (int i = 0; i < N; i++) {
	// left[i] = BigInteger.valueOf(i);
	// left[i] = left[i].subtract(BigInteger.valueOf(A[i]));
	//
	// right[i] = BigInteger.valueOf(i);
	// right[i] = right[i].add(BigInteger.valueOf(A[i]));
	// }
	// Arrays.sort(left);
	// Arrays.sort(right);
	// int ret = 0;
	// int l = 0, r = 0;
	// for (r = 0; r < N; r++) {
	// while (l < N && right[r].compareTo(left[l]) >= 0) {
	// l++;
	// }
	// ret += l;
	// ret -= r + 1;
	// }
	// if (ret > 10000000)
	// return -1;
	// return ret;
	// }

	public static int solution(int[] A) {
		int N = A.length;
		long[] left = new long[N];
		long[] right = new long[N];
		for (int i = 0; i < N; i++) {
			left[i] = (long) i - (long) A[i];
			right[i] = (long) i + (long) A[i];
		}
		Arrays.sort(left);
		Arrays.sort(right);
		int ret = 0;
		int l = 0, r = 0;
		for (r = 0; r < N; r++) {
			while (l < N && left[l] <= right[r]) {
				l++;
			}
			ret += l;
			ret -= r + 1;
		}
		if (ret > 10000000)
			return -1;
		return ret;
	}

	public static void main(String[] args) {
		int[] A = new int[3];
		// A[0] = 1;
		// A[1] = 5;
		// A[2] = 2;
		// A[3] = 1;
		// A[4] = 4;
		// A[5] = 0;

		A[0] = 1;
		A[1] = Integer.MAX_VALUE;
		A[2] = 0;
		System.out.println(solution(A));
	}
}
