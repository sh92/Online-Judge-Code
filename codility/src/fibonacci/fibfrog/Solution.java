package fibonacci.fibfrog;

public class Solution {
	static int save[] = new int[100000];

	public static int solution(int[] A) {
		if (A.length == 0) {
			return 1;
		}
		int[] paths = new int[A.length + 1];
		int[] fibs = new int[A.length < 2 ? 4 : A.length + 3];
		fibs[0] = 0;
		fibs[1] = 1;
		int fibCnt = 2;
		while (fibs[fibCnt - 1] <= A.length) {
			fibs[fibCnt] = fibs[fibCnt - 1] + fibs[fibCnt - 2];
			fibCnt++;
		}
		for (int target = 0; target <= A.length; target++) {
			if (target == A.length || A[target] == 1) {
				boolean assignedMin = false;
				int min = Integer.MAX_VALUE;
				for (int j = 2; j <= fibCnt; j++) {
					int from = target - fibs[j];
					if (from == -1) {
						assignedMin = true;
						min = 1;
						break;
					} else if (from < 0) {
						break;
					} else if (paths[from] > 0) {
						assignedMin = true;
						min = Math.min(min, paths[from] + 1);
					}
				}

				if (assignedMin) {
					paths[target] = min;
				}
			}
		}
		return paths[A.length] == 0 ? -1 : paths[A.length];
	}

	private static int fib(int n) {
		if (save[n] != 0) {
			return save[n];
		}
		if (n <= 1) {
			save[n] = n;
			return n;
		}
		if (n == 2) {
			save[n] = 1;
			return 1;
		}
		save[n] = fib(n - 1) + fib(n - 2);
		return save[n];
	}

	private static void prinArray(int[] paths) {
		for (int x : paths) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] A = new int[1];
		// A[0] = 1;
		// A[1] = 1;
		// A[2] = 1;
		// A[3] = 1;
		// A[4] = 1;
		// A[5] = 1;
		// A[6] = 1;
		// A[7] = 1;
		// A[8] = 1;
		// A[9] = 1;
		// A[10] = 1;
		// A[11] = 1;
		System.out.println(solution(A));
	}
}
