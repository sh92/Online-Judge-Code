package catapilarMethod.countTriangles;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution2 {
	public static class Pair<L, R> {

		private final L left;
		private final R right;

		public Pair(L left, R right) {
			this.left = left;
			this.right = right;
		}

		public L getLeft() {
			return left;
		}

		public R getRight() {
			return right;
		}

		@Override
		public int hashCode() {
			return left.hashCode() ^ right.hashCode();
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Pair))
				return false;
			Pair pairo = (Pair) o;
			return this.left.equals(pairo.getLeft()) && this.right.equals(pairo.getRight());
		}

	}

	public static int solution(int[] A) {
		LinkedList<Pair> pairList = new LinkedList<Pair>();
		if (A.length < 3) {
			return 0;
		}
		Arrays.sort(A);
		int sum = 0;
		int limitIdx = A.length;
		for (int i = 0; i < A.length - 2; i++) {
			for (int j = i + 1; j < A.length - 1; j++) {
				if (A[j] > 1000000000) {
					limitIdx = j;
					continue;
				}
				Pair pair = new Pair(i, j);
				pairList.add(pair);
			}
		}
		for (int idx = 0; idx < pairList.size(); idx++) {
			Pair pair = pairList.get(idx);
			int i = (int) pair.left;
			int j = (int) pair.right;
//			System.out.println("A[i], A[j]: " + "(" + i + "," + j + ")" + "(" + A[i] + "," + A[j] + ")");
//			System.out.println("twoSum: " + twoSum);
			if (i + 2 >= limitIdx) {
				break;
			}
			if (j + 1 >= limitIdx) {
				continue;
			}
			int maxIdx = findMaxIdx(i, j, j + 1, A, limitIdx);
			System.out.println(maxIdx);
			for (int x = j + 1; x <= maxIdx; x++) {
				if (A[i] + A[j] > A[x]) {
					System.out.println("(" + i + "," + j + "," + x + ")");
					sum += 1;
				}
			}
		}
		return sum;
	}

	private static int findMaxIdx(int i, int j, int k, int[] A, int limit) {

		int low = k;
		int high = limit - 1;

		while (low < high) {
			int mid = (low + high) / 2;
			System.out.println("(" + low + "," + mid + "," + high + ")");
			if (A[mid] == A[i] + A[j]) {
				if (mid == low) {
					return low;
				} else {
					return mid - 1;
				}
			} else if (A[mid] > A[i] + A[j]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		int N = 6;
		int[] A = new int[N];
		A[0] = 10;
		A[1] = 2;
		A[2] = 5;
		A[3] = 1;
		A[4] = 8;
		A[5] = 12;
//		A[6] = 7;
//		A[7] = 8;
//		A[8] = 9;
		System.out.println(solution(A));
	}
}
