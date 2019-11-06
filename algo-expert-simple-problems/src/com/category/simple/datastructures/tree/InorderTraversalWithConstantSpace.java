package com.category.simple.datastructures.tree;

import org.junit.platform.commons.util.PreconditionViolationException;

public class InorderTraversalWithConstantSpace {

	public static void main(String[] arg) {
		Node one = new InorderTraversalWithConstantSpace.Node(1, null, null, null);
		Node two = new InorderTraversalWithConstantSpace.Node(2, one, null, null);
		Node three = new InorderTraversalWithConstantSpace.Node(3, one, null, null);
		one.setLeft(two);
		one.setRight(three);
		Node four = new InorderTraversalWithConstantSpace.Node(4, two, null, null);
		two.setLeft(four);
		Node six = new InorderTraversalWithConstantSpace.Node(6, three, null, null);
		Node seven = new InorderTraversalWithConstantSpace.Node(7, three, null, null);
		three.setLeft(six);
		three.setRight(seven);
		Node nine = new InorderTraversalWithConstantSpace.Node(9, four, null, null);
		four.setRight(nine);
		printNodeInorder(one);
	}

	private static class Node {
		private int value;
		private Node parent;
		private Node left;
		private Node right;

		public Node() {
			super();
		}

		public Node(int value, Node parent, Node left, Node right) {
			this.value = value;
			this.parent = parent;
			this.left = left;
			this.right = right;

		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public boolean equals(Node node) {
			if (this.hashCode() == node.hashCode()) {
				return true;
			}
			return false;
		}

	}

	private static void printNodeInorder(Node rootNode) {

		Node currentNode = rootNode;
		Node previousNode = null;
		while (currentNode != null) {
			// if traversing back up from left child
			if (null != previousNode && null != currentNode.getLeft() && previousNode.equals(currentNode.getLeft())) {
				System.out.println(currentNode.getValue());
				if (currentNode.getRight() != null) {
					previousNode = currentNode;
					currentNode = currentNode.getRight();
				} else {
					previousNode = currentNode;
					currentNode = currentNode.getParent();
				}
			}
			// if traversing down from a parent to the child
			else if ((null != previousNode && null != currentNode.getParent()
					&& previousNode.equals(currentNode.getParent())) || previousNode == null) {
				if (currentNode.getLeft() != null) {
					previousNode = currentNode;
					currentNode = currentNode.getLeft();
				} else if (currentNode.getRight() != null) {
					System.out.println(currentNode.getValue());
					previousNode = currentNode;
					currentNode = currentNode.getRight();
				} else {
					System.out.println(currentNode.getValue());
					previousNode = currentNode;
					currentNode = currentNode.getParent();
				}
			}
			// if traversing up from the right child
			else if (null != previousNode && null != currentNode.getRight()
					&& previousNode.equals(currentNode.getRight())) {
				previousNode = currentNode;
				currentNode = currentNode.getParent();
			}
		}
	}
}
