package timecomplexity.tapeEquilibrium;

public class Solution {
	public static int solution(int[] A) {
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		int psum = 0;
		for (int i = 0; i < A.length - 1; i++) {
			psum += A[i];
			int tmp = Math.abs(psum - (sum - psum));
			if (min > tmp) {
				min = tmp;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int N = 5;
		int[] A = new int[N];

		A[0] = 3;
		A[1] = 1;
		A[2] = 2;
		A[3] = 4;
		A[4] = 3;
		System.out.println(solution(A));

	}
}
