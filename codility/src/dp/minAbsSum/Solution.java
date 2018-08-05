package dp.minAbsSum;

public class Solution {
	public static int solution(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			sum += Math.abs(A[i]);
			max = Math.max(max, Math.abs(A[i]));
		}

		int[] counts = new int[max + 1];
		for (int x : A) {
			counts[Math.abs(x)]++;
		}

		int[] dp = new int[sum + 1];
		for (int i = 0; i <= sum; i++) {
			dp[i] = -1;
		}
		dp[0] = 0;
		for (int i = 1; i < counts.length; i++) {
			if (counts[i] == 0) {
				continue;
			}
			for (int j = 0; j <= sum; j++) {
				if (dp[j] >= 0) {
					dp[j] = counts[i];
				} else if (j >= i && dp[j - i] > 0) {
					dp[j] = dp[j - i] - 1;
				}
				System.out.println(j + " " + dp[j]);
			}
		}
		int result = sum;
		for (int p = 0; sum - 2 * p >= 0; p++) {
			if (dp[p] >= 0) {
				int diff = sum - p - p;
				result = Math.min(result, diff);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] A = new int[5];
		A[0] = 5;
		A[1] = 4;
		A[2] = 3;
		A[3] = 2;
		A[4] = 1;

		// A[0] = 1;
		// A[1] = 5;
		// A[2] = 2;
		// A[3] = -2;
		System.out.println(solution(A));
	}
}
