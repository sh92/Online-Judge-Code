package cracking.balancedbrackets;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static boolean isBalencedBracket(String expression) {
		char[] bracket = expression.toCharArray();
		Stack<String> stack = new Stack<String>();
		String c;
		for (int i = 0; i < bracket.length; i++) {
			if (bracket[i] == '{') {
				stack.push("{");
			} else if (bracket[i] == '[') {
				stack.push("[");
			} else if (bracket[i] == '(') {
				stack.push("(");
			} else {
				if (stack.isEmpty()) {
					return false;
				} else if (bracket[i] == ']') {
					c = stack.pop();
					if (!c.equals("[")) {
						return false;
					}
				} else if (bracket[i] == ')') {
					c = stack.pop();
					if (!c.equals("(")) {
						return false;
					}
				} else if (bracket[i] == '}') {
					c = stack.pop();
					if (!c.equals("{")) {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return stack.empty() ? true : false;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String expression = scanner.nextLine();
			if (isBalencedBracket(expression)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}

		scanner.close();
	}
}
