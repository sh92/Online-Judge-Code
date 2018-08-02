package stackAndQueue.stonWall;

import java.util.Stack;

public class Solution {
	public static int solution(int[] H) {
		Stack<Integer> stack = new Stack<Integer>();
		int cnt = 0;
		for (int i = 0; i < H.length; i++) {
			if (stack.isEmpty()) {
				stack.push(H[i]);
			} else {
				int x = stack.peek();
				if (x == H[i]) {
				} else if (x < H[i]) {
					stack.push(H[i]);
				} else {
					findSmallElem: while (true) {
						if (stack.isEmpty()) {
							stack.push(H[i]);
							break findSmallElem;
						}
						x = stack.peek();
						if (x > H[i]) {
							stack.pop();
							cnt++;
						} else if (x == H[i]) {
							break findSmallElem;
						} else {
							stack.push(H[i]);
							break findSmallElem;
						}
					}
				}
			}
		}
		return stack.size() + cnt;
	}

	public static void main(String[] args) {
		int[] H = new int[9];
		H[0] = 8;
		H[1] = 8;
		H[2] = 5;
		H[3] = 7;
		H[4] = 9;
		H[5] = 8;
		H[6] = 7;
		H[7] = 4;
		H[8] = 8;
		System.out.println(solution(H));
	}
}
