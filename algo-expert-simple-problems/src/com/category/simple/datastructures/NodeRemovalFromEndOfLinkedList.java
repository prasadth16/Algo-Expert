package com.category.simple.datastructures;
/**Program to remove Nth node from the end in the singly Linked List.
 * Please check the description of the problem in AlgoExpert.
 * Time Complexity: O(N) where n is the length of the linked list
 * Space Complexity: No extra space required and hence constant space is required.
 * **/
public class NodeRemovalFromEndOfLinkedList {
	static class Node {

		private int nodeId;
		private Node next;

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (nodeId != other.nodeId)
				return false;
			return true;
		}

		public Node() {
			super();
		}

		public Node(int nodeId, Node next) {
			super();
			this.nodeId = nodeId;
			this.next = next;
		}

		public int getNodeId() {
			return nodeId;
		}

		public void setNodeId(int nodeId) {
			this.nodeId = nodeId;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	private static Node traverseNumberOfNodes(Node pointer, int number) {
		int counter = 0;
		while (counter < number) {
			pointer=pointer.getNext();
			counter++;
		}
		
		return pointer;
	}

	public static Node removenthNodeFromEnd(Node header, int number) {
		Node pointer1 = header;
		Node pointer2 = header;
		Node pointer = header;
		pointer2=traverseNumberOfNodes(pointer2, number);
		int counter = 0;
		while (pointer2!= null) {
			pointer2=traverseNumberOfNodes(pointer2, 1);
			pointer1=traverseNumberOfNodes(pointer1, 1);
			if (counter > 0)
				pointer=traverseNumberOfNodes(pointer, 1);
			counter++;
		}
		pointer.setNext(pointer1.getNext());
		return header;
	}

	public static void main(String[] args) {
		Node th6 = new Node(6, null);
		Node th5 = new Node(5, th6);
		Node th4 = new Node(4, th5);
		Node th3 = new Node(3, th4);
		Node th2 = new Node(2, th3);
		Node th1 = new Node(1, th2);
		Node th0 = new Node(0, th1);
		Node opNode = removenthNodeFromEnd(th0, 4);
		while (opNode.getNext() != null) {
			System.out.println(opNode.getNodeId() + "->");
			opNode = opNode.getNext();
		}
	}
}
