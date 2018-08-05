package sievOfEratoshenes.countSemiPrimes;

public class Solution {
	public static int[] solution(int N, int[] P, int[] Q) {

		int[] semiCnt = SemiSieve(N);
		int M = P.length;
		int[] retArray = new int[M];

		for (int i = 0; i < M; i++) {
			if (Q[i] < 4) {
				retArray[i] = 0;
			} else {
				retArray[i] = semiCnt[Q[i]] - semiCnt[P[i] - 1];
			}
		}
		return retArray;
		// ArrayList<Integer> result = new ArrayList<>();
		// if (semi.length == 0) {
		// for (int i = 0; i < P.length; i++) {
		// result.add(0);
		// }
		// return result.stream().mapToInt(i -> i).toArray();
		// }
		// for (int i = 0; i < P.length; i++) {
		// int start = P[i];
		// int sIdx = binarySearch(semi, start);
		// int end = Q[i];
		// int eIdx = binarySearch(semi, end);
		// int ret = eIdx - sIdx - 1;
		// if (P[i] <= semi[sIdx]) {
		// ret++;
		// }
		// if (Q[i] >= semi[eIdx]) {
		// ret++;
		// }
		// result.add(ret);
		// }
		// return result.stream().mapToInt(i -> i).toArray();
	}

	private static int binarySearch(int[] semi, int value) {
		int low = 0;
		int high = semi.length - 1;
		int mid = (low + high) / 2;
		while (low < high) {
			mid = (int) (low + high) / 2;
			if (semi[mid] < value) {
				low = mid + 1;
			} else if (semi[mid] > value) {
				high = mid;
			} else {
				break;
			}
		}
		return low;
	}

	public static int[] SemiSieve(int N) {
		int[] primes = getSieve(N);
		int[] semiCntArray = new int[N + 1];
		int cnt = 0;
		for (int i = 4; i < semiCntArray.length; i++) {
			if (primes[i] != 0 && primes[i / primes[i]] == 0) {
				cnt++;
			}
			semiCntArray[i] = cnt;
		}
		return semiCntArray;
	}

	private static int[] getSieve(int N) {
		int[] sieve = new int[N + 1];
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (sieve[i] == 0) {
				for (int j = i * i; j <= N; j += i) {
					if (sieve[j] == 0) {
						sieve[j] = i;
					}
				}
			}
		}
		return sieve;
	}

	public static void main(String[] args) {
		int[] P = new int[3];
		int[] Q = new int[3];
		int N = 26;
		P[0] = 1;
		Q[0] = 26;
		P[1] = 4;
		Q[1] = 10;
		P[2] = 16;
		Q[2] = 20;
		int[] result = solution(N, P, Q);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
