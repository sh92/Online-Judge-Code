package cracking.DavisStaircase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class Solution {

	static Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();

	static int stepPerms(int n) {
		if (n <= 0) {
			return 0;
		}

		if (n <= 2) {
			hashtable.put(n, n);
			return n;
		}
		if (n == 3) {
			hashtable.put(n, 4);
			return 4;
		}

		if (hashtable.containsKey(n)) {
			return hashtable.get(n);
		}

		int count = stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3);
		hashtable.put(n, count);
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("tmp/out"));

		int s = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int sItr = 0; sItr < s; sItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int res = stepPerms(n);
			System.out.println(res);
			// bufferedWriter.write(String.valueOf(res));
			// bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
