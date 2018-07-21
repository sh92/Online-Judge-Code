package isBalencedTree;

import java.util.HashSet;
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
		Set<Integer> myset = new HashSet<Integer>();
		return isBST(root, myset);
	}

	private static boolean isBST(Node root, Set<Integer> myset) {
		if (root == null) {
			return true;
		}
		if (myset.contains(root.data)) {
			return false;
		} else {
			myset.add(root.data);
		}

		boolean isLeftBST = true, isRightBST = true;
		if (root.left != null) {
			if (root.left.data > root.data) {
				return false;
			}
			isLeftBST = isBST(root.left, myset);
		}

		if (root.right != null) {
			if (root.right.data < root.data) {
				return false;
			}
			isRightBST = isBST(root.right, myset);
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
