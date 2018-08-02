package stackAndQueue.Brackets;

import java.util.Stack;

public class Solution {
	public static int solution(String S) {
		Stack<Character> stack = new Stack<Character>();
		char[] carr = S.toCharArray();
		for (char c : carr) {
			switch (c) {
			case '(':
				stack.push(c);
				break;
			case '{':
				stack.push(c);
				break;
			case '[':
				stack.push(c);
				break;
			case ')':
				if (stack.empty()) {
					return 0;
				} else {
					char r = stack.pop();
					if (r != '(') {
						return 0;
					}
				}
				break;
			case '}':
				if (stack.empty()) {
					return 0;
				} else {
					char r = stack.pop();
					if (r != '{') {
						return 0;
					}
				}
				break;
			case ']':
				if (stack.empty()) {
					return 0;
				} else {
					char r = stack.pop();
					if (r != '[') {
						return 0;
					}
				}
				break;
			default:
				break;
			}
		}
		if (stack.isEmpty()) {
			return 1;
		} else {
			return 0;
		}

	}

	public static void main(String[] args) {
		String s1 = "{[()()]}";
		String s2 = "([)()]";
		System.out.println(solution(s1));
		System.out.println(solution(s2));

	}
}
