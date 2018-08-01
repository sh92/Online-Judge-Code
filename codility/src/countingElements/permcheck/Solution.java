package countingElements.permcheck;

public class Solution {
	public static int solution(int[] A) {
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = (sum ^ (i + 1)) % Integer.MAX_VALUE;
			sum = (sum ^ (A[i])) % Integer.MAX_VALUE;
		}
		return sum == 0 ? 1 : 0;
	}

	public static void main(String[] args) {
		int N = 4;
		int[] A = new int[N];

		A[0] = 4;
		A[1] = 1;
		A[2] = 3;
		A[3] = 2;

		System.out.println(solution(A));
	}
}
