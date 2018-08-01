package sort.numberOfDistinctSections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

// 6%
public class Solution {

	public static class Point {
		int center;
		int radius;

		public Point(int center, int radius) {
			this.center = center;
			this.radius = radius;
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Point))
				return false;
			Point po = (Point) o;
			return this.center == po.center;
		}
	}

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
		ArrayList array = new ArrayList<Point>();
		HashSet hashSet = new HashSet<Pair>();
		for (int i = 0; i < A.length; i++) {
			Point point = new Point(i, A[i]);
			array.add(point);
		}

		Comparator c = new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if (p1.center < p2.center) {
					return -1;
				} else {
					return 1;
				}
			}
		};

		array.sort(c);
		for (int i = 0; i < array.size(); i++) {
			System.out.print(((Point) array.get(i)).center + " ");
		}
		System.out.println();

		for (int i = 0; i < array.size(); i++) {
			Point point1 = (Point) array.get(i);
			for (int j = i + 1; j < array.size(); j++) {
				Point point2 = (Point) array.get(j);
				if (hashSet.contains(new Pair(point1.center, point2.center))) {
					continue;
				}

				if (point1.center < point2.center) {
					if (point1.center + point1.radius > point2.center - point2.radius) {
						hashSet.add(new Pair(point1.center, point2.center));
					}
				} else {
					if (point2.center + point2.radius > point1.center - point1.radius) {
						hashSet.add(new Pair(point2.center, point1.center));
					}
				}
				if (hashSet.size() > 10000000)
					return -1;
			}
		}

		return hashSet.size();
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
