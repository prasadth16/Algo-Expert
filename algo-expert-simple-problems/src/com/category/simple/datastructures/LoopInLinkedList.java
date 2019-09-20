package com.category.simple.datastructures;

/**
 * Read about this algorithm in my notes Space complexity=O(1) Time Complexity:
 * O(n) where n is number of nodes in the linked list.
 **/
public class LoopInLinkedList {

	private static class Node {
		private int value;
		private Node nextAddress;

		public Node() {
			super();
		}

		public Node(int value) {
			super();
			this.value = value;
		}

		public Node(int value, Node nextAddress) {
			super();
			this.value = value;
			this.nextAddress = nextAddress;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getNextAddress() {
			return nextAddress;
		}

		public void setNextAddress(Node nextAddress) {
			this.nextAddress = nextAddress;
		}
	}

	public static int getStartOfLoop(Node firstNode) {
		Node meetingNode = getMeetingNode(firstNode);
		int startOfLoop = 0;
		if (meetingNode == null) {
			System.out.println("No Loop in the Linked List.....");
		} else {
			startOfLoop = getStartingOfLoop(firstNode, meetingNode);
		}
		return startOfLoop;
	}

	private static Node getMeetingNode(Node firstNode) {
		Node firstP = firstNode.getNextAddress();
		Node secondP = firstNode.getNextAddress().getNextAddress();
		while (!(firstP.getValue() == secondP.getValue())) {
			firstP = firstP.getNextAddress();
			secondP = secondP.getNextAddress().getNextAddress();
		}

		return firstP;
	}

	private static int getStartingOfLoop(Node firstNode, Node meetingNode) {
		Node firstP = firstNode.getNextAddress();
		Node secondP = meetingNode.getNextAddress();
		while (!(firstP == secondP)) {
			firstP = firstP.getNextAddress();
			secondP = secondP.getNextAddress();

		}
		return firstP.getValue();
	}

	public static void main(String[] args) {
		Node _4 = new Node(4);
		Node _3 = new Node(3, _4);
		Node _2 = new Node(2, _3);
		Node _1 = new Node(1, _2);
		Node _9 = new Node(9, _4);
		Node _8 = new Node(8, _9);
		Node _7 = new Node(7, _8);
		Node _6 = new Node(6, _7);
		Node _5 = new Node(2, _6);
		_4.setNextAddress(_5);
		System.out.println("Begining of the loop is: " + getStartOfLoop(_1));
	}
}
