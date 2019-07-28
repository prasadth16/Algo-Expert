package com.category.simple.datastructures.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Program to calculate maximum path sum in the binary tree For More
 * explaination Please check AlgoExpert Time Complexity: O(n) where n is the
 * number of nodes in a given binary tree. As we visit every node in a tree the
 * time complexity is O(n). Space Complexity: O(log n) As Maximum number of
 * method calls on the call stack at same time will be log n.
 **/
public class MaxPathSumInBinaryTreeAlgorithm {

	static class Node {
		private Integer value;
		private Node rightChildNode;
		private Node leftChildNode;

		public Node() {
			super();
		}

		public Node(Integer value, Node rightChildNode, Node leftChildNode) {
			super();
			this.value = value;
			this.rightChildNode = rightChildNode;
			this.leftChildNode = leftChildNode;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public Node getRightChildNode() {
			return rightChildNode;
		}

		public void setRightChildNode(Node rightChildNode) {
			this.rightChildNode = rightChildNode;
		}

		public Node getLeftChildNode() {
			return leftChildNode;
		}

		public void setLeftChildNode(Node leftChildNode) {
			this.leftChildNode = leftChildNode;
		}

	}

	public static int findMaxPathSum(Node node) {
		Map<String, Integer> result = findMaxPath(node);
		return result.get("maxTotal") >= result.get("triangleSum") ? result.get("maxTotal") : result.get("triangleSum");
	}

	private static Map<String, Integer> findMaxPath(Node rootNode) {
		Map<String, Integer> result = new HashMap<>();
		if (rootNode == null) {
			result.put("maxTotal", 0);
			result.put("triangleSum", 0);
			return result;
		}
		Map<String, Integer> rightSubTreeResult = findMaxPath(rootNode.getRightChildNode());
		Map<String, Integer> leftSubTreeResult = findMaxPath(rootNode.getLeftChildNode());
		if (rightSubTreeResult.get("maxTotal") + rootNode.getValue() >= leftSubTreeResult.get("maxTotal")
				+ rootNode.getValue()) {
			result.put("maxTotal", rightSubTreeResult.get("maxTotal") + rootNode.getValue());
		} else {
			result.put("maxTotal", leftSubTreeResult.get("maxTotal") + rootNode.getValue());
		}
		int greater = returnMax(rightSubTreeResult.get("triangleSum"), leftSubTreeResult.get("triangleSum"),
				rootNode.getValue() + rightSubTreeResult.get("maxTotal") + leftSubTreeResult.get("maxTotal"));
		if (greater == 1) {
			result.put("triangleSum", rightSubTreeResult.get("triangleSum"));
		} else if (greater == 2) {
			result.put("triangleSum", leftSubTreeResult.get("triangleSum"));
		} else {
			result.put("triangleSum",
					rootNode.getValue() + rightSubTreeResult.get("maxTotal") + leftSubTreeResult.get("maxTotal"));
		}

		return result;
	}

	private static int returnMax(int val1, int val2, int val3) {
		if (val1 >= val2 && val1 >= val3)
			return 1;
		else if (val2 >= val1 && val2 >= val3)
			return 2;
		else
			return 3;
	}

	public static void main(String[] args) {
		Node _2 = new Node(2, null, null);
		Node _34 = new Node(34, null, null);
		Node _26 = new Node(26, null, null);
		Node _25 = new Node(25, null, null);
		Node _13 = new Node(13, null, null);
		Node _4 = new Node(4, null, _2);
		Node _9 = new Node(9, null, _34);
		Node _11 = new Node(11, _25, _26);
		Node _20 = new Node(20, _13, null);
		Node _7 = new Node(7, _9, _4);
		Node _5 = new Node(5, _20, _11);
		Node _10 = new Node(10, _5, _7);

		System.out.println(findMaxPathSum(_10));

		Node _31 = new Node(31, null, null);
		Node _28 = new Node(28, null, null);
		Node __4 = new Node(4, null, null);
		Node __5 = new Node(5, null, null);
		Node __9 = new Node(9, null, null);
		Node _16 = new Node(16, null, null);
		Node _17 = new Node(17, _28, _31);
		Node __25 = new Node(25, __5, __4);
		Node _100 = new Node(-100, _25, _17);
		Node __7 = new Node(7, _16, __4);
		Node __20 = new Node(20, __7, _100);

		System.out.println(findMaxPathSum(__20));

	}
}
