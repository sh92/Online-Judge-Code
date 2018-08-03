package primeAndComposite.flags;

import java.util.ArrayList;

public class Solution {

	public static int solution(int[] A) {
		ArrayList<Integer> peeks = new ArrayList<Integer>();
		for (int i = 1; i < A.length - 1; i++) {
			if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
				peeks.add(i);
			}
		}
		if (peeks.size() < 3) {
			return peeks.size();
		}
		for (int numOfFlags = peeks.size(); numOfFlags >= 1; numOfFlags--) {
			int cnt = 0;
			int skip = 0;
			int tmp = 0;
			int idx = peeks.get(0);
			cnt++;
			for (int i = 1; i < peeks.size(); i++) {
				tmp = idx + numOfFlags;
				if (tmp <= peeks.get(i)) {
					idx = peeks.get(i);
					cnt++;
				} else {
					skip++;
					if (peeks.size() - numOfFlags < skip) {
						break;
					}
				}
			}

			if (cnt >= numOfFlags) {
				return numOfFlags;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] A = new int[12];
		A[0] = 1;
		A[1] = 5;
		A[2] = 3;
		A[3] = 4;
		A[4] = 3;
		A[5] = 4;
		A[6] = 1;
		A[7] = 2;
		A[8] = 3;
		A[9] = 4;
		A[10] = 6;
		A[11] = 2;
		System.out.println(solution(A));
	}
}
