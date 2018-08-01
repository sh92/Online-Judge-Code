package countingElements.maxCounter;

public class Solution {
	public static int[] solution(int N, int[] A) {
		int[] ret = new int[N];
		int max = 0;
		int setMax = 0;

		for (int i = 0; i < A.length; i++) {
			int tmp = A[i];
			if (tmp == N + 1) {
				setMax = max;
			} else if (1 <= tmp && tmp <= N) {
				if (ret[tmp - 1] < setMax) {
					ret[tmp - 1] = setMax;
				}
				ret[tmp - 1]++;
				if (ret[tmp - 1] > max) {
					max = ret[tmp - 1];
				}
			}
		}
		for (int j = 0; j < N; j++) {
			if (ret[j] < setMax) {
				ret[j] = setMax;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int N = 5;
		int[] A = new int[7];
		A[0] = 3;
		A[1] = 4;
		A[2] = 4;
		A[3] = 6;
		A[4] = 1;
		A[5] = 4;
		A[6] = 4;
		int[] ret = solution(N, A);
		printArray(ret);
	}

	private static void printArray(int[] ret) {
		// TODO Auto-generated method stub
		for (int x : ret) {
			System.out.print(x + " ");
		}
	}
}
