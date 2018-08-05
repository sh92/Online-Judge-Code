package euclidan.chocolateByNum;

public class Solution {
	public static int solution(int N, int M) {
		return N / GCD(N, M);
	}

	private static int GCD(int n, int m) {
		if (n == 0) {
			return m;
		}
		if (m == 0) {
			return n;
		}
		return GCD(m, n % m);
	}

	public static void main(String[] args) {
		System.out.println(solution(10, 4));
	}
}
