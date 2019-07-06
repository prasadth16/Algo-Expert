package com.category.simple.datastructures.tree;

import java.util.Optional;
/**Algorithm to find the Youngest Common Ancestor of two nodes.
 * Please see the discription of the problem in AlgoExpert.
 * Time Complexity: O(D) where D is the largest depth of one of the two input nodes.
 * Space Complexity: As this is not a recurssive algorithm and even not using any extra space, the space complexity is constant.
 * **/
public class YoungestCommonAncestorAlgorithm {

	static class Node {

		private int nodeId;
		private String nodeName;
		private Node ancestor;

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

		public Node(int nodeId, Node ancestor, String nodeName) {
			super();
			this.nodeId = nodeId;
			this.ancestor = ancestor;
			this.nodeName = nodeName;
		}

		public String getNodeName() {
			return nodeName;
		}

		public void setNodeName(String nodeName) {
			this.nodeName = nodeName;
		}

		public int getNodeId() {
			return nodeId;
		}

		public void setNodeId(int nodeId) {
			this.nodeId = nodeId;
		}

		public Node getAncestor() {
			return ancestor;
		}

		public void setAncestor(Node ancestor) {
			this.ancestor = ancestor;
		}

	}

	public static Node getYoungestCommonAncestor(Node node1, Node node2) {
		int node1Depth = findDepthOfNode(node1);
		int node2Depth = findDepthOfNode(node2);
		Node tmpNode = null;
		Node higherLevelNode = null;
		Optional<Node> optionalYoungestCommonAncestor = node1Depth > node2Depth
				? moveLevelsUp(node1, node1Depth - node2Depth)
				: moveLevelsUp(node2, node2Depth - node1Depth);
		if (node1Depth == node2Depth)
			optionalYoungestCommonAncestor = Optional.of(node1);
		if (optionalYoungestCommonAncestor.isPresent()) {
			tmpNode = optionalYoungestCommonAncestor.get();
			higherLevelNode = node1Depth >= node2Depth ? node2 : node1;
			if (tmpNode.equals(higherLevelNode))
				return tmpNode;
			while (tmpNode.getAncestor() != null && higherLevelNode.getAncestor() != null) {
				if (tmpNode.getAncestor().equals(higherLevelNode.getAncestor()))
					return tmpNode.getAncestor();
				tmpNode = tmpNode.getAncestor();
				higherLevelNode = higherLevelNode.getAncestor();
			}
		}
		return null;
	}

	private static int findDepthOfNode(Node node) {
		int counter = 0;
		Node tmpNode = node;
		while (tmpNode.getAncestor() != null) {
			counter++;
			tmpNode = tmpNode.getAncestor();
		}
		return counter;
	}

	private static Optional<Node> moveLevelsUp(Node node, int levels) {

		Node tmpNode = node;
		Optional<Node> optionalNode = Optional.empty();
		int counter = 0;
		while (counter <= levels) {
			if (tmpNode.getAncestor() == null) {
				break;
			}
			counter++;
			tmpNode = tmpNode.getAncestor();
			if (counter == levels) {
				optionalNode = Optional.of(tmpNode);
			}
		}

		return optionalNode;
	}

	public static void main(String[] args) {
		Node A = new Node(1, null, "A");
		Node B = new Node(2, A, "B");
		Node C = new Node(3, A, "C");
		Node D = new Node(4, A, "D");
		Node E = new Node(5, B, "E");
		Node F = new Node(6, B, "F");
		Node G = new Node(7, C, "G");
		Node H = new Node(8, C, "H");
		Node L = new Node(9, E, "L");
		Node M = new Node(10, F, "M");
		Node N = new Node(11, F, "N");
		Node O = new Node(12, F, "O");
		Node I = new Node(13, H, "I");
		Node J = new Node(14, H, "J");
		Node K = new Node(15, H, "L");
		// Node opNode=getYoungestCommonAncestor(H,K);
		//Node opNode = getYoungestCommonAncestor(F, G);
		Node opNode = getYoungestCommonAncestor(L, F);
		System.out.println(opNode.getNodeName());
	}

}
