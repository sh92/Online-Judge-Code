package primeAndComposite.peaks;

import java.util.ArrayList;

public class Solution {
	public static int solution(int[] A) {
		ArrayList<Integer> peeks = new ArrayList<Integer>();
		for (int i = 1; i < A.length - 1; i++) {
			if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
				peeks.add(i);
			}
		}

		int N = A.length;
		for (int numOfBlocks = N; numOfBlocks >= 1; numOfBlocks--) {
			if (N % numOfBlocks == 0) {
				int blockSize = N / numOfBlocks;
				int ithBlock = 0;
				for (int pIndex : peeks) {
					if (pIndex / blockSize == ithBlock) {
						ithBlock++;
					}
				}
				if (ithBlock == numOfBlocks) {
					return numOfBlocks;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] A = new int[12];
		// A[0] = 2;
		// A[1] = 3;
		// A[2] = 5;
		// A[3] = 5;
		// A[4] = 7;
		// A[5] = 17;
		A[0] = 1;
		A[1] = 2;
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
