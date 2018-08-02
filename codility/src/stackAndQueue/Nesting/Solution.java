package stackAndQueue.Nesting;

import java.util.Stack;

public class Solution {
	public static int solution(String S) {
		Stack<Character> stack = new Stack<Character>();
		char[] carr = S.toCharArray();
		if (S == "" || S == null) {
			return 0;
		}
		for (char c : carr) {
			switch (c) {
			case '(':
				stack.push('(');
				break;
			case ')':
				if (stack.isEmpty()) {
					return 0;
				} else {
					char r = stack.pop();
					if (r != '(') {
						return 0;
					}
				}
				break;
			default:
				break;
			}
		}
		if (stack.empty()) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		String S = "(()((())())";
		String S2 = "())";
		System.out.println(solution(S));
	}
}
