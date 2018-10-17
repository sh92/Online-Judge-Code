package catapilarMethod.countTriangles;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int N = 6;
		int[] A = new int[N];
		A[0] = Integer.MAX_VALUE;
		A[1] = Integer.MAX_VALUE;
		A[2] = Integer.MAX_VALUE;
		A[3] = 5;
		A[4] = 3;
		A[5] = 3;
//		A[6] = 7;
//		A[7] = 8;
//		A[8] = 9;
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {

		Arrays.sort(A);
		int cnt = 0;
		for (int p = 0; p < A.length - 2; p++) {
			int q = p + 1;
			int r = p + 2;
			System.out.println(p + "," + q + "," + r);
			while (r < A.length) {
				System.out.println(p + "," + q + "," + r);
				if (A[p] + A[q] > A[r]) {
					cnt += r - q;
					r++;
				} else if (q < r - 1) {
					q += 1;
				} else {
					r += 1;
					q += 1;
				}
			}
		}

		return cnt;
	}
}
