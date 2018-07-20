package cracking.detectcycle;

import java.util.ArrayList;
import java.util.List;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}

}

public class DetectCycle {

	static boolean hasCycle(Node head) {

		if (head == null) {
			return false;
		}
		List<Node> list = new ArrayList<Node>();

		Node temp = head;
		list.add(temp);
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
			if (list.contains(temp)) {
				return true;
			}
			list.add(temp);
		}
		return false;
	}

	static boolean hasCycle2(Node head) {

		if (head == null) {
			return false;
		}
		Node temp1 = head;
		Node temp2 = head.next;
		while (temp1 != temp2) {
			if (temp2 == null || temp2.next == null) {
				return false;
			}
			temp1 = temp1.next;
			temp2 = temp2.next.next;
		}
		return true;
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.next = null;
		Node root2 = new Node(1);
		Node n1 = new Node(2);
		root2.next = n1;
		Node n2 = new Node(3);
		n1.next = n2;
		n2.next = n1;

		System.out.println(hasCycle(root));
		System.out.println(hasCycle(root2));
	}
}
