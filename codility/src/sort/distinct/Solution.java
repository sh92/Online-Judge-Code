package sort.distinct;

import java.util.HashSet;

public class Solution {

	// Other solution: Quick Sort후(NlogN) + count(N)

	public static int solution(int[] A) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			set.add(A[i]);
		}
		return set.size();
	}

	public static void main(String[] args) {
		int N = 6;
		int[] A = new int[N];
		A[0] = 2;
		A[1] = 1;
		A[2] = 1;
		A[3] = 2;
		A[4] = 3;
		A[5] = 1;
		System.out.println(solution(A));
	}
}
