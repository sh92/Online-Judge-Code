package cracking.medianByHeap;

import java.util.Scanner;

public class Solution {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			int aItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			a[i] = aItem;
			printMedian(a, i);
		}

		scanner.close();
	}

	public void sort(int arr[], int last) {
		int n = last;
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);
		for (int i = n - 1; i >= 0; i--) {
			swap(arr, i, 0);
			heapify(arr, i, 0);
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	void heapify(int a[], int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && a[l] > a[largest])
			largest = l;

		if (r < n && a[r] > a[largest])
			largest = r;

		if (largest != i) {
			swap(a, i, largest);
			heapify(a, n, largest);
		}
	}

	private static void printMedian(int[] a, int last) {

		Solution sol = new Solution();
		sol.sort(a, last + 1);
		printArray(a);

		double result = 0.0;
		if (last % 2 == 0) {
			result = a[last / 2];
		} else {
			result = (a[last / 2] + a[last / 2 + 1]) / 2.0;
		}
		System.out.printf("%.1f\n", result);
	}

	private static void printArray(int[] a) {
		for (int x : a) {
			System.out.print(x + " ");
		}
	}
}
