package binarySearch.minMaxDivision;

public class Solution {

	public static int solution(int K, int M, int[] A) {
		long totalSum = 0;
		int findMaxElem = Integer.MIN_VALUE;

		for (int i = 0; i < A.length; i++) {
			totalSum += A[i];
			findMaxElem = Math.max(findMaxElem, A[i]);
		}

		long ret = totalSum;
		long maxSum = totalSum;
		long minSum = findMaxElem;
		while (minSum <= maxSum) {
			long midSum = (minSum + maxSum) / 2;
			if (checkDivisable(midSum, K, A)) {
				ret = midSum;
				maxSum = midSum - 1;
			} else {
				minSum = midSum + 1;
			}
		}

		return (int) ret;
	}

	private static boolean checkDivisable(long midSum, int k, int[] a) {
		int blockSum = 0;
		for (int i = 0; i < a.length; i++) {
			blockSum += a[i];
			if (blockSum > midSum) {
				k--;
				blockSum = a[i];
			}
			if (k == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int K = 3;
		int M = 5;
		int[] A = new int[7];
		A[0] = 2;
		A[1] = 1;
		A[2] = 5;
		A[3] = 1;
		A[4] = 2;
		A[5] = 2;
		A[6] = 2;
		System.out.println(solution(K, M, A));
	}
}
