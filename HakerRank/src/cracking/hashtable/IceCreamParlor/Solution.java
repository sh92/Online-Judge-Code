package cracking.hashtable.IceCreamParlor;

import java.util.Hashtable;
import java.util.Scanner;

public class Solution {
	static void whatFlavors(int[] cost, int money) {
		Hashtable<Integer, Integer> hasntable = new Hashtable<>();
		for (int i = 0; i < cost.length; i++) {
			if (cost[i] < money) {
				if (hasntable.containsKey(money - cost[i])) {
					int index = hasntable.get(money - cost[i]);
					System.out.println((index + 1) + " " + (i + 1));
					return;
				}
				hasntable.put(cost[i], i);

			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int money = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] cost = new int[n];

			String[] costItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int costItem = Integer.parseInt(costItems[i]);
				cost[i] = costItem;
			}

			whatFlavors(cost, money);
		}

		scanner.close();
	}
}
