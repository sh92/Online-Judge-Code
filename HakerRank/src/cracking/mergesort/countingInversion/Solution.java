package cracking.mergesort.countingInversion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	static int cnt = 0;

	static long countInversions(int[] arr) {
		return countInversionUtil(arr, 0, arr.length - 1);
	}

	private static long countInversionUtil(int[] arr, int start, int last) {
		if (start >= last) {
			return 0;
		}
		long count = 0;
		int middle = (start + last) / 2;
		count += countInversionUtil(arr, start, middle);
		count += countInversionUtil(arr, middle + 1, last);
		return merge(arr, start, middle, last, count);
	}

	static void printArray(int[] arr) {
		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	private static long merge(int[] arr, int start, int middle, int last, long count) {
		int leftIdx = start;
		int rightIdx = middle + 1;
		int[] sorted = new int[last - start + 1];

		for (int i = 0; i < sorted.length; i++) {
			if (rightIdx > last || (leftIdx <= middle && arr[leftIdx] <= arr[rightIdx])) {
				sorted[i] = arr[leftIdx++];
			} else {
				sorted[i] = arr[rightIdx++];
				count += middle - leftIdx + 1;
			}
		}

		for (int i = start; i <= last; i++) {
			arr[i] = sorted[i - start];
		}

		return count;
	}

	private static Scanner scanner;

	public static void main(String[] args) throws IOException {
		scanner = new Scanner(System.in);
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("tmp/out"));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] arr = new int[n];
			scanner = new Scanner(System.in);
			String[] arrItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			for (int i = 0; i < n; i++) {
				int arrItem = Integer.parseInt(arrItems[i]);
				arr[i] = arrItem;
			}
			long result = countInversions(arr);
			System.out.println(result);
			// bufferedWriter.write(String.valueOf(result));
			// bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();

		scanner.close();
	}
}
