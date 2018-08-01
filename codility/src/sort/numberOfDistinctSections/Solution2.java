package sort.numberOfDistinctSections;

import java.util.Arrays;
import java.util.Comparator;

//50%
public class Solution2 {

	public static class Pair<L, R> {
		L left;
		R right;

		public Pair(L l, R r) {
			this.left = l;
			this.right = r;
		}

		private Object getRight() {
			return this.right;
		}

		private Object getLeft() {
			return this.left;
		}

		@Override
		public int hashCode() {
			return left.hashCode() ^ right.hashCode();
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Pair))
				return false;
			Pair po = (Pair) o;
			return this.left.equals(po.getLeft()) && this.right.equals(po.getRight());
		}

	}

	public static int solution(int[] A) {
		Pair[] pairs = new Pair[A.length];
		for (int i = 0; i < A.length; i++) {
			pairs[i] = new Pair(i - A[i], i + A[i]);
		}

		Comparator c = new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				int l1 = (int) p1.left;
				int l2 = (int) p2.left;
				if (l1 >= l2) {
					return 1;
				}
				return -1;
			}
		};
		Arrays.sort(pairs, c);
		// for (Pair p : pairs) {
		// int l = (int) p.left;
		// int r = (int) p.right;
		// System.out.print("(" + l + "," + r + ") ");
		// }
		// System.out.println();

		int j = 0;
		int intersection = 0;
		for (int i = 0; i < A.length; i++) {
			Pair p1 = pairs[i];
			int l1 = (int) p1.left;
			int r1 = (int) p1.right;
			for (j = i + 1; j < A.length; j++) {
				Pair p2 = pairs[j];
				int l2 = (int) p2.left;
				int r2 = (int) p2.right;
				if (r1 >= l2) {
					intersection++;
					if (intersection > 10000000)
						return -1;
				}
			}
		}
		return intersection;
	}

	public static void main(String[] args) {
		int[] A = new int[6];
		A[0] = 1;
		A[1] = 5;
		A[2] = 2;
		A[3] = 1;
		A[4] = 4;
		A[5] = 0;
		System.out.println(solution(A));
	}
}
