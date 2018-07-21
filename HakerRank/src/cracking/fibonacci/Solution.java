package cracking.fibonacci;

import java.util.Scanner;

public class Solution {
	public static int fibonacci(int n) {
		if (n < 2)
			return n;
		if (n == 2)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		System.out.println(fibonacci(n));
	}
}