package com.category.simple.datastructures.tree;

import java.util.Deque;
import java.util.LinkedList;

public class InvertedBinaryTree {

	static class TreeNode {
		private TreeNode leftReference;
		private TreeNode rightReference;
		private Integer data;

		public TreeNode() {

		}

		public TreeNode(TreeNode leftRef, TreeNode rightRef, Integer value) {

			leftReference = leftRef;
			rightReference = rightRef;
			data = value;
		}

		public TreeNode getLeftReference() {
			return leftReference;
		}

		public void setLeftReference(TreeNode reference) {
			leftReference = reference;
		}

		public TreeNode getRightReference() {
			return rightReference;
		}

		public void setRightReference(TreeNode reference) {
			rightReference = reference;
		}

		public Integer getNodeData() {
			return data;
		}

		public void setNodeData(Integer element) {
			data = element;
		}

	}

	/**
	 * Time Complexity is O(n) where n is the number of nodes in the tree.
	 * Space Complexity is O(d) where d is depth of the tree.
	 * depth of the tree is always log(n) and hence space complexity also
	 * can be expressed as O(logn).
	 * **/
	public static void invertBinaryTreeReccursively(TreeNode node) {
		if (node == null) {
			return;
		}
		TreeNode tmpNode = node.getLeftReference();
		node.setLeftReference(node.getRightReference());
		node.setRightReference(tmpNode);
		invertBinaryTreeReccursively(node.getLeftReference());
		invertBinaryTreeReccursively(node.getRightReference());
	}
	/**
	 * Time Complexity is O(n) where n is the number of nodes in the tree.
	 * Space Complexity is O(n/2) where n is number of nodes the tree.
	 * Reason: Max number of elements in the node stack will be all the leaf elments
	 * and the leaf elements are n/2 in the binary tree.
	 * **/
	public static void invertBinaryTreeIterativey(TreeNode node) {
		Deque<TreeNode> nodeStack = new LinkedList<>();
		TreeNode tmpNode = null;
		TreeNode tmpSwapNode = null;
		nodeStack.addLast(node);
		while (nodeStack.size() != 0) {
			tmpNode = nodeStack.pollFirst();
			if (tmpNode != null) {
				tmpSwapNode = tmpNode.getLeftReference();
				tmpNode.setLeftReference(tmpNode.getRightReference());
				tmpNode.setRightReference(tmpSwapNode);
				nodeStack.addLast(tmpNode.getLeftReference());
				nodeStack.addLast(tmpNode.getRightReference());
			}
		}
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(
				new TreeNode(new TreeNode(new TreeNode(null, null, 15), new TreeNode(), 47),
						new TreeNode(null, new TreeNode(null, null, 14), 2), 12),
				new TreeNode(new TreeNode(null, null, 6), new TreeNode(new TreeNode(null, null, 13), null, 10), 24),
				23);
		System.out.println("Inverting it in Recurssive way!!!");
		invertBinaryTreeReccursively(node);
		System.out.println("Done Inverting it in Recurssive way!!!");
		node = new TreeNode(
				new TreeNode(new TreeNode(new TreeNode(null, null, 15), new TreeNode(), 47),
						new TreeNode(null, new TreeNode(null, null, 14), 2), 12),
				new TreeNode(new TreeNode(null, null, 6), new TreeNode(new TreeNode(null, null, 13), null, 10), 24),
				23);
		System.out.println("Inverting it in Iterative way!!!");
		invertBinaryTreeIterativey(node);
		System.out.println("Done Inverting it in Iterative way!!!");
		
	}

}
