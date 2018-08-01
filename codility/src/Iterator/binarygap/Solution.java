package Iterator.binarygap;

public class Solution {
	public static int solution(int N) {
		int start = 0;
		int end = 0;
		int max = 0;
		while (N != 0) {
			if ((N & 1) == 1) {
				if (end != start) {
					int temp = start - end;
					if (temp > max) {
						max = temp;
					}
					start++;
					end = start;
				} else {
					end++;
					start++;
				}
			} else {
				if (start != 0 && end != 0) {
					start++;
				}
			}
			N >>>= 1;
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(solution(32));
	}
}
