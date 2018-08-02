package stackAndQueue.Fish;

import java.util.Stack;

public class Solution {
	static class Pair {
		double location;
		int size;
		int direction;

		public Pair(double location, int size, int direction) {
			this.location = location;
			this.size = size;
			this.direction = direction;
		}
	}

	public static int solution(int[] A, int[] B) {
		int cnt = 0;
		Stack<Integer> dstack = new Stack<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (B[i] == 0) {
				if (dstack.isEmpty()) {
					cnt++;
				} else {
					DownstreamStack: while (!dstack.empty()) {
						int dsize = dstack.pop();
						if (dsize > A[i]) {
							dstack.push(dsize);
							break DownstreamStack;
						}
					}
					if (dstack.isEmpty()) {
						cnt++;
					}
				}
			} else {
				dstack.push(A[i]);
			}
		}
		return dstack.size() + cnt;
	}
	// Solution O(N*2)
	// public static int solution(int[] A, int[] B) {
	// Stack<Pair> stack = new Stack<Pair>();
	// Stack<Pair> tmpStack = new Stack<Pair>();
	// for (int i = A.length - 1; i >= 0; i--) {
	// if (B[i] == 0) {
	// Pair pair = new Pair(i, A[i], -1);
	// stack.push(pair);
	// } else {
	// Pair pair = new Pair(i, A[i], 1);
	// stack.push(pair);
	// }
	// }
	// int cnt = 0;
	// while (stack.size() > 1) {
	// while (stack.size() >= 2) {
	// boolean n1isRemoved = false;
	// boolean n2isRemoved = false;
	// Pair n1 = stack.pop();
	// Pair n2 = stack.peek();
	//
	// if (n1.location == 0 && n1.direction == -1) {
	// cnt++;
	// n1isRemoved = true;
	// } else if (n1.location == A.length - 1 && n1.direction == 1) {
	// cnt++;
	// n1isRemoved = true;
	// }
	// if (n2.location == 0 && n2.direction == -1) {
	// cnt++;
	// n2isRemoved = true;
	// } else if (n2.location == A.length - 1 && n2.direction == 1) {
	// cnt++;
	// n2isRemoved = true;
	// }
	// if (n1.location == n2.location) {
	// if (n1.size > n2.size) {
	// n2isRemoved = true;
	// } else {
	// n1isRemoved = true;
	// }
	// }
	// if (!n1isRemoved) {
	// tmpStack.push(n1);
	// }
	// if (n2isRemoved) {
	// stack.pop();
	// }
	// }
	// while (!stack.isEmpty()) {
	// tmpStack.add(stack.pop());
	// }
	// while (!tmpStack.isEmpty()) {
	// Pair x = tmpStack.pop();
	// x.location = x.location + x.direction * 0.5;
	// stack.add(x);
	// }
	// }
	// return stack.size() + cnt;
	// }

	public static int solution2(int[] A, int[] B) {

		Stack<Pair> stack = new Stack<Pair>();
		Stack<Pair> tmpStack = new Stack<Pair>();

		for (int i = A.length - 1; i >= 0; i--) {
			if (B[i] == 0) {
				Pair pair = new Pair(i, A[i], -1);
				stack.push(pair);
			} else {
				Pair pair = new Pair(i, A[i], 1);
				stack.push(pair);
			}
		}

		int cnt = 0;
		while (stack.size() > 1) {
			System.out.println("stack size is " + stack.size());
			while (stack.size() >= 2) {
				boolean n1isRemoved = false;
				boolean n2isRemoved = false;
				Pair n1 = stack.pop();
				Pair n2 = stack.peek();

				System.out.println(n1.location + "(" + n1.size + "), " + n2.location + "(" + n2.size + ")");

				if (n1.location == 0 && n1.direction == -1) {
					cnt++;
					n1isRemoved = true;
				}

				if (n2.location == 0 && n2.direction == -1) {
					cnt++;
					n2isRemoved = true;

				}

				if (n1.location == A.length - 1 && n1.direction == 1) {
					cnt++;
					n1isRemoved = true;
				}

				if (n2.location == A.length - 1 && n2.direction == 1) {
					cnt++;
					n2isRemoved = true;
				}

				if (n1.location == n2.location) {
					if (n1.size > n2.size) {
						System.out.println("At " + n1.location + " : " + n1.size + " eat " + n2.size);
						n2isRemoved = true;
					} else {
						System.out.println("At " + n1.location + " : " + n2.size + " eat " + n1.size);
						n1isRemoved = true;
					}

				}
				if (!n1isRemoved) {
					tmpStack.push(n1);
				} else {
					System.out.println(n1.size + " is removed");
				}
				if (n2isRemoved) {
					System.out.println(n2.size + " is removed");
					stack.pop();
				}
			}
			while (!stack.isEmpty()) {
				tmpStack.add(stack.pop());
			}
			while (!tmpStack.isEmpty()) {
				Pair x = tmpStack.pop();
				x.location = x.location + x.direction * 0.5;
				stack.add(x);
			}
			System.out.println();
		}
		System.out.println(stack.size());
		System.out.println(cnt);

		return stack.size() + cnt;
	}

	public static void main(String[] args) {
		int[] A = new int[5];
		int[] B = new int[5];
		A[0] = 4;
		B[0] = 0;
		A[1] = 3;
		B[1] = 1;
		A[2] = 2;
		B[2] = 0;
		A[3] = 1;
		B[3] = 0;
		A[4] = 5;
		B[4] = 0;
		System.out.println(solution(A, B));
	}
}
