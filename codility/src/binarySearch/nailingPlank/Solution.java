package binarySearch.nailingPlank;

import java.util.Arrays;

public class Solution {

	public static int solution(int[] A, int[] B, int[] C) {
		int N = A.length;
		int M = C.length;
		int[][] sortedNail = new int[M][2];
		for (int i = 0; i < M; i++) {
			sortedNail[i][0] = i;
			sortedNail[i][1] = C[i];
		}

		Arrays.sort(sortedNail, (a, b) -> Integer.compare(a[1], b[1]));

		// Arrays.sort(sortedNail, (int[] x, int[] y) -> x[1] - y[1]);

		int numOfNails = 0;
		for (int i = 0; i < N; i++) {
			numOfNails = getMinIndex(A[i], B[i], sortedNail, numOfNails);
			if (numOfNails == -1)
				return -1;
		}
		return numOfNails + 1;
	}

	private static int getMinIndex(int startPlank, int endPlank, int[][] nail, int preIndex) {
		int min = 0;
		int max = nail.length - 1;
		int minIndex = -1;
		while (min <= max) {
			int mid = (min + max) / 2;
			if (nail[mid][1] < startPlank)
				min = mid + 1;
			else if (nail[mid][1] > endPlank)
				max = mid - 1;
			else {
				max = mid - 1;
				minIndex = mid;
			}
		}
		if (minIndex == -1)
			return -1;
		int MinNumOfNailsIndex = nail[minIndex][0];
		for (int i = minIndex; i < nail.length; i++) {
			if (nail[i][1] > endPlank)
				break;
			MinNumOfNailsIndex = Math.min(MinNumOfNailsIndex, nail[i][0]);
			if (MinNumOfNailsIndex <= preIndex)
				return preIndex;
		}
		return MinNumOfNailsIndex;
	}

	public static int solution2(int[] A, int[] B, int[] C) {
		int numOfPlanks = 0;
		int nails = 0;
		while (nails < C.length) {
			if (numOfPlanks == B.length) {
				break;
			}
			// System.out.println(nails);
			for (int j = numOfPlanks; j < B.length; j++) {
				if (A[j] <= C[nails] && C[nails] <= B[j]) {
					numOfPlanks++;
					// System.out.println(A[j] + " " + B[j]);
				}
			}
			nails++;
		}
		if (numOfPlanks == B.length) {
			return -1;
		}
		return nails;
	}

	public static void main(String[] args) {

		int[] A = new int[4];
		int[] B = new int[4];
		int[] C = new int[5];
		A[0] = 1;
		B[0] = 4;
		A[1] = 4;
		B[1] = 5;
		A[2] = 5;
		B[2] = 9;
		A[3] = 8;
		B[3] = 10;

		C[0] = 4;
		C[1] = 6;
		C[2] = 7;
		C[3] = 10;
		C[4] = 2;
		System.out.println(solution(A, B, C));
	}
}
