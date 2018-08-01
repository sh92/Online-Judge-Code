package prefixSum.passingCars;

public class Solution {
	static int solution(int A[], int N) {
		int cnt = 0;
		int posibbleCar = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				posibbleCar++;
			} else if (A[i] == 1) {
				cnt += posibbleCar;
				if (1000000000 < cnt) {
					return -1;
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		int N = 5;
		int[] A = new int[N];
		A[0] = 0;
		A[1] = 1;
		A[2] = 0;
		A[3] = 1;
		A[4] = 1;
		System.out.println(solution(A, N));

	}
}
