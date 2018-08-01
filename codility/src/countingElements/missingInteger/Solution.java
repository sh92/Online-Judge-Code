package countingElements.missingInteger;

public class Solution {
	public static int solution(int[] A) {
		boolean[] carr = new boolean[A.length + 1];
		carr[0] = true;
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= A.length && A[i] >= 1) {
				carr[A[i]] = true;
			}
		}
		for (int i = 1; i <= A.length; i++) {
			if (carr[i] == false) {
				return i;
			}
		}
		return A.length + 1;
	}

	public static void main(String[] args) {

		int N = 10;
		// int[] A = { 1, 3, 6, 4, 1, 2 };
		// int[] A = { 1, 2, 3 };
		int[] A = { -1, -3 };

		System.out.println(solution(A));
	}
}
