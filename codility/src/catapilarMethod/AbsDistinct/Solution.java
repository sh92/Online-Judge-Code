package catapilarMethod.AbsDistinct;

import java.util.HashSet;

public class Solution {
	public static int solution(int[] A) {
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < A.length; i++) {
			int number = Math.abs(A[i]);
			if (!set.contains(number)) {
				set.add(number);
			}
		}
		return set.size();
	}

	public static void main(String[] args) {
		int[] A = new int[6];
		A[0] = -5;
		A[1] = -3;
		A[2] = -1;
		A[3] = 0;
		A[4] = 3;
		A[5] = 6;
		System.out.println(solution(A));
	}
}
