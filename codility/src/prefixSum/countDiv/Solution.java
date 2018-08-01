package prefixSum.countDiv;

public class Solution {
	// public static int solution(int A, int B, int K) {
	// int cnt = 0;
	// for (int i = A; i <= B; i++) {
	// if (i % K == 0) {
	// cnt++;
	// }
	// }
	// return cnt;
	// }

	public static int solution(int A, int B, int K) {
		if (K == 0)
			return 0;
		int quotientA = A / K;
		int quotientB = B / K;
		int remainderA = A % K;
		int c = 0;
		if (remainderA == 0)
			c++;
		return quotientB - quotientA + c;
	}

	public static void main(String[] args) {
		// int A = 8, B = 12, K = 4;
		// int A = 11, B = 345, K = 17; // 20
		int A = 0, B = 1, K = 11;
		// verify handling of range endpoints, multiple runs
		// int A = B in {0,1}, K = 11 //1
		// A = 10, B = 10, K in {5,7,20} //1
		System.out.println(solution(A, B, K));
	}
}
