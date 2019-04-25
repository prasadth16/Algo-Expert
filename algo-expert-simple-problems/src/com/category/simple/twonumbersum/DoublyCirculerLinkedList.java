package com.category.simple.twonumbersum;

/**
 * This is Doubly-Circular Linked List Time Complexity: Add Node-: O(1) Remove
 * Node-: O(n) Find Node-O(n), In Doubly Circular Linked List, this can be done
 * in O(n/2)
 **/

public class DoublyCirculerLinkedList<T> {

	private Node headNode;

	class Node {
		private T data;
		private Node previous;
		private Node next;

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node getPrevious() {
			return previous;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!data.equals(other.data))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return this.data.toString() != null ? this.data.toString() : null;
		}

	}

	public DoublyCirculerLinkedList() {
		this.headNode = new Node();
		headNode.setNext(headNode);
		headNode.setPrevious(headNode);
	}

	public void addNode(T data) {
		Node newNode = new Node();
		newNode.setNext(headNode.getNext());
		newNode.setPrevious(headNode);
		headNode.getNext().setPrevious(newNode);
		headNode.setNext(newNode);
		newNode.setData(data);
	}

	public boolean removeNode(T data) {
		Node ipNode = new Node();
		ipNode.setData(data);
		return removeListNode(headNode, ipNode);
	}

	private boolean removeListNode(Node currentNode, Node ipNode) {
		if (!currentNode.equals(headNode) && ipNode.equals(currentNode)) {
			currentNode.getPrevious().setNext(currentNode.getNext());
			currentNode.getNext().setPrevious(currentNode.getPrevious());
			currentNode.setNext(null);
			currentNode.setPrevious(null);
			return true;
		}
		if (currentNode.getNext().equals(headNode))
			return false;

		return removeListNode(currentNode.getNext(), ipNode);
	}

	public boolean contains(T data) {
		Node ipNode = new Node();
		ipNode.setData(data);

		return recContains(headNode, ipNode);
	}

	private boolean recContains(Node currentNode, Node ipNode) {
		if (!currentNode.equals(headNode) && ipNode.equals(currentNode))
			return true;
		if (currentNode.getNext().equals(headNode))
			return false;

		return recContains(currentNode.getNext(), ipNode);
	}

	public void traverseList() {
		traverseAndPrintList(headNode);
	}

	private void traverseAndPrintList(Node ipNode) {
		if (!ipNode.equals(headNode))
			System.out.println(ipNode.toString());
		if (ipNode.getNext().equals(headNode))
			return;
		traverseAndPrintList(ipNode.getNext());

	}

	public void traverseReverse() {
		traverseReverseAndPrintList(headNode);
	}

	private void traverseReverseAndPrintList(Node ipNode) {
		if (!ipNode.equals(headNode))
			System.out.println(ipNode.toString());
		if (ipNode.getPrevious().equals(headNode))
			return;
		traverseReverseAndPrintList(ipNode.getPrevious());
	}
}