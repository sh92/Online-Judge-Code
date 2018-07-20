package cracking.anagram;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	static int makeAnagram(String a, String b) {
		int[] freq1 = new int[26];
		int[] freq2 = new int[26];
		int deletions = 0;
		for (int i = 0; i < a.length(); i++)
			freq1[a.charAt(i) - 'a'] = freq1[a.charAt(i) - 'a'] + 1;
		for (int i = 0; i < b.length(); i++)
			freq2[b.charAt(i) - 'a'] = freq2[b.charAt(i) - 'a'] + 1;

		for (int i = 0; i < 26; i++)
			deletions += Math.abs(freq1[i] - freq2[i]);
		return deletions;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String a = scanner.nextLine();

		String b = scanner.nextLine();

		int res = makeAnagram(a, b);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
