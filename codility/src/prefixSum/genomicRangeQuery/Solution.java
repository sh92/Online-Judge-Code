package prefixSum.genomicRangeQuery;

public class Solution {
	// O(N+M)
	public static int[] solution(String S, int[] P, int[] Q) {
		int[] ret = new int[P.length];

		int[] A = new int[S.length()];
		int[] C = new int[S.length()];
		int[] G = new int[S.length()];

		switch (S.charAt(0)) {
		case 'A':
			A[0]++;
			break;
		case 'C':
			C[0]++;
			break;
		case 'G':
			G[0]++;
			break;
		}

		for (int i = 1; i < S.length(); i++) {
			char c = S.charAt(i);
			SwitchBreak: switch (c) {
			case 'A':
				A[i] = A[i - 1] + 1;
				C[i] = C[i - 1];
				G[i] = G[i - 1];
				break SwitchBreak;
			case 'C':
				A[i] = A[i - 1];
				C[i] = C[i - 1] + 1;
				G[i] = G[i - 1];
				break SwitchBreak;

			case 'G':
				A[i] = A[i - 1];
				C[i] = C[i - 1];
				G[i] = G[i - 1] + 1;
				break SwitchBreak;
			default:
				A[i] = A[i - 1];
				C[i] = C[i - 1];
				G[i] = G[i - 1];
				break SwitchBreak;
			}
		}

		for (int i = 0; i < P.length; i++) {
			if (P[i] > 0) {
				if (A[Q[i]] > A[P[i] - 1]) {
					ret[i] = 1;
				} else if (C[Q[i]] > C[P[i] - 1]) {
					ret[i] = 2;
				} else if (G[Q[i]] > G[P[i] - 1]) {
					ret[i] = 3;
				} else {
					ret[i] = 4;
				}
			} else {

				if (A[Q[i]] > 0) {
					ret[i] = 1;
				} else if (C[Q[i]] > 0) {
					ret[i] = 2;
				} else if (G[Q[i]] > 0) {
					ret[i] = 3;
				} else {
					ret[i] = 4;
				}

			}
		}

		return ret;
	}

	// O(N*M)
	// public static int[] solution(String S, int[] P, int[] Q) {
	// int[] ret = new int[P.length];
	// int idx[] = new int[S.length()];
	// for (int j = 0; j < S.length(); j++) {
	// char c = S.charAt(j);
	// switch (c) {
	// case 'A':
	// idx[j] = 1;
	// break;
	// case 'C':
	// idx[j] = 2;
	// break;
	// case 'G':
	// idx[j] = 3;
	// break;
	// case 'T':
	// idx[j] = 4;
	// break;
	// default:
	// break;
	// }
	// }
	// for (int i = 0; i < P.length; i++) {
	// int min = Integer.MAX_VALUE;
	// breakOut: for (int j = P[i]; j <= Q[i]; j++) {
	// if (idx[j] == 1) {
	// ret[i] = 1;
	// break breakOut;
	// } else {
	// if (min > idx[j]) {
	// min = idx[j];
	// }
	// }
	// ret[i] = min;
	// }
	// }
	//
	// return ret;
	// }

	public static void main(String[] args) {
		int[] P = new int[3];
		int[] Q = new int[3];
		P[0] = 2;
		Q[0] = 4;
		P[1] = 5;
		Q[1] = 5;
		P[2] = 0;
		Q[2] = 6;
		String S = "CAGCCTA";
		int[] ret = solution(S, P, Q);
		for (int x : ret) {
			System.out.print(x + " ");
		}
	}
}
