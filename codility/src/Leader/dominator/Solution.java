package Leader.dominator;

import java.util.HashMap;

public class Solution {
	public static int solution(int[] A) {
		if (A.length == 1)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			if (map.containsKey(A[i])) {
				map.put(A[i], map.get(A[i]) + 1);
				if (map.get(A[i]) > A.length / 2) {
					return i;
				}
			} else {
				map.put(A[i], 1);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] A = new int[8];
		A[0] = 3;
		A[1] = 4;
		A[2] = 3;
		A[3] = 2;
		A[4] = 3;
		A[5] = -1;
		A[6] = 3;
		A[7] = 3;
		System.out.println(solution(A));
	}
}
