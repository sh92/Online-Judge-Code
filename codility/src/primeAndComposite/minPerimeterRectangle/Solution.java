package primeAndComposite.minPerimeterRectangle;

public class Solution {
	public static int solution(int N) {
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= (int) Math.sqrt(N); i++) {
			System.out.println(i);
			if (i * i == N) {
				int tmp = 2 * (i + i);
				if (min > tmp) {
					min = tmp;
				}
			} else if (N % i == 0) {
				int tmp = 2 * (i + N / i);
				if (min > tmp) {
					min = tmp;
				}
			}
		}

		return min;
	}

	public static void main(String[] args) {
		int N = 36;
		System.out.println(solution(N));
	}
}
