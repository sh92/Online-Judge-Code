package com.hackerank;

import java.util.Scanner;

public class Solution {

	public static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	public static int sort(int[] a) {

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

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int numofSwaps = sort(a);
		System.out.println("Array is sorted in " + numofSwaps + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[n - 1]);
	}
}