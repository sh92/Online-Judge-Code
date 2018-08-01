package sort.triangle;

import java.util.ArrayList;

public class Solution {
	public static int solution(int[] A) {
		ArrayList arr = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			arr.add(A[i]);
		}
		arr.sort(null);
		for (int i = 0; i + 2 < arr.size(); i++) {
			if (isTrianlge((int) arr.get(i), (int) arr.get(i + 1), (int) arr.get(i + 2))) {
				return 1;
			}
		}
		return 0;
	}

	private static boolean isTrianlge(long i, long j, long k) {
		if (i + j <= k)
			return false;
		if (i + k <= j)
			return false;
		if (k + j <= i)
			return false;
		return true;
	}

	public static void main(String[] args) {
		int[] A = new int[6];

		A[0] = 10;
		A[1] = 2;
		A[2] = 5;
		A[3] = 1;
		A[4] = 8;
		A[5] = 2;
		System.out.println(solution(A));
		int[] B = new int[4];
		B[0] = 10;
		B[1] = 50;
		B[2] = 5;
		B[3] = 1;
		System.out.println(solution(B));
	}
}
