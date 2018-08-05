package catapilarMethod.countDistinctSlices;

public class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return x ^ y;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Pair)) {
			return false;
		}
		Pair p = (Pair) o;
		int x2 = p.x;
		int y2 = p.y;
		return ((x == x2) && (y == y2)) || ((x == y2) && (y == x2));
	}

}
