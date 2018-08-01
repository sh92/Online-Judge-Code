package sort.maxProProductOfTree;

import java.util.ArrayList;

public class Solution {
	static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot);
			quickSort(arr, pivot + 1, right);
		}
	}

	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];
		while (left < right) {
			while (arr[left] < arr[pivot]) {
				left++;
			}
			while (arr[right] > arr[pivot]) {
				right--;
			}
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		return left;
	}

	public static int solution(int[] A) {

		int max = Integer.MIN_VALUE;
		ArrayList array = new ArrayList<Integer>();
		boolean hasZero = false;
		int plen = 0;
		int nlen = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				plen++;
			} else if (A[i] < 0) {
				nlen++;
			} else {
				hasZero = true;
			}
			array.add(A[i]);
		}
		array.sort(null);
		int size = array.size();

		int tmp = (int) array.get(size - 1) * (int) array.get(size - 2) * (int) array.get(size - 3);
		if (tmp > max) {
			max = tmp;
		}
		if (plen >= 1 && nlen >= 2) {
			tmp = (int) array.get(0) * (int) array.get(1) * (int) array.get(size - 1);
			if (tmp > max) {
				max = tmp;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int N = 6;
		int[] A = new int[N];
		A[0] = -3;
		A[1] = 1;
		A[2] = 2;
		A[3] = -2;
		A[4] = 5;
		A[5] = 6;
		System.out.println(solution(A));
	}
}
