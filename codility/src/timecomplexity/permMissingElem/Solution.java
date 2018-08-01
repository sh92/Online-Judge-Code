package timecomplexity.permMissingElem;

public class Solution {
	public static int solution(int[] A) {
		int sum = 0;
		for (int i = 1; i <= A.length + 1; i++) {
			sum += i;
		}
		for (int i = 0; i < A.length; i++) {
			sum -= A[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] A = { 2, 3, 1, 5 };
		int ret = solution(A);
		System.out.println(ret);
	}
}
