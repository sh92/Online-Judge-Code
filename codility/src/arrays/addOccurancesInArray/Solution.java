package arrays.addOccurancesInArray;

public class Solution {
	public static int solution(int[] A) {
		int ret = 0;
		for (int i = 0; i < A.length; i++) {
			ret ^= A[i];
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] A = { 9, 3, 9, 3, 7, 9, 3, 9, 3 };
		int ret = solution(A);
		System.out.println(ret);
	}
}
