package cracking.tries.contacts;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static class Node {
		int count;
		Map<Character, Node> child = new HashMap<Character, Node>();

		public Node() {
			count = 1;
		}
	}

	public static class Trie {
		Node root;

		public Trie() {
			root = new Node();
		}

		public void add(String s) {
			Node cur = root;
			for (int i = 0; i < s.length(); i++) {
				if (cur.child.containsKey(s.charAt(i))) {
					cur = cur.child.get(s.charAt(i));
					cur.count++;
				} else {
					Node newNode = new Node();
					cur.child.put(s.charAt(i), newNode);
					cur = newNode;
				}
			}
		}

		public int find(String s) {
			Node cur = root;
			for (int i = 0; i < s.length(); i++) {
				if (cur.child.containsKey(s.charAt(i))) {
					cur = cur.child.get(s.charAt(i));
				} else {
					return 0;
				}
			}
			return cur.count;
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		Trie trie = new Trie();
		for (int nItr = 0; nItr < n; nItr++) {
			String[] opContact = scanner.nextLine().split(" ");

			String op = opContact[0];

			String contact = opContact[1];

			if (op.equals("add")) {
				trie.add(contact);
			} else if (op.equals("find")) {
				int num = trie.find(contact);
				System.out.println(num);
			}
		}

		scanner.close();
	}
}
