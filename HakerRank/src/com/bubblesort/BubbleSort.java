package com.bubblesort;

public class BubbleSort {

	public BubbleSort() {
	}

	public void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	public int sort(int[] a) {

		int numberOfSwaps = 0;
		int n = a.length;
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					numberOfSwaps++;
				}
			}

			if (numberOfSwaps == 0) {
				break;
			}
		}
		return numberOfSwaps;
	}

}
