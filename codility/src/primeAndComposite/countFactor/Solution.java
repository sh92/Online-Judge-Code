package primeAndComposite.countFactor;

public class Solution {
	public static int solution(int N) {
		int cnt = 0;
		for (int i = 1; i <= (int) Math.sqrt(N); i++) {
			if (i * i == N) {
				cnt++;
			} else if (N % i == 0) {
				cnt += 2;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(solution(24));
	}
}
