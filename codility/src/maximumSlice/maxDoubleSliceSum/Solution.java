package maximumSlice.maxDoubleSliceSum;

public class Solution {
	public static int solution(int[] A) {
		if (A.length == 3) {
			return 0;
		}

		int max = -Integer.MAX_VALUE;
		int totalSum = 0;
		int[] sums = new int[A.length];
		int[] rsums = new int[A.length];
		int[] minSums = new int[A.length];
		int[] minrSums = new int[A.length];

		int findMin = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			totalSum += A[i];
			sums[i] = totalSum;
			if (findMin > totalSum) {
				findMin = totalSum;
			}
			minSums[i] = findMin;
		}

		findMin = Integer.MAX_VALUE;
		int rtotalSum = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			rtotalSum += A[i];
			rsums[i] += rtotalSum;
			if (findMin > rtotalSum) {
				findMin = rtotalSum;
			}
			minrSums[i] = findMin;
		}

		int m = 0;
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		for (int i = 1; i < A.length - 1; i++) {
			m = i;
			min1 = minSums[m - 1];
			min2 = minrSums[m + 1];
			if (max < totalSum - min1 - min2 - A[m]) {
				max = totalSum - min1 - min2 - A[m];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] A = new int[8];
		A[0] = 3;
		A[1] = 2;
		A[2] = 6;
		A[3] = -1;
		A[4] = 4;
		A[5] = 5;
		A[6] = -1;
		A[7] = 2;
		System.out.println(solution(A));
	}
}
