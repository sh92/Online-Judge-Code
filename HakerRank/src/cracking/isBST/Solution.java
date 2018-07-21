package cracking.isBST;

import java.util.Set;

class Node {

	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}
}

public class Solution {

	public static boolean checkBST(Node root) {
		// Set<Integer> myset = new HashSet<Integer>();
		// return isBST2(root, myset);

		return isBST(root, -1, -1);
	}

	private static boolean isBST(Node root, int l, int h) {
		if (root == null) {
			return true;
		}

		if (l >= 0 && root.data <= l) {
			return false;
		}

		if (h >= 0 && root.data >= h) {
			return false;
		}

		return (isBST(root.left, l, root.data) && isBST(root.right, root.data, h));
	}

	private static boolean isBST2(Node root, Set<Integer> myset) {
		if (root == null) {
			return true;
		}
		if (myset.contains(root.data) || root.data < 0) {
			return false;
		} else {
			myset.add(root.data);
		}

		boolean isLeftBST = true, isRightBST = true;
		if (root.left != null) {
			if (root.left.data > root.data || root.left.data < 0) {
				return false;
			}
			isLeftBST = isBST2(root.left, myset);
		}

		if (root.right != null) {
			if (root.right.data < root.data || root.right.data < 0) {
				return false;
			}
			isRightBST = isBST2(root.right, myset);
		}

		return isLeftBST && isRightBST;
	}

	public static void main(String[] args) {

		Node root = new Node(4);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(7);

		// Node root = new Node(1);
		// root.left = new Node(2);
		// root.left.left = new Node(3);
		// root.left.right = new Node(5);
		// root.right = new Node(4);
		// root.right.left = new Node(6);
		// root.right.right = new Node(7);
		System.out.println(checkBST(root));
	}
}
