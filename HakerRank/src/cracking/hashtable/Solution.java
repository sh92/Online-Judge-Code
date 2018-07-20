package cracking.hashtable;

import java.util.Hashtable;
import java.util.Scanner;

public class Solution {

	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();

		for (String word : magazine) {
			if (hashtable.containsKey(word)) {
				hashtable.put(word, hashtable.get(word) + 1);
			} else {
				hashtable.put(word, 1);
			}
		}

		for (String word : note) {
			if (!hashtable.containsKey(word)) {
				System.out.println("No");
				return;
			}
			if (hashtable.get(word) == 1) {
				hashtable.remove(word);
			} else {
				hashtable.put(word, hashtable.get(word) - 1);
			}
		}
		System.out.println("Yes");
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}
}
