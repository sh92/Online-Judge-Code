package Leader.equileader;

import java.util.HashMap;

public class Solution {
	public static int solution(int A[]) {
		if (A.length == 1)
			return 0;
		int leader = 0;
		boolean leaderFind = false;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			if (map.containsKey(A[i])) {
				map.put(A[i], map.get(A[i]) + 1);
				if (map.get(A[i]) > A.length / 2) {
					leader = A[i];
					leaderFind = true;
					break;
				}
			} else {
				map.put(A[i], 1);
			}
		}
		if (!leaderFind) {
			return 0;
		}

		int leaderCnt = 0;
		for (int i = 0; i < A.length; i++) {
			if (leader == A[i]) {
				leaderCnt++;
			}
		}
		int preLeader = 0;
		int cnt = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == leader) {
				preLeader++;
			}
			if (preLeader * 2 > (i + 1) && (leaderCnt - preLeader) * 2 > (A.length - (i + 1))) {
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		int N = 6;
		int[] A = new int[N];
		A[0] = 4;
		A[1] = 3;
		A[2] = 4;
		A[3] = 4;
		A[4] = 4;
		A[5] = 2;
		System.out.println(solution(A));
	}
}
