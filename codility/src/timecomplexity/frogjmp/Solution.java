package timecomplexity.frogjmp;

public class Solution {

	public static boolean isInteger(String i) {
		try {
			Integer.parseInt(i);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static int solution(int X, int Y, int D) {
		double tmp = (Y - X) % D;
		if (tmp > 0) {
			return (Y - X) / D + 1;
		} else if (tmp == 0) {
			return (Y - X) / D;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		int X = 10, Y = 85, D = 30;
		System.out.println(solution(X, Y, D));
	}
}
