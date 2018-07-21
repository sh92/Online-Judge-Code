package cracking.medianByHeap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution2 {

	private static final Scanner scanner = new Scanner(System.in);
	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // keeps track of
																										// the SMALL
																										// numbers
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

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

	private static void printMedian(int[] a, int i) {
		addNumber(a[i]);
		System.out.println(getMedian());
	}

	private static double getMedian() {
		if (maxHeap.isEmpty()) {
			return 0.0;
		} else if (maxHeap.size() == minHeap.size()) {
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek();
		}
	}

	private static void addNumber(int n) {
		if (maxHeap.isEmpty()) {
			maxHeap.add(n);
		} else if (maxHeap.size() == minHeap.size()) {
			if (n < minHeap.peek()) {
				maxHeap.add(n);
			} else {
				minHeap.add(n);
				maxHeap.add(minHeap.remove());
			}
		} else if (maxHeap.size() > minHeap.size()) {
			if (n > maxHeap.peek()) {
				minHeap.add(n);
			} else {
				maxHeap.add(n);
				minHeap.add(maxHeap.remove());
			}
		}
	}

	private static void printArray(int[] a) {
		for (int x : a) {
			System.out.print(x + " ");
		}
	}
}
