package cracking.dp.coinchange;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the ways function below.
	static long ways(int n, int[] coins) {
		long[] dp = new long[n + 1];
		dp[0] = 1;
		// printArray(coins);
		for (int x : coins) {
			for (int i = x; i < dp.length; i++) {
				dp[i] += dp[i - x];
			}
		}
		printArray(dp);
		return dp[n];
	}

	private static void printArray(long[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + " : " + arr[i]);
		}
		System.out.println();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("tmp/out"));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[] coins = new int[m];

		String[] coinsItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			int coinsItem = Integer.parseInt(coinsItems[i]);
			coins[i] = coinsItem;
		}

		long res = ways(n, coins);
		System.out.println(res);

		// bufferedWriter.write(String.valueOf(res));
		// bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
