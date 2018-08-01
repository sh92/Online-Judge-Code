package countingElements.frogRiverOne;

public class Solution {
	public static int solution(int X, int[] A) {

		boolean[] leaved = new boolean[X + 1];
		leaved[0] = true;
		int cnt = 0;
		for (int i = 0; i < A.length; i++) {
			int tmp = A[i];
			if (tmp <= X) {
				if (leaved[tmp] == false) {
					leaved[tmp] = true;
					cnt++;
				}
				if (cnt == X) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int N = 8;
		int X = 5;
		int[] A = new int[N];
		A[0] = 1;
		A[1] = 3;
		A[2] = 1;
		A[3] = 4;
		A[4] = 2;
		A[5] = 3;
		A[6] = 5;
		A[7] = 4;
		System.out.println(solution(X, A));
	}
}
